package co.study.jjapflix.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@Mapper
public interface JjapflixDao {
    String getUser() throws Exception;
}