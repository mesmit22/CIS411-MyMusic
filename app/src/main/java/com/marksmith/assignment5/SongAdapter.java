package com.marksmith.assignment5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.marksmith.assignment5.model.Song;


import java.text.SimpleDateFormat;
import java.util.List;


public class SongAdapter extends ArrayAdapter<Song> {
    private SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("MMM d, yyyy (EEE)");

    private Context mContext;
    private List<Song> mSongs;

    public SongAdapter(Context context, int testViewResourceId, List<Song> songs) {
        super(context, testViewResourceId, songs);

        mContext = context;
        mSongs = songs;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.individual_row_layout, parent, false);
        }

        final Song song = mSongs.get(position);

        TextView txtTitle = (TextView)view.findViewById(R.id.txt_song_title);
        txtTitle.setText(song.getSongTitle());

        TextView txtAlbum = (TextView)view.findViewById(R.id.txt_album);
        txtAlbum.setText(song.getAlbumTitle());

        TextView txtPublishDate = (TextView)view.findViewById(R.id.txt_publish_date);
        txtPublishDate.setText(mSimpleDateFormat.format(song.getSongPublishedDate()));

        TextView txtArtist = (TextView)view.findViewById(R.id.txt_artist);
        txtArtist.setText(song.getArtistName());

        TextView txtUpdated = (TextView)view.findViewById(R.id.txt_update_date);
        txtUpdated.setText(""); // in case Dr. Reisz has a need for it later on

        return view;
    }
}
