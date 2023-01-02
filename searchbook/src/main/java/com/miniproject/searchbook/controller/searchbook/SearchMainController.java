package com.miniproject.searchbook.controller.searchbook;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("search/*")
@Slf4j
public class SearchMainController {
    @GetMapping("book")
    public String searchMain(){
        return "searchBar";
    }

    /* 첫 페이지 */
    @GetMapping("intro")
    public String intro(){
        return "intro";
    }

}
