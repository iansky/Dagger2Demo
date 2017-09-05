package com.toddburgessmedia.torontoandroiddemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.endsWith;

/**
 * Created by Todd Burgess (todd@toddburgessmedia.com on 05/09/17.
 */

@RunWith(AndroidJUnit4.class)
public class GreetingActivityEspresso {

    @Rule
    public ActivityTestRule<GreetingActivity> activityTestRule = new ActivityTestRule<>(GreetingActivity.class);

    @Test
    public void changeText() {

        onView(withId(R.id.greeting_libname)).perform(clearText());
        onView(withId(R.id.greeting_libname)).perform(typeText("Testing"), closeSoftKeyboard());
        onView(withId(R.id.greeting_libname)).check(matches(withText("Testing")));
    }

    @Test
    public void testChange() {

        onView(withId(R.id.greeting_libname)).perform(clearText());
        onView(withId(R.id.greeting_libname)).perform(typeText("Testing"), closeSoftKeyboard());
        onView(withId(R.id.greeting_submit)).perform(click());

        onView(withId(R.id.love_greeting)).check(matches(withText(endsWith("Testing"))));


    }


}