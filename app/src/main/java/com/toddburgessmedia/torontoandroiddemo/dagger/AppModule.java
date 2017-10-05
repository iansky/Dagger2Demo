package com.toddburgessmedia.torontoandroiddemo.dagger;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Todd Burgess (todd@toddburgessmedia.com on 06/08/17.
 */

/**
 * The AppModule is the Module that provides all the Dagger 2 dependencies
 * <P>
 *     Methods annotated with @Provides are methods that provide objects Dagger 2 can inject
 * </P>
 * <P>
 *     Methods with @Singleton will be Singletons with only one instance in the app
 * </P>
 */
@Module
public class AppModule {

    /**
     * The Android application
     */
    Application application;

    /**
     * The Module constructor.
     * @param app The application instance
     */
    public AppModule(Application app) {
        this.application = app;
    }

    /**
     * Getter that provides the current Application instance. Used for the SharedPreference dependency
     * @return The Application instance
     */
    @Provides
    @Singleton
    public Application getApplication() {
        return application;
    }

    /**
     * Returns the SharedPreferences
     * @param app the current application instance
     * @return a SharedPreference object using the file example
     */
    @Provides
    @Singleton
    public SharedPreferences getSharedPreferences(Application app) {

        return
    }

    /**
     * Creates SharedPreferences using release file. Demonstrates how to use @Named parameter
     * to create two objects with different states
     * @param app the app instance
     * @return the SharedPreferences object using the file release
     */
    @Provides
    @Singleton
    @Named("release")
    public SharedPreferences getSharedReleasePreferences(Application app) {

        return app.getSharedPreferences("release", Context.MODE_PRIVATE);
    }

    @
}
