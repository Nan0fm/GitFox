package com.foxmount.gitfox.models;

import com.foxmount.gitfox.templates.GitRespUser;

import io.reactivex.Observable;

/**
 * Created by A on 31.08.2017.
 */

public class ModelImpl implements Model {

//    @Inject
//    protected ApiInterface apiInterface;


    @Override
    public Observable<GitRespUser> getRepoList(String name) {
        return null;
    }
}
