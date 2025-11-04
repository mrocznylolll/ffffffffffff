package com.example.zadanie2;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "SwitchPrefs";
    private static final String SWITCH_KEY = "SwitchState";

    private Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySwitch = findViewById(R.id.mySwitch);


        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean switchState = prefs.getBoolean(SWITCH_KEY, false);
        mySwitch.setChecked(switchState);


        mySwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
            editor.putBoolean(SWITCH_KEY, isChecked);
            editor.apply();
        });
    }
}