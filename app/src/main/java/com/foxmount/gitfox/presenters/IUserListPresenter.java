package com.foxmount.gitfox.presenters;

import com.foxmount.gitfox.templates.GitRespUser;
import com.foxmount.gitfox.templates.GitUser;
import com.foxmount.gitfox.templates.IMainTemplate;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by A on 31.08.2017.
 */

public interface IUserListPresenter {

    void onClickUser(GitUser user);

    void showUser(GitUser user);

    void onShowListUser(List<GitUser> lgu);

    void onShowEmptyList();

    void onSetTitle(String title);

    void onSetHomeIcon(int id);

    void onClearSearch();

    void onClickHome();

    void onClickSearch(String query, Callback<GitRespUser> c);
    void onShowError(String error);

}
