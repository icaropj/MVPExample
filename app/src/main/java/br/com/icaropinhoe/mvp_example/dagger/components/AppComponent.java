package br.com.icaropinhoe.mvp_example.dagger.components;

import javax.inject.Singleton;

import br.com.icaropinhoe.mvp_example.dagger.modules.AppModule;
import br.com.icaropinhoe.mvp_example.ui.activities.MainActivity;
import br.com.icaropinhoe.mvp_example.ui.activities.PostsActivity;
import dagger.Component;

/**
 * Created by icaro on 22/12/2017.
 */

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity activity);

    void inject(PostsActivity postsActivity);
}
