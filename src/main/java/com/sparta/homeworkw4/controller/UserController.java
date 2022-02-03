package com.sparta.homeworkw4.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.homeworkw4.dto.SignupRequestDto;
import com.sparta.homeworkw4.service.KakaoUserService;
import com.sparta.homeworkw4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;


@Controller
public class UserController {

    private final UserService userService;
    private final KakaoUserService kakaoUserService;

    @Autowired
    public UserController(UserService userService, KakaoUserService kakaoUserService) {
        this.userService = userService;
        this.kakaoUserService = kakaoUserService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(@Valid SignupRequestDto requestDto) {

//        if (errors.hasErrors()) {
//            /* 회원가입 실패시 입력 데이터 값을 유지 */
////            model.addAttribute("re", userDto);
//
////            Map<String, String> validatorResult = userService.validateHandling(errors);
////            for (String key : validatorResult.keySet()) {
////                model.addAttribute(key, validatorResult.get(key));
////            } /* 회원가입 페이지로 다시 리턴 */
////            return "/user/signup";
////        }
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        kakaoUserService.kakaoLogin(code);
        return "redirect:/";
    }
}
