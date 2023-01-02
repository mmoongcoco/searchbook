package com.miniproject.searchbook.service.history;

import com.miniproject.searchbook.domain.HistoryDTO;
import com.miniproject.searchbook.entity.History;
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
public class HistoryTest {
    @Autowired
    private HistoryService historyService;

    @Test
    public void saveHistoryTest(){

        historyService.saveHistory("오래오",1L);
    }

    @Test
    public void myHistory10Test(){
        historyService.myHistory10(1L).stream().map(HistoryDTO::toString).forEach(log::info);
    }
}
