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
    static {
        declarationMap.put("1", new Declaration("1","VO PHUONG NHI","2001","Nữ","Việt Nam","1234363963","B2","Ô tô","VN123","Không"));
    }
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
