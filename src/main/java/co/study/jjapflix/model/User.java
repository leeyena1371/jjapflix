package co.study.jjapflix.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer useridx;

    private String name;

    private String nickname;

    private String email;

    private String phonenumber;

    private String password;

    private String status;

    private String country;

}
