package com.foxmount.gitfox.views;

import com.foxmount.gitfox.templates.GitRepo;

import java.util.List;

/**
 * Created by A on 23:42 08.10.2017.
 */

public interface IUserInfoActivityView extends IActivityView {

    void showRepos(List<GitRepo> listRepo);

}
