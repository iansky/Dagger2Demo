package com.toddburgessmedia.torontoandroiddemo;

import android.app.Application;

import com.toddburgessmedia.torontoandroiddemo.dagger.AppModule;
import com.toddburgessmedia.torontoandroiddemo.dagger.DaggerDemoComponent;
import com.toddburgessmedia.torontoandroiddemo.dagger.DemoComponent;

/**
 * Created by Todd Burgess (todd@toddburgessmedia.com on 06/08/17.
 */

/**
 * The Application creates the Dagger 2 component instance for Dagger 2 injection
 */
public class DemoApplication extends Application {

    /**
     * The compnent that feeds activities their dependencies
     */
    DemoComponent component;

    /**
     * The application onCreate method creates the component
     */
    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * Dagger 2 generates all these methods to build the component.
         * <P>
         *     Before doing this code rebuild the project so the Dagger 2 annotaion
         *     processor can create all the methods
         * </P>
         */
        component = DaggerDemoComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
    }

    /**
     * Gives activities access to the component for dependency injection
     * @return the DemoComponent for dependency injection
     */
    public DemoComponent getComponent () {
        return component;
    }

}
