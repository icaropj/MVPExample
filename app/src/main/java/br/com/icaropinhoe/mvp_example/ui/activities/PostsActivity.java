package br.com.icaropinhoe.mvp_example.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import br.com.icaropinhoe.mvp_example.R;
import br.com.icaropinhoe.mvp_example.dagger.DaggerInjector;
import br.com.icaropinhoe.mvp_example.events.ErrorEvent;
import br.com.icaropinhoe.mvp_example.events.NewPostsEvent;
import br.com.icaropinhoe.mvp_example.ui.adapters.PostsListAdapter;
import br.com.icaropinhoe.mvp_example.ui.presenters.PostsPresenter;
import br.com.icaropinhoe.mvp_example.ui.screen_contracts.PostsScreen;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsActivity extends AppCompatActivity implements PostsScreen{

    @Inject
    PostsPresenter mPostPresenter;

    @BindView(R.id.posts_recycler_view)
    RecyclerView mRvPosts;

    @BindView(R.id.error_view)
    TextView mErrorView;

    PostsListAdapter mPostsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        DaggerInjector.get().inject(this);
        ButterKnife.bind(this);

        initRecyclerView();
        mPostPresenter.loadPostsFromApi();
    }

    private void initRecyclerView() {
        mRvPosts.setHasFixedSize(true);
        mRvPosts.setLayoutManager(new LinearLayoutManager(mRvPosts.getContext()));
        mRvPosts.setItemAnimator(new DefaultItemAnimator());

        mPostsListAdapter = new PostsListAdapter();
        mRvPosts.setAdapter(mPostsListAdapter);
    }

    @SuppressWarnings("unused")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(NewPostsEvent newPostsEvent) {
        hideError();
        mPostsListAdapter.addPosts(newPostsEvent.getPosts());
    }

    @SuppressWarnings("unused")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(ErrorEvent errorEvent) {
        showError();
    }

    private void hideError() {
        mRvPosts.setVisibility(View.VISIBLE);
        mErrorView.setVisibility(View.GONE);
    }

    private void showError() {
        mRvPosts.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
