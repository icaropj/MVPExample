package br.com.icaropinhoe.mvp_example.data.remote;

import java.util.List;

import br.com.icaropinhoe.mvp_example.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by icaro on 22/12/2017.
 */

public interface PostsService {

    @GET("posts")
    Call<List<Post>> getPostsList();

}
