package codegym.repository.Impl;

import codegym.entity.Letter;
import codegym.repository.EmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmailRepositoryImpl implements EmailRepository {
    private static Map<String,Letter> letterList = new HashMap<>();
    static {
        letterList.put("1",new Letter("1","English","25",false,"Thor: King,Asgard"));
    }
    @Override
    public List<Letter> findAll() {
        return new ArrayList<>(letterList.values());
    }

    @Override
    public void update(Letter letter) {
        if (letterList.containsKey(letter.getId())) {
            letterList.put(letter.getId(), letter);
        }
    }

    @Override
    public Letter findById(String id) {
        return letterList.get(id);
    }
}
