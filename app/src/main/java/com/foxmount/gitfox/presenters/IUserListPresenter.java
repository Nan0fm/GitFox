package com.foxmount.gitfox.presenters;

import android.view.View;

import com.foxmount.gitfox.templates.GitRepo;
import com.foxmount.gitfox.templates.GitRespUser;
import com.foxmount.gitfox.templates.GitUser;
import com.foxmount.gitfox.templates.IMainTemplate;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by A on 31.08.2017.
 */

public interface IUserListPresenter {

    void onClickUser(GitUser user, Callback<List<GitRepo>> c);

    void showUser(GitUser user);

    void onShowListUser(List<GitUser> lgu);

    void onShowEmptyView(int idLayout);

    void onSetTitle(String title);

    void onSetHomeIcon(int id);

    void onClearSearch();

    void onClickHome();

    void onClickSearch(String query, Callback<GitRespUser> c);
    void onShowError(String error);
    void onShowProgress();
    void onHideProgress();



}
