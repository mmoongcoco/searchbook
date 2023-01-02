package com.miniproject.searchbook.controller.searchbook;

import com.miniproject.searchbook.domain.CountDTO;
import com.miniproject.searchbook.domain.HistoryDTO;
import com.miniproject.searchbook.domain.UserDTO;
import com.miniproject.searchbook.entity.History;
import com.miniproject.searchbook.service.count.CountService;
import com.miniproject.searchbook.service.history.HistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sea/*")
@Slf4j
public class SearchBookRestController {

    private final CountService countService;
    private final HistoryService historyService;

    @PostMapping("top10")
    public List<CountDTO> top10(){
        List<CountDTO> counts = countService.keywordTop10();
        return counts;
    }
    @PostMapping("myhistory10")
    public List<HistoryDTO> myhistory10(HttpSession session){
        Long userId = (Long) session.getAttribute("loginUserId");
        List<HistoryDTO> myHistories = historyService.myHistory10(userId);
        return myHistories;
    }

    /* 검색했을때 저장 */
    @PostMapping("savekeyword")@Transactional
    public String showFile(@RequestBody String keyword){
//        log.info("keyword: "+keyword);
        countService.saveCount(keyword);
        return "saveok";
    }

    /* 로그인된 상태에서 검색어 저장 */
    @PostMapping("saveMyHistory")@Transactional
    public String myHistory10(HttpSession session,@RequestBody String keyword){
        Long userId = (Long) session.getAttribute("loginUserId");
        log.info("userId : " +userId);
        log.info("keyword : " +keyword);
        historyService.saveHistory(keyword,userId);
        return "saveok";
    }
}
