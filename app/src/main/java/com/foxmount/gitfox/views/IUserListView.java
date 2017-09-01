package com.foxmount.gitfox.views;

import com.foxmount.gitfox.templates.GitUser;

import java.util.List;

/**
 * Created by A on 31.08.2017.
 */

public interface IUserListView extends IView {

    void showListUser(List<GitUser> lgu);
    void showEmptyList();
    void setTitle(String title);


}
