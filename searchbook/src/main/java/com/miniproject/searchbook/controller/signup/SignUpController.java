package com.miniproject.searchbook.controller.signup;

import com.miniproject.searchbook.domain.UserDTO;
import com.miniproject.searchbook.service.signup.SignUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = {"signup/*"})
public class SignUpController {
    private final SignUpService signUpService;

    /* 회원가입 페이지로 이동 */
    @GetMapping("add")
    public String signup(UserDTO userDTO){
        return "signUp";
    }

    /* 회원가입 완료시 */
    @PostMapping("ok")
    public RedirectView signUpOk(UserDTO userDTO){
        signUpService.UserSignUp(userDTO);
        return new RedirectView("/login/checkuser"); // 로그인 controller로 이동
    }

    /* 이메일 중복확인 */
    @ResponseBody
    @GetMapping("checkEmail")
    public boolean checkEmail(String userEmail){
        return signUpService.checkEmail(userEmail);
    }
}
