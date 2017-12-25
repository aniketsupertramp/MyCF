package models.FundRequest;

import com.google.gson.annotations.SerializedName;

public class FundRequestAddInfo {

    @SerializedName(FundRequestFieldMapping.title)
    private String title;

    @SerializedName(FundRequestFieldMapping.desc)
    private String desc;

    @SerializedName(FundRequestFieldMapping.url)
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
