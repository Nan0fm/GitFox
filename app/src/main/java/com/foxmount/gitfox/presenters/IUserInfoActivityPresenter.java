package com.foxmount.gitfox.presenters;

/**
 * Created by A on 23:34 08.10.2017.
 */

public interface IUserInfoActivityPresenter extends IBasePresenter {

    void loadRepos(String login);
    void setTitle(String title);
}
