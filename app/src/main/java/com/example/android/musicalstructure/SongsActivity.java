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
        String album = mIntent.getStringExtra("ALBUM").toLowerCase();
        String artist = mIntent.getStringExtra("ARTIST").toLowerCase();

        artistName.setText(artist);
        albumName.setText(album);

        // Creating ArrayList with songs of albums
        ArrayList<Song> songs = new ArrayList<Song>();

        if (album.equals("loud like love") && artist.equals("placebo")) {
            songs.add(new Song("Placebo", "Loud Like Love"));
            songs.add(new Song("Placebo", "Scene of the Crime"));
            songs.add(new Song("Placebo", "Too Many Friends"));
            songs.add(new Song("Placebo", "Hold on to Me"));
            songs.add(new Song("Placebo", "Rob the Bank"));
            songs.add(new Song("Placebo", "A Million Little Pieces"));
            songs.add(new Song("Placebo", "Exit Wounds"));
            songs.add(new Song("Placebo", "Purify"));
            songs.add(new Song("Placebo", "Begin the End"));
            songs.add(new Song("Placebo", "Bosco"));
            albumImage.setImageResource(R.drawable.loudlikelove);
        }

        if (album.equals("no need to argue") && artist.equals("the cranberries")) {
            songs.add(new Song("The Cranberries", "Ode to My Family"));
            songs.add(new Song("The Cranberries", "I Can't Be with You"));
            songs.add(new Song("The Cranberries", "Twenty One"));
            songs.add(new Song("The Cranberries", "Zombie"));
            songs.add(new Song("The Cranberries", "Empty"));
            songs.add(new Song("The Cranberries", "Everything I Said"));
            songs.add(new Song("The Cranberries", "The Icicle Melts"));
            songs.add(new Song("The Cranberries", "Disappointment"));
            songs.add(new Song("The Cranberries", "Ridiculous Thoughts"));
            songs.add(new Song("The Cranberries", "Dreaming My Dreams"));
            songs.add(new Song("The Cranberries", "Yeats' Grave"));
            songs.add(new Song("The Cranberries", "Daffodil Lament"));
            songs.add(new Song("The Cranberries", "No Need to Argue"));
            albumImage.setImageResource(R.drawable.noneedtoargue);
        }

        if (album.equals("nevermind") && artist.equals("nirvana")) {
            songs.add(new Song("Nirvana", "Smells Like Teen Spirit"));
            songs.add(new Song("Nirvana", "In Bloom"));
            songs.add(new Song("Nirvana", "Come as You Are"));
            songs.add(new Song("Nirvana", "Breed"));
            songs.add(new Song("Nirvana", "Lithium"));
            songs.add(new Song("Nirvana", "Polly"));
            songs.add(new Song("Nirvana", "Territorial Pissings"));
            songs.add(new Song("Nirvana", "Drain You"));
            songs.add(new Song("Nirvana", "Lounge Act"));
            songs.add(new Song("Nirvana", "Stay Away"));
            songs.add(new Song("Nirvana", "On a Plain"));
            songs.add(new Song("Nirvana", "Something in the Way"));
            albumImage.setImageResource(R.drawable.nevermind);
        }

        if (album.equals("pablo honey") && artist.equals("radiohead")) {
            songs.add(new Song("Radiohead", "You"));
            songs.add(new Song("Radiohead", "Creep"));
            songs.add(new Song("Radiohead", "How Do You?"));
            songs.add(new Song("Radiohead", "Stop Whispering"));
            songs.add(new Song("Radiohead", "Thinking About You"));
            songs.add(new Song("Radiohead", "Anyone Can Play Guitar"));
            songs.add(new Song("Radiohead", "Ripcord"));
            songs.add(new Song("Radiohead", "Vegetable"));
            songs.add(new Song("Radiohead", "Prove Yourself"));
            songs.add(new Song("Radiohead", "I Can't"));
            songs.add(new Song("Radiohead", "Lurgee"));
            songs.add(new Song("Radiohead", "Blow Out"));
            albumImage.setImageResource(R.drawable.pablohoney);
        }

        if (album.equals("viva la vida or death and all his friends") && artist.equals("coldplay")) {
            songs.add(new Song("Coldplay", "Life in Technicolor"));
            songs.add(new Song("Coldplay", "Cemeteries of London"));
            songs.add(new Song("Coldplay", "Lost!"));
            songs.add(new Song("Coldplay", "42"));
            songs.add(new Song("Coldplay", "Lovers in Japan/Reign of Love"));
            songs.add(new Song("Coldplay", "Yes"));
            songs.add(new Song("Coldplay", "Viva la Vida"));
            songs.add(new Song("Coldplay", "Violet Hill"));
            songs.add(new Song("Coldplay", "Strawberry Swing"));
            songs.add(new Song("Coldplay", "Death and All His Friends"));
            songs.add(new Song("Coldplay", "Lost?"));
            songs.add(new Song("Coldplay", "Lovers in Japan (Acoustic Version)"));
            songs.add(new Song("Coldplay", "Death Will Never Conquer"));
            songs.add(new Song("Coldplay", "Life in Technicolor"));
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
                Intent intent = new Intent(SongsActivity.this, NowPlayingActivity.class);
                intent.putExtra("SONG", nowPlayingSong);
                intent.putExtra("ARTIST", nowPlayingArtist);
                intent.putExtra("PLAY", play);
                startActivity(intent);
            }
        });
    }
}
