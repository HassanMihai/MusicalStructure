package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    static final String ARTIST = "Artist";
    static final String ALBUM = "Album";
    static final String SONG = "Song";
    static final String PLAY = "Play";

    private boolean play;
    private LinearLayout nowPlayingView;
    private LinearLayout nowPlaying;
    private ImageView playPause;
    private TextView nowPlayingArtistView;
    private TextView nowPlayingSongView;
    private String nowPlayingArtist;
    private String nowPlayingSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        ImageView albumImage = (ImageView) findViewById(R.id.songs_album_image_view);
        TextView artistName = (TextView) findViewById(R.id.songs_artist_text_view);
        TextView albumName = (TextView) findViewById(R.id.songs_album_name_view);
        nowPlayingView = (LinearLayout) findViewById(R.id.now_playing_view);
        nowPlayingArtistView = (TextView) findViewById(R.id.now_playing_artist);
        nowPlayingSongView = (TextView) findViewById(R.id.now_playing_song);
        playPause = (ImageView) findViewById(R.id.play_pause);
        nowPlaying = (LinearLayout) findViewById(R.id.now_playing);

        // Getting extra String ALBUM name and ARTIST name from MainActivity
        Intent mIntent = getIntent();
        String album = mIntent.getStringExtra(ALBUM);
        String artist = mIntent.getStringExtra(ARTIST);

        artistName.setText(artist);
        albumName.setText(album);

        // Creating ArrayList with songs of albums
        ArrayList<Song> songs = new ArrayList<Song>();

        if (album.equals(getString(R.string.placebo_loud_like_love)) && artist.equals(getString(R.string.placebo))) {
            songs.add(new Song(getString(R.string.placebo), getString(R.string.placebo_loud_like_love)));
            songs.add(new Song(getString(R.string.placebo), getString(R.string.placebo_scene_of_the_crime)));
            songs.add(new Song(getString(R.string.placebo), getString(R.string.placebo_too_many_friends)));
            songs.add(new Song(getString(R.string.placebo), getString(R.string.placebo_hold_on_to_me)));
            songs.add(new Song(getString(R.string.placebo), getString(R.string.placebo_rob_the_bank)));
            songs.add(new Song(getString(R.string.placebo), getString(R.string.placebo_a_million_little_pieces)));
            songs.add(new Song(getString(R.string.placebo), getString(R.string.placebo_exit_wounds)));
            songs.add(new Song(getString(R.string.placebo), getString(R.string.placebo_purify)));
            songs.add(new Song(getString(R.string.placebo), getString(R.string.placebo_begin_the_end)));
            songs.add(new Song(getString(R.string.placebo), getString(R.string.placebo_bosco)));
            albumImage.setImageResource(R.drawable.loudlikelove);
        }

        if (album.equals(getString(R.string.the_cranberries_no_need_to_argue)) && artist.equals(getString(R.string.the_cranberries))) {
            songs.add(new Song(getString(R.string.the_cranberries), getString(R.string.the_cranberries_ode_to_my_family)));
            songs.add(new Song(getString(R.string.the_cranberries), getString(R.string.the_cranberries_i_cant_be_with_you)));
            songs.add(new Song(getString(R.string.the_cranberries), getString(R.string.the_cranberries_twenty_one)));
            songs.add(new Song(getString(R.string.the_cranberries), getString(R.string.the_cranberries_zombie)));
            songs.add(new Song(getString(R.string.the_cranberries), getString(R.string.the_cranberries_empty)));
            songs.add(new Song(getString(R.string.the_cranberries), getString(R.string.the_cranberries_everything_i_said)));
            songs.add(new Song(getString(R.string.the_cranberries), getString(R.string.the_cranberries_the_icicle_melts)));
            songs.add(new Song(getString(R.string.the_cranberries), getString(R.string.the_cranberries_disappointment)));
            songs.add(new Song(getString(R.string.the_cranberries), getString(R.string.the_cranberries_ridiculous_thoughts)));
            songs.add(new Song(getString(R.string.the_cranberries), getString(R.string.the_cranberries_dreaming_my_dreams)));
            songs.add(new Song(getString(R.string.the_cranberries), getString(R.string.the_cranberries_yeats_grave)));
            songs.add(new Song(getString(R.string.the_cranberries), getString(R.string.the_cranberries_daffodil_lament)));
            songs.add(new Song(getString(R.string.the_cranberries), getString(R.string.the_cranberries_no_need_to_argue)));
            albumImage.setImageResource(R.drawable.noneedtoargue);
        }

        if (album.equals(getString(R.string.nirvana_nevermind)) && artist.equals(getString(R.string.nirvana))) {
            songs.add(new Song(getString(R.string.nirvana), getString(R.string.nirvana_smells_like_teen_spirit)));
            songs.add(new Song(getString(R.string.nirvana), getString(R.string.nirvana_in_bloom)));
            songs.add(new Song(getString(R.string.nirvana), getString(R.string.nirvana_come_as_you_are)));
            songs.add(new Song(getString(R.string.nirvana), getString(R.string.nirvana_breed)));
            songs.add(new Song(getString(R.string.nirvana), getString(R.string.nirvana_lithium)));
            songs.add(new Song(getString(R.string.nirvana), getString(R.string.nirvana_polly)));
            songs.add(new Song(getString(R.string.nirvana), getString(R.string.nirvana_territorial_pissings)));
            songs.add(new Song(getString(R.string.nirvana), getString(R.string.nirvana_drain_you)));
            songs.add(new Song(getString(R.string.nirvana), getString(R.string.nirvana_lounge_act)));
            songs.add(new Song(getString(R.string.nirvana), getString(R.string.nirvana_stay_away)));
            songs.add(new Song(getString(R.string.nirvana), getString(R.string.nirvana_on_a_plain)));
            songs.add(new Song(getString(R.string.nirvana), getString(R.string.nirvana_something_in_the_way)));
            albumImage.setImageResource(R.drawable.nevermind);
        }

        if (album.equals(getString(R.string.radiohead_pablo_honey)) && artist.equals(getString(R.string.radiohead))) {
            songs.add(new Song(getString(R.string.radiohead), getString(R.string.radiohead_you)));
            songs.add(new Song(getString(R.string.radiohead), getString(R.string.radiohead_creep)));
            songs.add(new Song(getString(R.string.radiohead), getString(R.string.radiohead_how_do_you)));
            songs.add(new Song(getString(R.string.radiohead), getString(R.string.radiohead_stop_whispering)));
            songs.add(new Song(getString(R.string.radiohead), getString(R.string.radiohead_thinking_about_you)));
            songs.add(new Song(getString(R.string.radiohead), getString(R.string.radiohead_anyone_can_play_guitar)));
            songs.add(new Song(getString(R.string.radiohead), getString(R.string.radiohead_ripcord)));
            songs.add(new Song(getString(R.string.radiohead), getString(R.string.radiohead_vegetable)));
            songs.add(new Song(getString(R.string.radiohead), getString(R.string.radiohead_prove_yourself)));
            songs.add(new Song(getString(R.string.radiohead), getString(R.string.radiohead_i_cant)));
            songs.add(new Song(getString(R.string.radiohead), getString(R.string.radiohead_lurgee)));
            songs.add(new Song(getString(R.string.radiohead), getString(R.string.radiohead_blow_out)));
            albumImage.setImageResource(R.drawable.pablohoney);
        }

        if (album.equals(getString(R.string.coldplay_viva_la_vida_or_death)) && artist.equals(getString(R.string.coldplay))) {
            songs.add(new Song(getString(R.string.coldplay), getString(R.string.coldplay_life_in_technicolor)));
            songs.add(new Song(getString(R.string.coldplay), getString(R.string.coldplay_cemeteries_of_london)));
            songs.add(new Song(getString(R.string.coldplay), getString(R.string.coldplay_lost_ex)));
            songs.add(new Song(getString(R.string.coldplay), getString(R.string.coldplay_42)));
            songs.add(new Song(getString(R.string.coldplay), getString(R.string.coldplay_lovers_in_japan)));
            songs.add(new Song(getString(R.string.coldplay), getString(R.string.coldplay_yes)));
            songs.add(new Song(getString(R.string.coldplay), getString(R.string.coldplay_viva_la_vida)));
            songs.add(new Song(getString(R.string.coldplay), getString(R.string.coldplay_violet_hill)));
            songs.add(new Song(getString(R.string.coldplay), getString(R.string.coldplay_strawberry_swing)));
            songs.add(new Song(getString(R.string.coldplay), getString(R.string.coldplay_death_and_all_his_friends)));
            songs.add(new Song(getString(R.string.coldplay), getString(R.string.coldplay_lost_qu)));
            songs.add(new Song(getString(R.string.coldplay), getString(R.string.coldplay_lovers_in_japan_acoustic)));
            songs.add(new Song(getString(R.string.coldplay), getString(R.string.coldplay_death_will_never_conquer)));
            songs.add(new Song(getString(R.string.coldplay), getString(R.string.coldplay_life_in_technicolor)));
            albumImage.setImageResource(R.drawable.vivalavida);
        }

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        // Set an item click listener for GridView widget
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the GridView selected/clicked item text
                Song selectedItem = (Song) parent.getItemAtPosition(position);
                play = true;
                nowPlayingArtist = selectedItem.getArtistName();
                nowPlayingSong = selectedItem.getSongName();
                displayNowPlaying();
                String nowPlaying = getString(R.string.now_playing, selectedItem.getSongName());
                Toast.makeText(SongsActivity.this, nowPlaying, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * This method saves the state of now playing song view
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isPlaying", play);
        outState.putString("songPlaying", nowPlayingSong);
        outState.putString("artistPlaying", nowPlayingArtist);
    }

    /**
     * This method restores the state of now playing song view
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        play = savedInstanceState.getBoolean("isPlaying");
        nowPlayingSong = savedInstanceState.getString("songPlaying");
        nowPlayingArtist = savedInstanceState.getString("artistPlaying");
        displayNowPlaying();
    }

    /**
     * This method display the view of now playing song
     */
    public void displayNowPlaying() {
        if (play) {
            nowPlayingView.setVisibility(LinearLayout.VISIBLE);
            nowPlayingSongView.setText(nowPlayingSong);
            nowPlayingArtistView.setText(nowPlayingArtist);
            if (play) {
                playPause.setImageResource(R.drawable.pause_white);
            } else {
                playPause.setImageResource(R.drawable.play_white);
            }
        }

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (play) {
                    play = false;
                    playPause.setImageResource(R.drawable.play_white);
                    String pause = getString(R.string.pause);
                    Toast.makeText(SongsActivity.this, pause, Toast.LENGTH_SHORT).show();
                } else {
                    play = true;
                    playPause.setImageResource(R.drawable.pause_white);
                    String play = getString(R.string.play);
                    Toast.makeText(SongsActivity.this, play, Toast.LENGTH_SHORT).show();
                }
            }
        });

        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating intent NowPlayingActivity with extra String SONG name and ARTIST name
                Intent nowPlayingIntent = new Intent(SongsActivity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtra(SONG, nowPlayingSong);
                nowPlayingIntent.putExtra(ARTIST, nowPlayingArtist);
                nowPlayingIntent.putExtra(PLAY, play);
                startActivity(nowPlayingIntent);
            }
        });
    }
}
