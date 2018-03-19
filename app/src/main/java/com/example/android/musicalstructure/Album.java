package com.example.android.musicalstructure;

public class Album {

    /** Artist name of the album */
    private String mArtistName;

    /** Album name */
    private String mAlbumName;

    /** Album image */
    private int mImageResourceId;

    public Album(String artistName, String albumName, int imageResourceId) {
        mArtistName = artistName;
        mAlbumName = albumName;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the artist name
     */
    public String getArtistName(){
        return mArtistName;
    }

    /**
     * Get the album name
     */
    public String getAlbumName(){
        return mAlbumName;
    }

    /**
     * Get the album image
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
}
