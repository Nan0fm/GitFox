package com.foxmount.gitfox.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.foxmount.gitfox.R;
import com.foxmount.gitfox.presenters.UserListPresenter;
import com.foxmount.gitfox.presenters.UserPresenter;
import com.foxmount.gitfox.templates.GitRepo;
import com.foxmount.gitfox.templates.GitUser;
import com.foxmount.gitfox.vholders.RepoVh;
import com.foxmount.gitfox.vholders.UserVh;

import java.util.List;

/**
 * Created by A on 31.08.2017.
 */

public class RepoAdapter extends RecyclerView.Adapter<RepoVh> {


    private List<GitRepo> lgr;


    private long dur = 300;
    private int lph = -1;


    public RepoAdapter( List<GitRepo> lgr) {

        this.lgr = lgr;

    }

    @Override
    public RepoVh onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RepoVh(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_repo_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RepoVh holder, int position) {

        final GitRepo gu = lgr.get(position);



        setAnimation(holder.itemView, position, lph);

    }

    @Override
    public int getItemCount() {
        return lgr.size();
    }

    public void clear() {
        lgr.clear();
        notifyDataSetChanged();
    }

    private void setAnimation(View viewToAnimate, int position, int lp) {
        if (position > lp) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R.anim.anim_in_right);
            animation.setDuration(dur);
            animation.setStartOffset(position * 50);
            viewToAnimate.startAnimation(animation);
            lph = position;
        }
    }


}
