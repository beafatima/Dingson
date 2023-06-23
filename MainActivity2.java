package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity2 extends AppCompatActivity {

 private SwitchMaterial soundSwitch;
 private AudioManager audioManager;

 @SuppressLint("MissingInflatedId")
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main2);

  // Initialize the AudioManager
  audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

  // Get a reference to the SwitchMaterial
  soundSwitch = findViewById(R.id.soundEffect);

  // Set the initial state of the Switch based on the current sound settings
  soundSwitch.setChecked(audioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL);

  // Set a listener for the Switch
  soundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
   @Override
   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    // Toggle the sound based on the Switch state
    if (isChecked) {
     audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
    } else {
     audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }
   }
  });
 }
}


/*
import static com.example.myapplication.R.id.toggle;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity2 extends AppCompatActivity {

 private AudioManager audioManager;
 ToggleButton toggleButton;

 @SuppressLint("MissingInflatedId")
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main2);

  toggleButton = findViewById(R.id.toggle);

  audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

  toggleButton.setChecked(isSoundOn());

  toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
   @Override
   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    if (isChecked) {
     setSoundOn();
     Toast.makeText(MainActivity2.this, "Sound On", Toast.LENGTH_SHORT).show();
    } else {
     setSoundOff();
     Toast.makeText(MainActivity2.this, "Sound Off", Toast.LENGTH_SHORT).show();
    }
   }
  });
 }

 private boolean isSoundOn() {
  return audioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL;
 }

 private void setSoundOn() {
  audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
 }

 private void setSoundOff() {
  audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
 }
}


*/






/*package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
*/
