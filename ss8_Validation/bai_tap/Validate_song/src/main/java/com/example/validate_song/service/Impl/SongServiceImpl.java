package com.example.validate_song.service.Impl;

import com.example.validate_song.model.Song;
import com.example.validate_song.repository.SongRepository;
import com.example.validate_song.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void add(Song song) {
        songRepository.save(song);
    }

    @Override
    public void edit(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id).orElse(null);
    }
}
