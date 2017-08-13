package com.toddburgessmedia.torontoandroiddemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

/**
 * The Love Activity displays the Android Library the user says they love
 */
public class LoveActivity extends AppCompatActivity {

    /**
     * The SharedPreferences injected by Dagger 2
     */
    @Inject
    SharedPreferences preferences;

    /**
     * The greeting to display the user TextView view
     */
    TextView greeting;

    /**
     * The first method called as part of the Activity lifecycle
     *
     * @param savedInstanceState not used
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);

        ((DemoApplication) getApplication()).getComponent().inject(this);

        greeting = (TextView) findViewById(R.id.love_greeting);
    }

    /**
     * The onStart method sets up all the display part of the activity
     */
    @Override
    protected void onStart() {
        super.onStart();

        String greetingText = "You love " + preferences.getString("lovedLib","Butterknife");
        greeting.setText(greetingText);
    }

    /**
     * The click handler for the button. Calls finish() and returns to GreetingActivity
     *
     * @param view the Button that triggered the event
     */
    public void greatClick(View view) {
        finish();
    }
}
