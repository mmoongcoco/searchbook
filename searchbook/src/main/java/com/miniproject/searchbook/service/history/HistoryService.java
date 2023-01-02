package com.miniproject.searchbook.service.history;

import com.miniproject.searchbook.domain.HistoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HistoryService {

    public void saveHistory(String keyword, Long userId);

    public List<HistoryDTO> myHistory10(Long userId);
}
