package com.foxmount.gitfox.gitapi;

import com.foxmount.gitfox.templates.GitRespUser;
import com.foxmount.gitfox.templates.GitUser;
import com.foxmount.gitfox.templates.IMainTemplate;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

import static com.foxmount.gitfox.gitapi.UrlConst.URL_SEARCH;
import static com.foxmount.gitfox.gitapi.UrlConst.URL_USERS;

/**
 * Created by A on 31.08.2017.
 */

public interface GitApi {

//    @GET(URL_SEARCH+URL_USERS)
//    Call<IMainTemplate> searchUser(@Query("q") String login);
@GET(URL_SEARCH+URL_USERS)
    Call<GitRespUser> searchUser(@Query("q") String login);


    @GET(URL_SEARCH+URL_USERS)
    Observable<List<GitUser>> reposForUser(@Query("q") String login);

    @GET
    Call<ResponseBody> dldFile(@Url String fileUrl);


}
