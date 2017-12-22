package br.com.icaropinhoe.mvp_example.dagger;

import br.com.icaropinhoe.mvp_example.dagger.components.AppComponent;
import br.com.icaropinhoe.mvp_example.dagger.components.DaggerAppComponent;
import br.com.icaropinhoe.mvp_example.dagger.modules.AppModule;

/**
 * Created by icaro on 22/12/2017.
 */

public class DaggerInjector {

    private static AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();

    public static AppComponent get() {
        return appComponent;
    }

}
