package models.FundRequest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FundRequest {

  @SerializedName(FundRequestFieldMapping.id)
  private String id;

  @SerializedName(FundRequestFieldMapping.reqUserId)
  private String reqUserId;

  @SerializedName(FundRequestFieldMapping.addInfo)
  private FundRequestAddInfo fundRequestAddInfo;

  @SerializedName(FundRequestFieldMapping.targetFund)
  private long targetFund;

  @SerializedName(FundRequestFieldMapping.currentFund)
  private long currentFund;

  @SerializedName(FundRequestFieldMapping.status)
  private String status;

  @SerializedName(FundRequestFieldMapping.deleted)
  private boolean deleted;

  @SerializedName(FundRequestFieldMapping.createdTime)
  private long createdTime;

  @SerializedName(FundRequestFieldMapping.lastModifiedTime)
  private long lastModifiedTime;

  @SerializedName(FundRequestFieldMapping.actorsInfo)
  private List<FundRequestActorInfo> fundRequestActorInfoList;

  @SerializedName(FundRequestFieldMapping.backersInfo)
  private List<FundRequestBackerInfo> fundRequestBackerInfoList;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReqUserId() {
        return reqUserId;
    }

    public void setReqUserId(String reqUserId) {
        this.reqUserId = reqUserId;
    }

    public FundRequestAddInfo getFundRequestAddInfo() {
        return fundRequestAddInfo;
    }

    public void setFundRequestAddInfo(FundRequestAddInfo fundRequestAddInfo) {
        this.fundRequestAddInfo = fundRequestAddInfo;
    }

    public long getTargetFund() {
        return targetFund;
    }

    public void setTargetFund(long targetFund) {
        this.targetFund = targetFund;
    }

    public long getCurrentFund() {
        return currentFund;
    }

    public void setCurrentFund(long currentFund) {
        this.currentFund = currentFund;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(long lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public List<FundRequestActorInfo> getFundRequestActorInfoList() {
        return fundRequestActorInfoList;
    }

    public void setFundRequestActorInfoList(List<FundRequestActorInfo> fundRequestActorInfoList) {
        this.fundRequestActorInfoList = fundRequestActorInfoList;
    }

    public List<FundRequestBackerInfo> getFundRequestBackerInfoList() {
        return fundRequestBackerInfoList;
    }

    public void setFundRequestBackerInfoList(List<FundRequestBackerInfo> fundRequestBackerInfoList) {
        this.fundRequestBackerInfoList = fundRequestBackerInfoList;
    }
}
