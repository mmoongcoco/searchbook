package com.miniproject.searchbook.controller.login;

import com.miniproject.searchbook.domain.UserDTO;
import com.miniproject.searchbook.entity.User;
import com.miniproject.searchbook.service.login.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = {"login/*"})
public class LoginController {
    private final LoginService loginService;

    /* 로그인 페이지로 */
    @GetMapping("checkuser")
    public String signup(UserDTO userDTO){
        return "login";
    }

    /* 로그인 진행 _DB에 있는 정보와 일치하는지*/
    @PostMapping("checkuser")
    public RedirectView login(UserDTO userDTO, HttpSession httpSession){
        User user = loginService.login(userDTO);

        /* 로그인 실패 */
        if (user == null){
            return new RedirectView("checkuser");
        }
        /* 로그인 완료 */

        httpSession.setAttribute("loginUserId",user.getUserId());
        return new RedirectView("/search/book");
    }


    /* user 중복확인 */
    @ResponseBody
    @PostMapping("checkidpw")
    public boolean checkIdPw(UserDTO userDTO){
        User user = loginService.login(userDTO);

        /* 로그인 실패 */
        if (user == null){
            return false;
        }
        /* 로그인 완료 */
        return true;
    }
}
