package com.foxmount.gitfox.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.foxmount.gitfox.R;
import com.foxmount.gitfox.VHolders.UserVh;
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
        UserPresenter  ulPresenter=new UserPresenter(holder);
        ulPresenter.showUser(lgu.get(position));
    }

    @Override
    public int getItemCount() {
        return lgu.size();
    }
}
