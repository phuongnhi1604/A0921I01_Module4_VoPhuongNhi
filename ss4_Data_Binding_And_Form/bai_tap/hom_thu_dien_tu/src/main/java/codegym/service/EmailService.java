package codegym.service;

import codegym.entity.Letter;

import java.util.List;

public interface EmailService {
    List<Letter> findAll();
    void update(Letter letter);
    Letter findById(String id);
}
