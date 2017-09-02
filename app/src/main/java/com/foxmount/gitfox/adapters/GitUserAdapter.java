package com.foxmount.gitfox.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.foxmount.gitfox.R;
import com.foxmount.gitfox.vholders.UserVh;
import com.foxmount.gitfox.presenters.UserPresenter;
import com.foxmount.gitfox.templates.GitUser;

import java.util.List;

/**
 * Created by A on 31.08.2017.
 */

public class GitUserAdapter extends RecyclerView.Adapter<UserVh> {

    UserPresenter ulPresenter;

    List<GitUser> lgu;

    public GitUserAdapter(List<GitUser> lgu) {
        this.lgu = lgu;
//        ulPresenter=new UserPresenter();
    }

    @Override
    public UserVh onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserVh(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_user_item, parent, false));
    }

    @Override
    public void onBindViewHolder(UserVh holder, int position) {
        UserPresenter ulPresenter = new UserPresenter(holder);
//        if (position==0)
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE).error(R.drawable.c);
        Glide.with(holder.itemView)
                .asBitmap()
                .load(lgu.get(position).getAvatar_url())
                .apply(requestOptions)
                .into(holder.avatar);
    ulPresenter.showUser(lgu.get(position));
    }

    @Override
    public int getItemCount() {
        return lgu.size();
    }
}
