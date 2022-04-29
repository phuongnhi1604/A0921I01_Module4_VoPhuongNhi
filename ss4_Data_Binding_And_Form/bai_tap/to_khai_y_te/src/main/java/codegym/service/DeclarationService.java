package codegym.service;

import codegym.entity.Declaration;

import java.util.List;

public interface DeclarationService {
    List<Declaration> findAll();
    void add(Declaration declaration);
    void update(Declaration declaration);
    Declaration findById(String id);
}
