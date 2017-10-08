package com.foxmount.gitfox.interactors;

import com.foxmount.gitfox.gitapi.ApiManager;
import com.foxmount.gitfox.gitapi.GitApi;
import com.foxmount.gitfox.templates.GitRepo;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by A on 23:37 08.10.2017.
 */

public class GetReposInteractor implements IGetReposInteractor , Callback<List< GitRepo >> {

    Callback callback;
    String user;

    public GetReposInteractor(Callback callback, String user) {
        this.callback = callback;
        this.user = user;
    }

    @Override
    public void execute() {

            GitApi ga = ApiManager.createService(GitApi.class);

            Call<List<GitRepo>> callp = ga.searchUserRep(user);
            callp.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<GitRepo>> call, Response<List<GitRepo>> response) {
        if (response.isSuccessful())
        callback.onSuccess(response.body());
        else try {
            callback.onFail(response.errorBody().string());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void onFailure(Call<List<GitRepo>> call, Throwable t) {
        callback.onFail(t.getMessage());
    }
}
