package com.foxmount.gitfox.VHolders;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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
    protected ImageView avatar;

    @BindView(R.id.name)
    protected TextView login;


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
}
