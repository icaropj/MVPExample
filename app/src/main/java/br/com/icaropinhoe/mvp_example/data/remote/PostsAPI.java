package br.com.icaropinhoe.mvp_example.data.remote;

import java.util.List;

import br.com.icaropinhoe.mvp_example.model.Post;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by icaro on 22/12/2017.
 */

public class PostsAPI {

    private Call<List<Post>> postsCall = new Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PostsService.class).getPostsList();


    public Call<List<Post>> getPostsCall() {
        return postsCall;
    }

}
