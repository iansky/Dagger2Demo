package com.toddburgessmedia.torontoandroiddemo.dagger;

import com.toddburgessmedia.torontoandroiddemo.GreetingActivity;
import com.toddburgessmedia.torontoandroiddemo.LoveActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Todd Burgess (todd@toddburgessmedia.com on 06/08/17.
 */

/**
 * The DemoComponent is what wires the Modules to the activities so they can get their
 * dependencies
 */
@Singleton
@Component(modules={AppModule.class})
public interface DemoComponent {

    /**
     * The method needed to inject GreetingsActivity
     * @param activity the GreetingsActivity to inject
     */
    void inject(GreetingActivity activity);

    /**
     * The method needed to inject LoveActivity
     * @param activity the LoveActivity to inject
     */
    void inject(LoveActivity activity);
}
