package com.foxmount.gitfox.views;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by A on 31.08.2017.
 */

public interface IUserView {

    void setAvatar(Bitmap avatar);
    void setName(String name);
    void  setScore(String score);



}
