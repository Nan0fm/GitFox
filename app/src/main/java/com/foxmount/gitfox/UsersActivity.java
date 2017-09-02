package com.foxmount.gitfox;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.foxmount.gitfox.adapters.GitUserAdapter;
import com.foxmount.gitfox.gitapi.ApiManager;
import com.foxmount.gitfox.gitapi.GitApi;
import com.foxmount.gitfox.presenters.UserListPresenter;
import com.foxmount.gitfox.templates.GitRepo;
import com.foxmount.gitfox.templates.GitRespUser;
import com.foxmount.gitfox.templates.GitUser;
import com.foxmount.gitfox.views.IUserListView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends AppCompatActivity implements IUserListView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.toolbar_progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.rvUser)
    RecyclerView rv;
    @BindView(R.id.container)
    FrameLayout container;

    SearchView searchView;
    MenuItem myActionMenuItem;

    GitUserAdapter guAdapter;

    UserListPresenter ulPresenter;


    Callback<List<GitRepo>> callback=new Callback<List<GitRepo>>() {
        @Override
        public void onResponse(Call<List<GitRepo>> call, Response<List<GitRepo>> response) {
            Toast.makeText(UsersActivity.this, "oook", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onFailure(Call<List<GitRepo>> call, Throwable t) {
            Toast.makeText(UsersActivity.this, "oups", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ulPresenter = new UserListPresenter(this);

        ulPresenter.onSetHomeIcon(R.drawable.ic_dashboard_white_24dp);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                makeRequest();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        GridLayoutManager glm = new GridLayoutManager(this, 2);
        LinearLayoutManager lManager = new LinearLayoutManager(this);
        rv.setLayoutManager(glm);
        ulPresenter.onShowEmptyView(R.layout.empty_view);

    }

//
//    void dwld() {
//        GitApi downloadService = ApiManager.createService(GitApi.class);
//
//        Call<ResponseBody> call = downloadService.dldFile("https://secure.gravatar.com/avatar/25c7c18223fb42a4c6ae1c8db6f50f9b?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png");
//
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.isSuccessful()) {
//                    Log.d("ss", "server contacted and has file");
//
//                    boolean writtenToDisk = writeResponseBodyToDisk(response.body());
//
//                    Log.d("ss", "file download was a success? " + writtenToDisk);
//                } else {
//                    Log.d("ss", "server contact failed");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.e("cc", "error");
//            }
//        });
//    }
//
//    private boolean writeResponseBodyToDisk(ResponseBody body) {
//        try {
//            // todo change the file location/name according to your needs
//            File futureStudioIconFile = new File(getExternalFilesDir(null) + File.separator + "gh.png");
//
//            InputStream inputStream = null;
//            OutputStream outputStream = null;
//
//            try {
//                byte[] fileReader = new byte[4096];
//
//                long fileSize = body.contentLength();
//                long fileSizeDownloaded = 0;
//
//                inputStream = body.byteStream();
//                outputStream = new FileOutputStream(futureStudioIconFile);
//
//                while (true) {
//                    int read = inputStream.read(fileReader);
//
//                    if (read == -1) {
//                        break;
//                    }
//
//                    outputStream.write(fileReader, 0, read);
//
//                    fileSizeDownloaded += read;
//
//                    Log.d("cc", "file download: " + fileSizeDownloaded + " of " + fileSize);
//                }
//
//                outputStream.flush();
//
//                return true;
//            } catch (IOException e) {
//                return false;
//            } finally {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//
//                if (outputStream != null) {
//                    outputStream.close();
//                }
//            }
//        } catch (IOException e) {
//            return false;
//        }
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_users, menu);
        myActionMenuItem = menu.findItem(R.id.search);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Toast like print
                ulPresenter.onSetHomeIcon(R.drawable.ic_keyboard_backspace_white_24dp);
                ulPresenter.onShowProgress();
                ulPresenter.onClickSearch(query, new Callback<GitRespUser>() {
                    @Override
                    public void onResponse(Call<GitRespUser> call, Response<GitRespUser> response) {
                        Toast.makeText(UsersActivity.this, "oook", Toast.LENGTH_SHORT).show();
                        ulPresenter.onShowListUser(response.body().getItems());
                        ulPresenter.onHideProgress();

                    }

                    @Override
                    public void onFailure(Call<GitRespUser> call, Throwable t) {
                        ulPresenter.onShowError(t.getMessage());
                    }
                });
                ulPresenter.onSetTitle(query);

                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // UserFeedback.show( "SearchOnQueryTextChanged: " + s);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ulPresenter.onClearSearch();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        rv.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        rv.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showListUser(List<GitUser> lgu) {
        guAdapter = new GitUserAdapter(ulPresenter, lgu,callback);
        rv.setAdapter(guAdapter);
    }

    @Override
    public void showEmptyView(int idLayout) {
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.empty_view, null);

        rv.setVisibility(View.GONE);
        container.setVisibility(View.VISIBLE);
        container.addView(view);


//        List<GitUser> lgu = new ArrayList<>();
//        guAdapter = new GitUserAdapter(lgu);
//        rv.setAdapter(guAdapter);
    }

    @Override
    public void hideEmptyView() {
        container.setVisibility(View.GONE);
    }

    @Override
    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void setHomeIcon(int id) {
        toolbar.setNavigationIcon(id);

    }

    @Override
    public void clearSearch() {
        searchView.setQuery("", false);
        searchView.clearFocus();
        ulPresenter.onSetHomeIcon(R.drawable.ic_dashboard_white_24dp);
        ulPresenter.onSetTitle(getString(R.string.app_name));
        guAdapter.clear();
        ulPresenter.onShowEmptyView(R.layout.empty_view);
    }

    @Override
    public void clickHome() {
        ulPresenter.onClearSearch();
    }

    @Override
    public void backPress() {
        if (!searchView.isIconified()) searchView.setIconified(true);
        else super.onBackPressed();
    }

    @Override
    public void clickSearch() {

    }
}
