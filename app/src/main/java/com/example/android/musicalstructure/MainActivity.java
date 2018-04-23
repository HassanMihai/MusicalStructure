package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final String ARTIST = "Artist";
    static final String ALBUM = "Album";
    static final String IMAGE = "Image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating an ArrayList with Albums
        ArrayList<Album> albums = new ArrayList<Album>();
        albums.add(new Album(getString(R.string.placebo), getString(R.string.placebo_loud_like_love), R.drawable.loudlikelove));
        albums.add(new Album(getString(R.string.the_cranberries), getString(R.string.the_cranberries_no_need_to_argue), R.drawable.noneedtoargue));
        albums.add(new Album(getString(R.string.nirvana), getString(R.string.nirvana_nevermind), R.drawable.nevermind));
        albums.add(new Album(getString(R.string.radiohead), getString(R.string.radiohead_pablo_honey), R.drawable.pablohoney));
        albums.add(new Album(getString(R.string.coldplay), getString(R.string.coldplay_viva_la_vida_or_death),R.drawable.vivalavida));

        AlbumAdapter adapter = new AlbumAdapter(this, albums);

        GridView gridView = (GridView) findViewById(R.id.grid);

        gridView.setAdapter(adapter);

        // Set an item click listener for GridView widget
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the GridView selected/clicked item text
                Album selectedItem = (Album) parent.getItemAtPosition(position);

                // Creating intent SongsActivity with extra String ARTIST name and ALBUM name
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);
                songsIntent.putExtra(ARTIST, selectedItem.getArtistName());
                songsIntent.putExtra(ALBUM, selectedItem.getAlbumName());
                songsIntent.putExtra(IMAGE, selectedItem.getImageResourceId());
                startActivity(songsIntent);
            }
        });
    }
}
