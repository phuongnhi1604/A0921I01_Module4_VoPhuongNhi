package codegym.repository;

import codegym.entity.Song;

import java.util.List;

public interface SongRepository {
    public void create(Song song);
    public List<Song> findAll();
    public void update(int id,Song song);
    public void listen(Song song);
    public void delete(int id);
    public Song findById(int id);

}
