package codegym.service.Impl;

import codegym.entity.Declaration;
import codegym.repository.DeclarationRepository;
import codegym.service.DeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationServiceImpl implements DeclarationService {
    private DeclarationRepository declarationRepository;
    @Autowired
    public DeclarationServiceImpl(DeclarationRepository declarationRepository){
        this.declarationRepository = declarationRepository;
    }

    @Override
    public List<Declaration> findAll() {
        return declarationRepository.findAll();
    }

    @Override
    public void add(Declaration declaration) {
        declarationRepository.add(declaration);
    }

    @Override
    public void update(Declaration declaration) {
        declarationRepository.update(declaration);
    }

    @Override
    public Declaration findById(String id) {
        return declarationRepository.findById(id);
    }
}
