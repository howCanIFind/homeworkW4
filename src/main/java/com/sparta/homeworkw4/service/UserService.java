package com.sparta.homeworkw4.service;

import com.sparta.homeworkw4.dto.SignupRequestDto;
import com.sparta.homeworkw4.model.User;
import com.sparta.homeworkw4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(SignupRequestDto requestDto) {
        // 회원 ID 중복 확인
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new DuplicateKeyException("중복된 사용자 ID 가 존재합니다.");
        }
        String pattern = "^[a-zA-Z0-9]*$";
        if(!Pattern.matches(pattern, username)){
            throw new IllegalArgumentException("ID 형식에 맞지 않습니다.");
        }
        if(username.length() < 3) {
            throw new IllegalArgumentException("ID 형식에 맞지 않습니다.");
        }

        if(password.length() < 4) {
            throw new IllegalStateException("Password 형식에 맞지 않습니다.");
        }
        if(password.contains(username)) {
            throw new IllegalStateException("Password 형식에 맞지 않습니다.");
        }


        // 패스워드 암호화
        String passwordEncoding = passwordEncoder.encode(password);
        User user = new User(username, passwordEncoding);
        userRepository.save(user);
    }


}
