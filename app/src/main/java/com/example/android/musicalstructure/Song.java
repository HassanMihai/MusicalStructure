package com.example.android.musicalstructure;

public class Song {

    /** Artist name of the song */
    private String mArtistName;

    /** Song name */
    private String mSongName;

    public Song(String artistName, String songName) {
        mArtistName = artistName;
        mSongName = songName;
    }

    /**
     * Get the artist name
     */
    public String getArtistName(){
        return mArtistName;
    }

    /**
     * Get the song name
     */
    public String getSongName() {
        return mSongName;
    }
}
