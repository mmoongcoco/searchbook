package com.miniproject.searchbook.service;

import com.miniproject.searchbook.domain.UserDTO;
import com.miniproject.searchbook.service.signup.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class SignUpTest {
    @Autowired
    private SignUpService signUpService;

    /* 회원가입 테스트 */
    @Test
    public void UserSignUp(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserEmail("user@naver.com");
        userDTO.setUserName("aaa");
        userDTO.setUserPassword("44445555");

        boolean check = signUpService.checkEmail(userDTO.getUserEmail());
        if (!check){
            signUpService.UserSignUp(userDTO);
        }
    }
}
