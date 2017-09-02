package com.foxmount.gitfox.views;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.foxmount.gitfox.templates.GitRepo;

import java.util.List;

/**
 * Created by A on 31.08.2017.
 */

public interface IUserView {

    void setAvatar(Bitmap avatar);
    void setName(String name);
    void  setScore(String score);
    void  showUserRepoList(List<GitRepo> listRepo);


}
