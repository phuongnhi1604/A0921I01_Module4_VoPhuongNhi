package codegym.formatter;

import codegym.entity.Letter;
import codegym.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class EmailFormatter implements Formatter<Letter> {
    private EmailService service;
    @Autowired
    public EmailFormatter(EmailService service) {
        this.service = service;
    }
    @Override
    public Letter parse(String text, Locale locale) throws ParseException {
        return service.findById(text);
    }

    @Override
    public String print(Letter object, Locale locale) {
        return object.toString();
    }
}
