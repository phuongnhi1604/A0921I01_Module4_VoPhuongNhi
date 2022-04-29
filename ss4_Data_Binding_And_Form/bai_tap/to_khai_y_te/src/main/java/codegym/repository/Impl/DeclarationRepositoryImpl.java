package codegym.repository.Impl;

import codegym.entity.Declaration;
import codegym.repository.DeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeclarationRepositoryImpl implements DeclarationRepository {
    private static Map<String,Declaration> declarationMap = new HashMap<>();

    @Override
    public List<Declaration> findAll() {
        return new ArrayList<>(declarationMap.values());
    }

    @Override
    public void add(Declaration declaration) {
        if (!declarationMap.containsKey(declaration.getId())) {
            declarationMap.put(declaration.getId(), declaration);
        }
    }

    @Override
    public void update(Declaration declaration) {
        if (declarationMap.containsKey(declaration.getId())) {
            declarationMap.put(declaration.getId(), declaration);
        }
    }

    @Override
    public Declaration findById(String id) {
        return declarationMap.get(id);
    }
}
