package com.foxmount.gitfox.presenters;

import com.foxmount.gitfox.templates.GitRepo;
import com.foxmount.gitfox.templates.GitUser;

import java.util.List;

/**
 * Created by A on 31.08.2017.
 */

public interface IUserPresenter {

    void clickUser(GitUser user);

    void showUser(GitUser user);

    void onShowListRepo(List<GitRepo> listRepo);
}
