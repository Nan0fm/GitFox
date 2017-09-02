package com.foxmount.gitfox.templates;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by A on 31.08.2017.
 */

public class GitUser implements Parcelable {

    private static final String J_LOGIN          ="login";
    private static final String J_ID             ="id";
    private static final String J_URL_AVATAR     ="avatar_url";
    private static final String J_GRAVATER_ID    ="gravatar_id";
    private static final String J_URL            ="url";
    private static final String J_URL_HTML       ="html_url";
    private static final String J_URL_FOLLOWERS  ="followers_url";
    private static final String J_URL_SUBSCR     ="subscriptions_url";
    private static final String J_URL_ORG        ="organizations_url";
    private static final String J_URL_REP        ="repos_url";
    private static final String J_URL_REC_EV     ="received_events_url";
    private static final String J_TYPE           ="type";
    private static final String J_SCORE          ="score";

    @SerializedName(J_LOGIN        ) @Expose  private String login;
    @SerializedName(J_ID           ) @Expose  private    int id;
    @SerializedName(J_URL_AVATAR   ) @Expose  private String avatar_url;
    @SerializedName(J_GRAVATER_ID  ) @Expose  private String gravatar_id;
    @SerializedName(J_URL          ) @Expose  private String url;
    @SerializedName(J_URL_HTML     ) @Expose  private String html_url;
    @SerializedName(J_URL_FOLLOWERS) @Expose  private String followers_url;
    @SerializedName(J_URL_SUBSCR   ) @Expose  private String subscriptions_url;
    @SerializedName(J_URL_ORG      ) @Expose  private String organizations_url;
    @SerializedName(J_URL_REP      ) @Expose  private String repos_url;
    @SerializedName(J_URL_REC_EV   ) @Expose  private String received_events_url;
    @SerializedName(J_TYPE         ) @Expose  private String type;
    @SerializedName(J_SCORE        ) @Expose  private double score;


    public GitUser() {    }


    protected GitUser(Parcel in) {
        login = in.readString();
        id = in.readInt();
        avatar_url = in.readString();
        gravatar_id = in.readString();
        url = in.readString();
        html_url = in.readString();
        followers_url = in.readString();
        subscriptions_url = in.readString();
        organizations_url = in.readString();
        repos_url = in.readString();
        received_events_url = in.readString();
        type = in.readString();
        score = in.readDouble();
    }

    public static final Creator<GitUser> CREATOR = new Creator<GitUser>() {
        @Override
        public GitUser createFromParcel(Parcel in) {
            return new GitUser(in);
        }

        @Override
        public GitUser[] newArray(int size) {
            return new GitUser[size];
        }
    };

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public String getType() {
        return type;
    }

    public double getScore() {
        return score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

       dest.writeString(login);
       dest.writeInt   (id);
       dest.writeString(avatar_url);
       dest.writeString(gravatar_id);
       dest.writeString(url);
       dest.writeString(html_url);
       dest.writeString(followers_url);
       dest.writeString(subscriptions_url);
       dest.writeString(organizations_url);
       dest.writeString(repos_url);
       dest.writeString(received_events_url);
       dest.writeString(type);
       dest.writeDouble(score);
    }
}
