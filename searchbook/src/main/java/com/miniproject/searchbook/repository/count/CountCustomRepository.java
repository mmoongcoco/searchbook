package com.miniproject.searchbook.repository.count;

import com.miniproject.searchbook.domain.CountDTO;

import java.util.List;

public interface CountCustomRepository {

    /* 검색 횟수로 정렬 Top10 */

    public List<CountDTO> keywordTop10();
}
