package com.foxmount.gitfox.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.foxmount.gitfox.R;
import com.foxmount.gitfox.UsersActivity;
import com.foxmount.gitfox.gitapi.ApiManager;
import com.foxmount.gitfox.gitapi.GitApi;
import com.foxmount.gitfox.interactors.GetUsersInteractor;
import com.foxmount.gitfox.interactors.IGetUsersInteractor;
import com.foxmount.gitfox.templates.GitRepo;
import com.foxmount.gitfox.templates.GitRespUser;
import com.foxmount.gitfox.templates.GitUser;
import com.foxmount.gitfox.templates.IMainTemplate;
import com.foxmount.gitfox.views.IUserListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by A on 01.09.2017.
 */

public class UserListPresenter implements IUserListPresenter, IGetUsersInteractor.Callback {

    private IUserListView ulView;

    public UserListPresenter(IUserListView ulView) {
        this.ulView = ulView;
    }

    @Override
    public void onClickUser(GitUser user) {
        ulView.clickUser(user);

    }

    @Override
    public void showUser(GitUser user) {

    }

    @Override
    public void onShowListUser(List<GitUser> lgu) {
        ulView.showListUser(lgu);
        ulView.hideEmptyView();
    }

    @Override
    public void onShowEmptyView(int idLayout) {
        ulView.showEmptyView(idLayout);
    }

    @Override
    public void onSetTitle(String title) {
        ulView.setTitle(title);
    }

    @Override
    public void onSetHomeIcon(int iconResId) {
        ulView.setHomeIcon(iconResId);
    }

    @Override
    public void onClearSearch() {
        ulView.clearSearch();
    }

    @Override
    public void onClickHome() {
        ulView.clickHome();
    }

    @Override
    public void onClickSearch(String query, Callback<GitRespUser> c) {
        GetUsersInteractor gui = new GetUsersInteractor(this, query);
        gui.execute();


    }

    @Override
    public void onShowError(String error) {
        ulView.showError(error);
    }

    @Override
    public void onShowProgress() {
        ulView.showProgress();
    }

    @Override
    public void onHideProgress() {
        ulView.hideProgress();
    }


    @Override
    public void onSuccess(List<GitUser> users) {
        onShowListUser(users);
    }

    @Override
    public void onFail(String reason) {
        ulView.showError(reason);
    }
}
