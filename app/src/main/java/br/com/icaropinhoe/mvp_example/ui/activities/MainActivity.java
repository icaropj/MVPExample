package br.com.icaropinhoe.mvp_example.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import br.com.icaropinhoe.mvp_example.R;
import br.com.icaropinhoe.mvp_example.dagger.DaggerInjector;
import br.com.icaropinhoe.mvp_example.ui.presenters.MainPresenter;
import br.com.icaropinhoe.mvp_example.ui.screen_contracts.MainScreen;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainScreen{

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerInjector.get().inject(this);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.activity_main_showposts_button)
    public void onShowPostsButtonClicked(){
        mainPresenter.onShowPostsButtonClicked(this);
    }

    @Override
    public void launchPostsActivity() {
        Intent intent = new Intent(MainActivity.this, PostsActivity.class);
        startActivity(intent);
    }
}
