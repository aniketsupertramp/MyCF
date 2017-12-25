package models.FundRequest;

import com.google.gson.annotations.SerializedName;

public class FundRequestBackerInfo {

    @SerializedName(FundRequestFieldMapping.backerName)
    private String backerName;

    @SerializedName(FundRequestFieldMapping.backerEmail)
    private String backerEmail;

    @SerializedName(FundRequestFieldMapping.backerProfileUrl)
    private String profileUrl;

    public String getBackerName() {
        return backerName;
    }

    public void setBackerName(String backerName) {
        this.backerName = backerName;
    }

    public String getBackerEmail() {
        return backerEmail;
    }

    public void setBackerEmail(String backerEmail) {
        this.backerEmail = backerEmail;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}
