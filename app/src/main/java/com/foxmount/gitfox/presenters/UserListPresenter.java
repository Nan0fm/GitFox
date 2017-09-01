package com.foxmount.gitfox.presenters;

import android.widget.Toast;

import com.foxmount.gitfox.R;
import com.foxmount.gitfox.UsersActivity;
import com.foxmount.gitfox.gitapi.ApiManager;
import com.foxmount.gitfox.gitapi.GitApi;
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

public class UserListPresenter implements IUserListPresenter {

    private IUserListView ulView;

    public UserListPresenter(IUserListView ulView) {
        this.ulView = ulView;
    }

    @Override
    public void onClickUser(GitUser user) {

    }

    @Override
    public void showUser(GitUser user) {

    }

    @Override
    public void onShowListUser(List<GitUser> lgu) {
        ulView. showListUser(lgu);
    }

    @Override
    public void onShowEmptyList() {
        ulView.showEmptyList();
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
        ulView. clearSearch();
    }

    @Override
    public void onClickHome() {
        ulView.clickHome();
    }

    @Override
    public void onClickSearch(String query, Callback<GitRespUser> c) {
        makeRequest(query,  c);
    }

    @Override
    public void onShowError(String error) {
        ulView.showError(error);
    }


    private void makeRequest(String query, Callback<GitRespUser> c) {
        onSetHomeIcon(R.drawable.ic_keyboard_backspace_white_24dp);

        GitApi ga = ApiManager.createService(GitApi.class);

        Call<GitRespUser> callp = ga.searchUser(query);


        callp.enqueue(c);
// Execute the call asynchronously. Get a positive or negative callback.
//        Subscription subscription = model.getRepoList(name)
//                .map(repoListMapper)
//                .subscribe(new Observer<List<Repository>>() {
//
//                    @Override
//                    public void onCompleted() {
//                        hideLoadingState();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        hideLoadingState();
//                        showError(e);
//                    }
//
//                    @Override
//                    public void onNext(List<Repository> list) {
//                        if (list != null && !list.isEmpty()) {
//                            repoList = list;
//                            view.showRepoList(list);
//                        } else {
//                            view.showEmptyList();
//                        }
//                    }
//                });
//        addSubscription(subscription);
    }


}
