package com.toddburgessmedia.torontoandroiddemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowIntent;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by Todd Burgess (todd@toddburgessmedia.com on 03/09/17.
 */


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class GreetingActivityTest {

    GreetingActivity activity;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Before
    public void setUp() throws Exception {

        ActivityController controller = Robolectric.buildActivity(GreetingActivity.class).create();
        activity = (GreetingActivity) controller.get();

        prefs = mock(SharedPreferences.class);
        editor = mock(SharedPreferences.Editor.class);
        when(prefs.getString(anyString(), anyString())).thenReturn("Testing");
        when(prefs.edit()).thenReturn(editor);

        activity.preferences = prefs;
        controller.start();
    }

    @Test
    public void notNull () throws Exception {

        assertNotNull(activity);
    }

    @Test
    public void testEditText() throws Exception {

        EditText editText = (EditText) activity.findViewById(R.id.greeting_libname);
        String test = editText.getText().toString();

        assertEquals(test, "Testing");
    }

    @Test
    public void testClick() throws Exception {

        Button button = (Button) activity.findViewById(R.id.greeting_submit);

        button.performClick();

        Intent intent = shadowOf(activity).getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(intent);
        assertEquals(LoveActivity.class, shadowIntent.getIntentClass());

    }
}