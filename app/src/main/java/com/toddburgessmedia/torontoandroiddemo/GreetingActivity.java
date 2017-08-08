package com.toddburgessmedia.torontoandroiddemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

public class GreetingActivity extends AppCompatActivity {

    /**
     * The SharedPReferences injected by Dagger 2
     */
    @Inject
    SharedPreferences preferences;

    /**
     *  The EditText view in the layout
     */
    EditText libName;

    /**
     * The submission button
     */
    Button submit;

    /**
     * The onCreate method used to setup the Activity. The Dagger 2 injection will happen here
     *
     * @param savedInstanceState not used in this activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * The Dagger 2 injection happens here
         */
        ((DemoApplication) getApplication()).component.inject(this);

        setContentView(R.layout.activity_greeting);

        libName = (EditText) findViewById(R.id.greeting_libname);
        submit = (Button) findViewById(R.id.greeting_submit);

    }

    /**
     * The onStart method sets up the layout for the activity
     */
    @Override
    protected void onStart() {
        super.onStart();

        String library = preferences.getString("lovedLib","Butterknife");
        libName.setText(library);
    }

    /**
     * The onClick event handler for the button. Save the EditText as a SharedPreference and start
     * the LoveActivity to display the results
     * @param view
     */
    public void submitLibrary(View view) {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("lovedLib", libName.getText().toString());
        edit.apply();

        Intent intent = new Intent(this,LoveActivity.class);
        startActivity(intent);
    }
}
