package com.foxmount.gitfox.vholders;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.foxmount.gitfox.R;
import com.foxmount.gitfox.views.IUserView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by A on 31.08.2017.
 */

public class UserVh extends RecyclerView.ViewHolder implements IUserView {
    @BindView(R.id.avatar)
    public ImageView avatar;
    @BindView(R.id.name)
    protected TextView login;
    @BindView(R.id.score)
    protected TextView score;


    public UserVh(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);


    }

    @Override
    public void setAvatar(Bitmap drAvatar) {
        avatar.setImageBitmap(drAvatar);
    }

    @Override
    public void setName(String name) {
        login.setText(name);
    }

    @Override
    public void setScore(String value) {
        score.setText(value);
    }


}
