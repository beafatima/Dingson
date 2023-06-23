/*package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
}
*/
package com.example.myapplication;

        import android.annotation.SuppressLint;
        import android.os.Bundle;
        import android.widget.CompoundButton;
        import android.widget.TextView;
        import android.content.Context;
        import android.content.SharedPreferences;
        import android.view.View;

        import androidx.appcompat.app.AppCompatDelegate;
        import androidx.appcompat.app.AppCompatActivity;

        import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity3 extends AppCompatActivity {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    SwitchMaterial switchView;
    private TextView CountdownNotif;
    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchView = findViewById(R.id.countdownNotification);
        CountdownNotif = findViewById(R.id.CountdownNotif);

        if (switchView.isChecked()) {
            CountdownNotif.setText("Notification");
        } else {
            CountdownNotif.setText("Notification");
        }
        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    CountdownNotif.setText("Notification");
                } else {
                    CountdownNotif.setText("Notification ");
                }
                switchView = findViewById(R.id.switcher);
                sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE);
                nightMode = sharedPreferences.getBoolean("night", false);

                if (nightMode) {
                    switchView.setChecked(true);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                switchView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (nightMode) {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                            editor = sharedPreferences.edit();
                            editor.putBoolean("night", false);
                        } else {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                            editor = sharedPreferences.edit();
                            editor.putBoolean("night", true);
                        }
                        editor.apply();
                    }
                });
            }
        });
    }
}