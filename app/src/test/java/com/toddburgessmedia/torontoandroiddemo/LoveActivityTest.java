package com.toddburgessmedia.torontoandroiddemo;

import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by Todd Burgess (todd@toddburgessmedia.com on 03/09/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class LoveActivityTest {

    LoveActivity loveActivity;
    SharedPreferences preferences;

    @Before
    public void setUp() throws Exception {

        ActivityController controller = Robolectric.buildActivity(LoveActivity.class).create();
        loveActivity = (LoveActivity) controller.get();

        preferences = mock(SharedPreferences.class);
        when(preferences.getString(anyString(),anyString())).thenReturn("Testing");
        loveActivity.preferences = preferences;
        controller.start();

    }

    @Test
    public void onStart() throws Exception {

        TextView textView = (TextView) loveActivity.findViewById(R.id.love_greeting);
        String test = textView.getText().toString();

        assertThat(test, containsString("Testing"));
    }

    @Test
    public void greatClick() throws Exception {

        Button button = (Button) loveActivity.findViewById(R.id.love_bye);

        button.performClick();
        ShadowActivity shadowActivity = shadowOf(loveActivity);
        assertTrue(shadowActivity.isFinishing());

    }

    @Test
    public void notNull() throws Exception {

        assertNotNull(loveActivity);
    }

}