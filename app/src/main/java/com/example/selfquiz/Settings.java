package com.example.selfquiz;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Timer;

public class Settings extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch timer, music;
    Button clearData, save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        timer = findViewById(R.id.timer);
        music = findViewById(R.id.music);
        save = findViewById(R.id.saveSettings);

        //sets music
        save.setOnClickListener(view -> {
            if (music.isChecked()) {
                onMusicStart();
            } else {
                onMusicPause();
            }

            //turns timer mode on if it is switched
            SharedPreferences sharedPreferences = getSharedPreferences("Timer", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("timerState", timer.isChecked());
            editor.apply();
            onBackPressed();
        });
    }

    //different music for the mood
    public void onMusicStart () {
        if (mediaPlayer == null) {
            if (timer.isChecked() && music.isChecked()) {
                mediaPlayer = MediaPlayer.create(this, R.raw.timermusic);
            } else if (music.isChecked()&& !timer.isChecked()){
                mediaPlayer = MediaPlayer.create(this, R.raw.canonind);
            }
            mediaPlayer.start();
        }
    }

    @SuppressLint("SuspiciousIndentation")
    public void onMusicPause (){
        if (mediaPlayer!= null)
        mediaPlayer.stop();
    }

}


