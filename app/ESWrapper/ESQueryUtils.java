package ESWrapper;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.geo.builders.ShapeBuilders;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import utils.TimeUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ESQueryUtils {


    public static QueryBuilder getESTermQueryBuilder(String termField, String termValue) {
        return QueryBuilders.termQuery(termField, termValue);
    }

    public static QueryBuilder getEsTermsQueryBuilder(String termField, List values) {
        return QueryBuilders.termsQuery(termField,values).boost(0);
    }

    public static QueryStringQueryBuilder getQueryStringBuilder(String query, List<String> searchFields, String analyzer, int phraseSlop) {
        QueryStringQueryBuilder queryBuilder = QueryBuilders.queryStringQuery(query).useDisMax(false);
        for(String field:searchFields){
            queryBuilder.field(field);
        }
        queryBuilder=phraseSlop>0?queryBuilder.phraseSlop(phraseSlop):queryBuilder;
        return queryBuilder.analyzer(analyzer);
    }


    public static RangeQueryBuilder getRangeQueryBuilder(String field,Long toValue,Long fromValue,boolean isUpperIncluded,boolean isLowerIncluded){
        return QueryBuilders.rangeQuery(field).gte(toValue).lt(fromValue).includeLower(isUpperIncluded).includeUpper(isLowerIncluded);
    }

    public static QueryBuilder getTimeRangeQuery(String timeField,TimeUtils timeUtils, String queryType){
        return getRangeQueryBuilder(timeField,timeUtils.getSinceTime(),timeUtils.getUntilTime(),true,true);
    }

    public static QueryBuilder getBoolQueryBuilder(List<QueryBuilder> boolFilters) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        for (QueryBuilder queryBuilder : boolFilters) {
            boolQueryBuilder.must(queryBuilder);
        }
        return boolQueryBuilder;
    }

    public static QueryBuilder getESQueryBuilder(QueryBuilder queryBuilder) {
        return QueryBuilders.constantScoreQuery(queryBuilder);
    }

    public static SearchRequestBuilder getFieldAggregationBuilder(SearchRequestBuilder searchRequestBuilder,String field,int size){
      return searchRequestBuilder.addAggregation(AggregationBuilders.terms("aggObject").field(field).size(size));
    }

    private static SearchRequestBuilder addStoredFields(SearchRequestBuilder searchRequestBuilder, List<String> fields) {
        for (String x : fields) {
            searchRequestBuilder.storedFields(x);
        }
        return searchRequestBuilder;
    }

    public static long getSearchResponseHitCount(SearchResponse response){
        return response.getHits().getTotalHits();
    }

   public static QueryBuilder getGeoShapeQueryBuilder(String field, Double lat, Double longi, Double radius,DistanceUnit distanceUnit) throws IOException {
        QueryBuilder geoQueryBuilder=QueryBuilders.boolQuery().should(QueryBuilders.geoShapeQuery(field, ShapeBuilders.newCircleBuilder().center(lat, longi).radius(radius,distanceUnit)));
        return geoQueryBuilder;
    }

    public static BoolQueryBuilder getBoolMustQueryBuilder(BoolQueryBuilder boolQueryBuilder,List<QueryBuilder> queryBuilderList ) {
        for (QueryBuilder queryBuilder : queryBuilderList) {
            boolQueryBuilder.must(queryBuilder);
        }
        return boolQueryBuilder;
    }

    public static BoolQueryBuilder getBoolShouldQueryBuilder(BoolQueryBuilder boolQueryBuilder,List<QueryBuilder> queryBuilderList ) {
        for (QueryBuilder queryBuilder : queryBuilderList) {
            boolQueryBuilder.should(queryBuilder);
        }
        return boolQueryBuilder;
    }

    public static QueryBuilder getWrappedQueryBuilder(String queryString) {
        return QueryBuilders.wrapperQuery(queryString);
    }

    public static BoolQueryBuilder getBoolTermQuery(String termField,List<String> termValues){
        return new BoolQueryBuilder().must(getEsTermsQueryBuilder(termField,termValues));
    }

    public static Map<String,Object> getESResponseAsMap(SearchResponse searchResponse){
        Map<String,Object> responseMap=new HashMap<>();
        responseMap.put("Count",getSearchResponseHitCount(searchResponse));
        List<Map<String,String>> searchHits=new ArrayList<>();
        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            Map<String,String> searchHitMap= (Map<String, String>) getESResponseAsDTO(searchHit.getSourceAsString(),Map.class);
            searchHits.add(searchHitMap);
        }
        responseMap.put("messages",searchHits);
        return responseMap;
    }

    public static Object getESResponseAsDTO(String sourceString ,  Type type){
        Object containerObject = null;
        try {
            containerObject = new Gson().fromJson(sourceString, type);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return containerObject;
    }
}
