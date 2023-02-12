package co.study.jjapflix.service;

import co.study.jjapflix.model.User;
import org.springframework.stereotype.Service;

@Service
public interface JjapflixService {

    void saveUser(User user) throws Exception;
}
