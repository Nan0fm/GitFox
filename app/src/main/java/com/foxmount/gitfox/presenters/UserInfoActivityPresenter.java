package com.foxmount.gitfox.presenters;

import com.foxmount.gitfox.interactors.GetReposInteractor;
import com.foxmount.gitfox.interactors.IGetReposInteractor;
import com.foxmount.gitfox.templates.GitRepo;
import com.foxmount.gitfox.views.IUserInfoActivityView;
import com.foxmount.gitfox.views.IUserView;

import java.util.List;

/**
 * Created by A on 23:40 08.10.2017.
 */

public class UserInfoActivityPresenter implements IUserInfoActivityPresenter, IGetReposInteractor.Callback {

    IUserView view;
    IUserInfoActivityView actView;

    public UserInfoActivityPresenter(IUserView view, IUserInfoActivityView actView) {
        this.view = view;
        this.actView = actView;
    }

    @Override
    public void onShowProgress() {

    }

    @Override
    public void onHideProgress() {

    }

    @Override
    public void onBackPress() {

    }

    @Override
    public void onShowError(String err) {
        actView.showError(err);
    }

    @Override
    public void loadRepos(String login) {
        GetReposInteractor gi = new GetReposInteractor(this, login);
        gi.execute();
    }

    @Override
    public void setTitle(String title) {
        actView.setTitle(title);
    }

    @Override
    public void onSuccess(List<GitRepo> repos) {
        actView.showRepos(repos);
    }

    @Override
    public void onFail(String reason) {
        actView.showError(reason);
    }
}
