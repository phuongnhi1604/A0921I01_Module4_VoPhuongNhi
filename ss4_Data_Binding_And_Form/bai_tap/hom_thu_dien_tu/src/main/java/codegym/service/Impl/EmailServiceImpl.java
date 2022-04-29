package codegym.service.Impl;

import codegym.entity.Letter;
import codegym.repository.EmailRepository;
import codegym.repository.Impl.EmailRepositoryImpl;
import codegym.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    private EmailRepository emailRepository;
    @Autowired
    public EmailServiceImpl(EmailRepository emailRepository){
        this.emailRepository = emailRepository;
    }

    @Override
    public List<Letter> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public void update(Letter letter) {
        emailRepository.update(letter);
    }

    @Override
    public Letter findById(String id) {
        return emailRepository.findById(id);
    }
}
