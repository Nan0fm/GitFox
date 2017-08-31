package com.foxmount.gitfox.models;

import com.foxmount.gitfox.templates.GitRespUser;
import com.foxmount.gitfox.templates.GitUser;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by A on 31.08.2017.
 */

public interface Model {
    Observable<GitRespUser> getRepoList(String name);

}
