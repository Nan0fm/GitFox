package com.foxmount.gitfox.templates;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by A on 31.08.2017.
 */

public class GitRespUser {

    private static final String J_TOTAL_COUNT ="total_count";
    private static final String J_INCOMPL_RES ="incomplete_results";
    private static final String J_ITEMS       ="items";


    @SerializedName(J_TOTAL_COUNT ) @Expose private String total_count;
    @SerializedName(J_INCOMPL_RES ) @Expose private boolean incomplete_results;
    @SerializedName(J_ITEMS       ) @Expose private ArrayList<GitUser> items;

    public GitRespUser() {
    }


    public String getTotal_count() {
        return total_count;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public ArrayList<GitUser> getItems() {
        return items;
    }
}
