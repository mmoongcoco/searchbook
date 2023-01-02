package com.miniproject.searchbook.controller.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = {"logout/*"})
public class LogoutController {

    /* 로그아웃 */
    @GetMapping("done")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("search/intro"); // 인트로 controller로 이동동
   }
}
