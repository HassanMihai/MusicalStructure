package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {

    private TextView nowPlayingSongView;
    private ImageView playPause;

    private boolean play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        nowPlayingSongView = (TextView) findViewById(R.id.song_text_view);
        playPause = (ImageView) findViewById(R.id.play_pause);

        // Getting extra String SONG name and ARTIST name from SongsActivity
        Intent mIntent = getIntent();
        String nowPlayingSong = mIntent.getStringExtra("SONG");
        String nowPlayingArtist = mIntent.getStringExtra("ARTIST");
        play = mIntent.getBooleanExtra("PLAY", true);

        String playingSong = nowPlayingSong + " - " + nowPlayingArtist;

        nowPlayingSongView.setText(playingSong);

        displayPlayPauseButton();
    }

    /**
     * This method saves the state of now playing song view
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isPlaying", play);
    }

    /**
     * This method restores the state of now playing song view
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        play = savedInstanceState.getBoolean("isPlaying");
        displayPlayPauseButton();
    }

    /**
     * This method display Play or Pause button
     */
    public void displayPlayPauseButton() {

        if (play) {
            playPause.setImageResource(R.drawable.pause_black);
        }
        else {
            playPause.setImageResource(R.drawable.play_black);
        }

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (play) {
                    play = false;
                    playPause.setImageResource(R.drawable.play_black);
                    String pause = getString(R.string.pause);
                    Toast.makeText(NowPlayingActivity.this, pause, Toast.LENGTH_SHORT).show();
                } else {
                    play = true;
                    playPause.setImageResource(R.drawable.pause_black);
                    String play = getString(R.string.play);
                    Toast.makeText(NowPlayingActivity.this, play, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
