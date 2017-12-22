package br.com.icaropinhoe.mvp_example.events;

import java.util.List;

import br.com.icaropinhoe.mvp_example.model.Post;

/**
 * Created by icaro on 22/12/2017.
 */

public class NewPostsEvent {
    List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public NewPostsEvent(List<Post> posts) {
        this.posts = posts;
    }
}
