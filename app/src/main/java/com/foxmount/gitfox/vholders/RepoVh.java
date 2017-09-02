package com.foxmount.gitfox.vholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.foxmount.gitfox.R;
import com.foxmount.gitfox.views.IRepoView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by A on 02.09.2017.
 */

public class RepoVh extends RecyclerView.ViewHolder implements IRepoView {

    @BindView(R.id.name)
    protected TextView name;

    public RepoVh(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }


    @Override
    public void setName(String repoName) {
        name.setText(repoName);
    }
}
