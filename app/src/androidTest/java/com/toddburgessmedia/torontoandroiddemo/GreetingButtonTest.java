package com.toddburgessmedia.torontoandroiddemo;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Created by Todd Burgess (todd@toddburgessmedia.com on 05/09/17.
 */

@RunWith(AndroidJUnit4.class)
public class GreetingButtonTest {

    @Rule
    public IntentsTestRule<GreetingActivity> testRule = new IntentsTestRule<GreetingActivity>(GreetingActivity.class);

    @Test
    public void testButton() {

        onView(withId(R.id.greeting_submit)).perform(click());
        intended(allOf(hasComponent(hasShortClassName(".LoveActivity"))));

    }
}
