package com.foxmount.gitfox.interactors;

import com.foxmount.gitfox.gitapi.ApiManager;
import com.foxmount.gitfox.gitapi.GitApi;
import com.foxmount.gitfox.templates.GitRepo;
import com.foxmount.gitfox.templates.GitRespUser;
import com.foxmount.gitfox.templates.GitUser;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by A on 23:37 08.10.2017.
 */

public class GetUsersInteractor implements IGetUsersInteractor, Callback<GitRespUser> {

    Callback callback;
    String query;

    public GetUsersInteractor(Callback callback,   String query) {
        this.callback = callback;
        this.query = query;
    }

    @Override
    public void execute() {

        GitApi ga = ApiManager.createService(GitApi.class);

        Call<GitRespUser> callp = ga.searchUser(query);


        callp.enqueue(this);
    }

    @Override
    public void onResponse(Call<GitRespUser> call, Response<GitRespUser> response) {
        if (response.isSuccessful())
            callback.onSuccess(response.body().getItems());
        else try {
            callback.onFail(response.errorBody().string());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void onFailure(Call<GitRespUser> call, Throwable t) {
        callback.onFail(t.getMessage());
    }
}
