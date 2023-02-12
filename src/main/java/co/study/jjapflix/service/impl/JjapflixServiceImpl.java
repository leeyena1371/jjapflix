package co.study.jjapflix.service.impl;

import co.dearu.live.api.common.exception.CommonException;
import co.study.jjapflix.model.User;
import co.study.jjapflix.repository.JjapflixDao;
import co.study.jjapflix.service.JjapflixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class JjapflixServiceImpl implements JjapflixService {


    @Autowired
    private JjapflixDao jjapflixMapper;

    /**
     * user API
     */
    @Override
    public void saveUser(User user) throws Exception {

        try {
            //String name = jjapflixMapper.getUser();
            log.info("name  :: " + user.getName());
            log.info("email  :: " + user.getEmail());

        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonException.DefaultParameterException("오류가 발생했습니다.[1]");
        }
    }

}
