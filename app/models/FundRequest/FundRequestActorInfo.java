package models.FundRequest;

import com.google.gson.annotations.SerializedName;

public class FundRequestActorInfo {

    @SerializedName(FundRequestFieldMapping.actorName)
    private String actorName;

    @SerializedName(FundRequestFieldMapping.actorEmail)
    private String actorEmail;

    @SerializedName(FundRequestFieldMapping.actorProfileUrl)
    private String profileUrl;

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorEmail() {
        return actorEmail;
    }

    public void setActorEmail(String actorEmail) {
        this.actorEmail = actorEmail;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}
