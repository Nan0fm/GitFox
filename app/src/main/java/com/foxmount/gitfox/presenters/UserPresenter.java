package com.foxmount.gitfox.presenters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import com.foxmount.gitfox.gitapi.ApiManager;
import com.foxmount.gitfox.gitapi.GitApi;
import com.foxmount.gitfox.templates.GitRepo;
import com.foxmount.gitfox.templates.GitUser;
import com.foxmount.gitfox.views.IUserView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by A on 31.08.2017.
 */

public class UserPresenter implements IUserPresenter {

    private static final String BUNDLE_REPO_LIST_KEY = "BUNDLE_REPO_LIST_KEY";

    IUserView userView;

    public UserPresenter(IUserView userView) {
        this.userView = userView;
    }

    @Override
    public void clickUser(GitUser user) {

//        userView.
    }

    @Override
    public void showUser(GitUser user) {
//        userView.setAvatar(user.getAvatar_url());
        userView.setName(user.getLogin());
        userView.setScore(String.valueOf(user.getScore()));

    }

    @Override
    public void onShowListRepo(List<GitRepo> listRepo) {
        userView.showUserRepoList(listRepo);
    }

    void dwld(final String name, String url) {
        GitApi downloadService = ApiManager.createService(GitApi.class);

        Call<ResponseBody> call = downloadService.dldFile(url);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d("ss", "server contacted and has file");

                    boolean writtenToDisk = writeResponseBodyToDisk(name, response.body());

                    Log.d("ss", "file download was a success? " + writtenToDisk);
                } else {
                    Log.d("ss", "server contact failed");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("cc", "error");
            }
        });
    }

    private boolean writeResponseBodyToDisk(String name, ResponseBody body) {
        try {
            // todo change the file location
            File futureStudioIconFile = new File(Environment.getExternalStorageDirectory() + File.separator + name + ".png");

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                    Log.d("cc", "file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }


}
