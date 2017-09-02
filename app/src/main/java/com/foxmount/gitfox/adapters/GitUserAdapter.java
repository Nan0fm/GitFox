package com.foxmount.gitfox.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.foxmount.gitfox.R;
import com.foxmount.gitfox.presenters.UserListPresenter;
import com.foxmount.gitfox.templates.GitRepo;
import com.foxmount.gitfox.vholders.UserVh;
import com.foxmount.gitfox.presenters.UserPresenter;
import com.foxmount.gitfox.templates.GitUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by A on 31.08.2017.
 */

public class GitUserAdapter extends RecyclerView.Adapter<UserVh> {

    private UserListPresenter ulPresenter;
    private List<GitUser> lgu;

    private Callback<List<GitRepo>> callBack;
    private long dur = 300;
    private int lph = -1;


    public GitUserAdapter(UserListPresenter ulPresenter, List<GitUser> lgu, Callback<List<GitRepo>> callBack) {
        this.ulPresenter = ulPresenter;
        this.lgu = lgu;
        this.callBack = callBack;
    }

    @Override
    public UserVh onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserVh(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_user_item, parent, false));
    }

    @Override
    public void onBindViewHolder(UserVh holder, int position) {
        final UserPresenter uPresenter = new UserPresenter(holder);
        final GitUser gu = lgu.get(position);
//        if (position==0)
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE).error(R.drawable.c);
        Glide.with(holder.itemView)
                .asBitmap()
                .load(lgu.get(position).getAvatar_url())
                .apply(requestOptions)
                .into(holder.avatar);
        uPresenter.showUser(lgu.get(position));
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ulPresenter.onClickUser(gu, callBack);
            }
        });

        setAnimationB(holder.itemView, position, lph);

    }

    @Override
    public int getItemCount() {
        return lgu.size();
    }

    public void clear() {
        lgu.clear();
        notifyDataSetChanged();
    }

    private void setAnimationB(View viewToAnimate, int position, int lp) {
        if (position > lp) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R.anim.anim_in_bot);
            animation.setDuration(dur);
            animation.setStartOffset(position * 50);
            viewToAnimate.startAnimation(animation);
            lph = position;
        }
    }


}
