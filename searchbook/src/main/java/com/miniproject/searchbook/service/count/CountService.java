package com.miniproject.searchbook.service.count;

import com.miniproject.searchbook.domain.CountDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountService {

    /* 키워드 검색 top 10 카운트 용 */
    public void saveCount(String countKeyword);

    /* 카운트 top10 List */
    public List<CountDTO> keywordTop10();
}
