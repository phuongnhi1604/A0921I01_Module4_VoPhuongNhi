package codegym.repository;

import codegym.entity.Declaration;

import java.util.List;

public interface DeclarationRepository {
    List<Declaration> findAll();
    void add(Declaration declaration);
    void update(Declaration declaration);
    Declaration findById(String id);
}
