package codegym.repository;

import codegym.entity.Letter;

import java.util.List;

public interface EmailRepository {
    List<Letter> findAll();
    void update(Letter letter);
    Letter findById(String id);
}
