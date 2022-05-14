package com.example.validate_song.service;

import com.example.validate_song.model.Song;

public interface SongService {
    public void add(Song song);
    public void edit(Song song);
    Song findById(int id);
}
