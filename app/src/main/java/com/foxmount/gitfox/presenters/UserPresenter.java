package com.foxmount.gitfox.presenters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import com.foxmount.gitfox.gitapi.ApiManager;
import com.foxmount.gitfox.gitapi.GitApi;
import com.foxmount.gitfox.templates.GitRepo;
import com.foxmount.gitfox.templates.GitUser;
import com.foxmount.gitfox.views.IUserView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by A on 31.08.2017.
 */

public class UserPresenter implements IUserPresenter {

    private static final String BUNDLE_REPO_LIST_KEY = "BUNDLE_REPO_LIST_KEY";

    IUserView userView;

    public UserPresenter(IUserView userView) {
        this.userView = userView;
    }

    @Override
    public void clickUser(GitUser user) {

//        userView.
    }

    @Override
    public void showUser(GitUser user) {
//        userView.setAvatar(user.getAvatar_url());
        userView.setName(user.getLogin());
        userView.setScore(String.valueOf(user.getScore()));

    }






}
