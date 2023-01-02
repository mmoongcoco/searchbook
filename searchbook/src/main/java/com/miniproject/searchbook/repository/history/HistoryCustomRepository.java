package com.miniproject.searchbook.repository.history;

import com.miniproject.searchbook.domain.HistoryDTO;

import java.util.List;

public interface HistoryCustomRepository  {

    /* 내 검색 내역 */
    public List<HistoryDTO> myHistory10(Long userId);
}
