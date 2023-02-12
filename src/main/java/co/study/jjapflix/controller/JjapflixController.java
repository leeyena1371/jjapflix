package co.study.jjapflix.controller;

import co.study.common.Response;
import co.study.jjapflix.dto.SignInRequest;
import co.study.jjapflix.dto.TestReqDTO;
import co.study.jjapflix.model.User;
import co.study.jjapflix.service.JjapflixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "api/v2/Jjapflix/")
public class JjapflixController {

    @Autowired
    JjapflixService jjapflixService;

    @GetMapping("test")
    public Response test(){

        TestReqDTO testRequest = TestReqDTO.builder()
                .message("테스트입니다.")
                .build();

        return Response.builder()
                .data(testRequest)
                .build();

    }

    @GetMapping("signIn")
    public Response signIn(@RequestBody @Valid SignInRequest signInRequest) throws Exception {


        jjapflixService.saveUser(User.builder()
                .name(signInRequest.getName())
                .email(signInRequest.getEmail())
                .build());

        return Response.builder()
                .traceId("222")
                .build();

    }


}
