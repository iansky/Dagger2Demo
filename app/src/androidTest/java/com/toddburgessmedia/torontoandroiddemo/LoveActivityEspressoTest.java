package com.toddburgessmedia.torontoandroiddemo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Todd Burgess (todd@toddburgessmedia.com on 05/09/17.
 */

@RunWith(AndroidJUnit4.class)
public class LoveActivityEspressoTest {

    @Rule
    public ActivityTestRule<LoveActivity> testRule = new ActivityTestRule<>(LoveActivity.class);


    @Test
    public void testClick() {

        onView(withId(R.id.love_bye)).perform(click());
        assertTrue(testRule.getActivity().isFinishing());
    }
}

