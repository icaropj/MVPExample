package br.com.icaropinhoe.mvp_example.ui.presenters;

import javax.inject.Inject;

import br.com.icaropinhoe.mvp_example.ui.screen_contracts.MainScreen;

/**
 * Created by icaro on 22/12/2017.
 */

public class MainPresenter {

    @Inject
    public MainPresenter() {
    }


    public void onShowPostsButtonClicked(MainScreen mainScreen) {
        mainScreen.launchPostsActivity();
    }

}
