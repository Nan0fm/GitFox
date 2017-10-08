package com.foxmount.gitfox.interactors;

import com.foxmount.gitfox.templates.GitRepo;

import java.util.List;

/**
 * Created by A on 23:36 08.10.2017.
 */

public interface IGetReposInteractor extends Interactor {

    interface Callback {
        void onSuccess(List<GitRepo> repos);

        void onFail(String reason);
    }

}
