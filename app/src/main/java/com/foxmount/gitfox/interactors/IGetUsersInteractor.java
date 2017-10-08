package com.foxmount.gitfox.interactors;

import com.foxmount.gitfox.templates.GitRepo;
import com.foxmount.gitfox.templates.GitUser;

import java.util.List;

/**
 * Created by A on 23:36 08.10.2017.
 */

public interface IGetUsersInteractor extends Interactor {

    interface Callback {
        void onSuccess(List<GitUser> users);

        void onFail(String reason);
    }

}
