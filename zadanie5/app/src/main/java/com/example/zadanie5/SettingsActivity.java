package com.example.zadanie5;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "SettingsPrefs";

    private EditText nameInput;
    private Switch notificationsSwitch;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        nameInput = findViewById(R.id.nameInput);
        notificationsSwitch = findViewById(R.id.notificationsSwitch);
        saveButton = findViewById(R.id.saveButton);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        nameInput.setText(prefs.getString("userName", ""));
        notificationsSwitch.setChecked(prefs.getBoolean("notificationsenabled", false));

        saveButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("userName", nameInput.getText().toString());
            editor.putBoolean("notificationsenabled", notificationsSwitch.isChecked());
            editor.apply();
            Toast.makeText(this, "ustawienia zosatluy zapisane", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
