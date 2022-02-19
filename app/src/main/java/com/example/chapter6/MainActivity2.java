package com.example.chapter6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    MediaPlayer playerMarimba,playerMerengue;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Button marimbaButton= (Button) findViewById(R.id.MarimbaButton);
        final Button merengueButton= (Button) findViewById(R.id.merengueSong);
        //playerMarimba= new MediaPlayer();
        playerMarimba= MediaPlayer.create(this,R.raw.track1);
        //playerMerengue= new MediaPlayer();
        playerMerengue= MediaPlayer.create(this,R.raw.track2);

        playing=0;

        marimbaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(playing){
                    case 0:
                        playerMarimba.start();
                        playing=1;
                        marimbaButton.setText("Pause Marimba Song");
                        merengueButton.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        playerMarimba.pause();
                        playing=0;
                        marimbaButton.setText("Play Marimba Song");
                        merengueButton.setVisibility(View.VISIBLE);
                        break;
                }


            }
        });
        merengueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(playing){
                    case 0:
                        playerMerengue.start();
                        playing=1;
                        merengueButton.setText("Pause Merengue Song");
                        marimbaButton.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        playerMerengue.pause();
                        playing=0;
                        merengueButton.setText("Play Merengue Song");
                        marimbaButton.setVisibility(View.VISIBLE);
                        break;
                }

            }
        });
    }
}