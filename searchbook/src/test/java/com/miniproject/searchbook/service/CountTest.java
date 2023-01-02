package com.miniproject.searchbook.service;

import com.miniproject.searchbook.domain.CountDTO;
import com.miniproject.searchbook.service.count.CountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class CountTest {
    @Autowired
    private CountService countService;

    @Test
    public void saveCountTest(){
        countService.saveCount("화이팅");
    }

    @Test
    public void keywordTop10Test(){
        countService.keywordTop10().stream().map(CountDTO::toString).forEach(log::info);
    }

}
