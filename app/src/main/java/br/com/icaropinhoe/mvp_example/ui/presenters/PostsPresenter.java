package br.com.icaropinhoe.mvp_example.ui.presenters;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import br.com.icaropinhoe.mvp_example.data.remote.PostsAPI;
import br.com.icaropinhoe.mvp_example.events.ErrorEvent;
import br.com.icaropinhoe.mvp_example.events.NewPostsEvent;
import br.com.icaropinhoe.mvp_example.model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by icaro on 22/12/2017.
 */

public class PostsPresenter {

    private PostsAPI mPostsApi;

    @Inject
    public PostsPresenter(PostsAPI postsAPI) {
        this.mPostsApi = postsAPI;
    }

    public void loadPostsFromApi() {
        mPostsApi.getPostsCall().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                EventBus.getDefault().post(new NewPostsEvent(response.body()));
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                EventBus.getDefault().post(new ErrorEvent());
            }
        });
    }
}
