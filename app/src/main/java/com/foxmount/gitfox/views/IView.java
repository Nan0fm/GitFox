package com.foxmount.gitfox.views;

/**
 * Created by A on 31.08.2017.
 */

public interface IView {

    void showProgress();
    void hideProgress();
    void showError(String error);
    void navigateBack();
}
