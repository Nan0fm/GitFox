package com.foxmount.gitfox;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.foxmount.gitfox.adapters.RepoAdapter;
import com.foxmount.gitfox.gitapi.ApiManager;
import com.foxmount.gitfox.gitapi.GitApi;
import com.foxmount.gitfox.presenters.UserInfoActivityPresenter;
import com.foxmount.gitfox.presenters.UserPresenter;
import com.foxmount.gitfox.templates.GitRepo;
import com.foxmount.gitfox.templates.GitUser;
import com.foxmount.gitfox.views.IUserInfoActivityView;
import com.foxmount.gitfox.views.IUserView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfoActivity extends AppCompatActivity implements IUserView, IUserInfoActivityView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.avatar)
    public ImageView avatar;
    @BindView(R.id.name)
    protected TextView login;
    @BindView(R.id.score)
    protected TextView score;
    @BindView(R.id.rvRepo)
    protected RecyclerView rvRepo;

    GitUser gu;
    private RepoAdapter repoAdapter;
    private UserPresenter presenter;
    private UserInfoActivityPresenter actPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        presenter = new UserPresenter(this);
        actPresenter = new UserInfoActivityPresenter(this,this);
        gu = (GitUser) getIntent().getParcelableExtra("gitUser");
        ButterKnife.bind(this);
        actPresenter.setTitle(gu.getLogin());
        setSupportActionBar(toolbar);


         presenter.showUser(gu);

        LinearLayoutManager lManager = new LinearLayoutManager(this);
        rvRepo.setLayoutManager(lManager);


        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE).error(R.drawable.c);

        Glide.with(this)
                .asBitmap()
                .load(gu.getAvatar_url())
                .apply(requestOptions)
                .into(avatar);
        actPresenter.loadRepos(gu.getLogin());
    }

    @Override
    public void setAvatar(Bitmap avatar) {

    }

    @Override
    public void setName(String name) {
        login.setText(name);
    }

    @Override
    public void setScore(String scoreV) {
        score.setText(scoreV);
    }


    @Override
    public void setTitle(String userName) {
        toolbar.setTitle(userName);
    }


    @Override
    public void showRepos(List<GitRepo> listRepo) {
        repoAdapter = new RepoAdapter(listRepo);
        rvRepo.setAdapter(repoAdapter);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickHome() {

    }

    @Override
    public void backPress() {
        super.onBackPressed();
    }
}
