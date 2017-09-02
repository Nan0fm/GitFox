package com.foxmount.gitfox.views;

import android.view.View;

import com.foxmount.gitfox.templates.GitUser;

import java.util.List;

/**
 * Created by A on 31.08.2017.
 */

public interface IUserListView extends IView {

    void showListUser(List<GitUser> lgu);

    void showEmptyView(int idLayout);
    void hideEmptyView();

    void setTitle(String title);

    void setHomeIcon(int id);

    void clearSearch();

    void clickSearch();
    void clickUser(GitUser gu);


}
