package com.foxmount.gitfox.presenters;

/**
 * Created by A on 31.08.2017.
 */

public interface IBasePresenter  {

    void onShowProgress();

    void onHideProgress();

    void onBackPress();
    void onShowError();

}
