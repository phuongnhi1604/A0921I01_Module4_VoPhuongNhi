package com.example.validate_song.service;

import com.example.validate_song.model.Song;

import java.util.List;

public interface SongService {
    List<Song> findAll();
    public void add(Song song);
    public void edit(Song song);
    Song findById(int id);
}
