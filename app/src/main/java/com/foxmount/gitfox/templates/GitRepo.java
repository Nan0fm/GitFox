package com.foxmount.gitfox.templates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by A on 02.09.2017.
 */

public class GitRepo {
    private static final String J_ID = "id";
    private static final String J_NAME = "name";
    private static final String J_FULL_NAME = "full_name";
    private static final String J_DESCRIPTION = "description";
    private static final String J_URL = "url";
    private static final String J_HTML_URL = "html_url";

    @SerializedName(J_ID           )@Expose private int id;
    @SerializedName(J_NAME         )@Expose private String name;
    @SerializedName(J_FULL_NAME    )@Expose private String full_name;
    @SerializedName(J_DESCRIPTION  )@Expose private String description;
    @SerializedName(J_URL          )@Expose private String url;
    @SerializedName(J_HTML_URL     )@Expose private String html_url;

    public GitRepo() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getHtml_url() {
        return html_url;
    }
}
