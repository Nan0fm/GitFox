package com.foxmount.gitfox.vholders;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.foxmount.gitfox.R;
import com.foxmount.gitfox.presenters.UserPresenter;
import com.foxmount.gitfox.views.IUserView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by A on 31.08.2017.
 */

public class UserVh extends RecyclerView.ViewHolder implements IUserView,View.OnClickListener {
    @BindView(R.id.avatar)
    public ImageView avatar;
    @BindView(R.id.name)
    protected TextView login;
    @BindView(R.id.score)
    protected TextView score;
    private UserPresenter presenter;
    private View mainView;

    public UserVh(View itemView) {
        super(itemView);
        mainView=itemView;
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
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


    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        if(position != RecyclerView.NO_POSITION) {

//            SpacePhoto spacePhoto = mSpacePhotos[position];
//            Intent intent = new Intent(v.getContext(), SpacePhotoActivity.class);
//            intent.putExtra(SpacePhotoActivity.EXTRA_SPACE_PHOTO, spacePhoto);
//            startActivity(intent);
        }
    }

   public void setOnClickListener(View.OnClickListener cl){
       mainView.setOnClickListener(cl);
   }
}
