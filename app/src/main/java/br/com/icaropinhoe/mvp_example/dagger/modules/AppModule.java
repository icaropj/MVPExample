package br.com.icaropinhoe.mvp_example.dagger.modules;

import javax.inject.Singleton;

import br.com.icaropinhoe.mvp_example.data.remote.PostsAPI;
import dagger.Module;
import dagger.Provides;

/**
 * Created by icaro on 22/12/2017.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    PostsAPI providePostsApi(){
        return new PostsAPI();
    }

}
