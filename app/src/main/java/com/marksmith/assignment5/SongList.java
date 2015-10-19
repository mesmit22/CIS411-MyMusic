package com.marksmith.assignment5;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.marksmith.assignment5.model.Song;
import com.marksmith.assignment5.service.MockMusicService;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SongList extends Fragment {


    public SongList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_song_list, container, false);
        ListView songList = (ListView)v.findViewById(R.id.listViewSongs);
        List<Song> songs = new MockMusicService().findAll();

        SongAdapter songAdapter = new SongAdapter(getActivity(), R.layout.fragment_song_list, songs);
        songList.setAdapter(songAdapter);

        return v;
    }


}
