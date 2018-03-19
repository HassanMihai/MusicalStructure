package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating an ArrayList with Albums
        ArrayList<Album> albums = new ArrayList<Album>();
        albums.add(new Album("Placebo", "Loud Like Love", R.drawable.loudlikelove));
        albums.add(new Album("The Cranberries", "No Need To Argue", R.drawable.noneedtoargue));
        albums.add(new Album("Nirvana", "Nevermind", R.drawable.nevermind));
        albums.add(new Album("Radiohead", "Pablo Honey", R.drawable.pablohoney));
        albums.add(new Album("Coldplay", "Viva la Vida or Death and All His Friends",R.drawable.vivalavida));

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
                Intent intent = new Intent(MainActivity.this, SongsActivity.class);
                intent.putExtra("ARTIST", selectedItem.getArtistName());
                intent.putExtra("ALBUM", selectedItem.getAlbumName());
                startActivity(intent);
            }
        });
    }
}
