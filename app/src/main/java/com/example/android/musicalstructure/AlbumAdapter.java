package com.example.android.musicalstructure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter<Album> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param albums A List of Albums objects to display in a list
     */
    public AlbumAdapter(Context context, ArrayList<Album> albums) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, albums);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_item, parent, false);
        }

        // Get the {@link Album} object located at this position in the list
        Album currentAlbum = getItem(position);

        // Find the TextView in the album_item.xml layout with the ID artist_name_view
        TextView artistNameView = (TextView) listItemView.findViewById(R.id.artist_name_view);
        // Get the artist name from the current Album object and
        // set this text on the artist name TextView
        artistNameView.setText(currentAlbum.getArtistName());

        // Find the TextView in the album_item.xml layout with the ID album_name_view
        TextView albumNameView = (TextView) listItemView.findViewById(R.id.album_name_view);
        // Get the album name from the current Album object and
        // set this text on the album name TextView
        albumNameView.setText(currentAlbum.getAlbumName());

        // Find the ImageView in the album_item.xml layout with the ID album_image_view
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.album_image_view);
        // Get the image resource ID from the current Album object and
        // set the image to ImageView
        iconView.setImageResource(currentAlbum.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView / GridView
        return listItemView;
    }
}
