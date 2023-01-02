package com.miniproject.searchbook.service.history;

import com.miniproject.searchbook.domain.HistoryDTO;
import com.miniproject.searchbook.domain.UserDTO;
import com.miniproject.searchbook.entity.History;
import com.miniproject.searchbook.entity.User;
import com.miniproject.searchbook.repository.history.HistoryRepository;
import com.miniproject.searchbook.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;
    private final UserRepository userRepository;

    @Override
    public void saveHistory(String keyword, Long userId) {
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setKeyword(keyword);
        History history = historyDTO.toEntity();

        User user = userRepository.findById(userId).get();
        history.changeUser(user);

        historyRepository.save(history);
    }

    @Override
    public List<HistoryDTO> myHistory10(Long userId) {
        return historyRepository.myHistory10(userId);
    }
//    @Override
//    public void saveHistory(String keyword, Long userId) {
//        HistoryDTO historyDTO = new HistoryDTO();
//        historyDTO.setKeyword(keyword);
//        historyDTO.getUserId();
//
//        History history = historyDTO.toEntity();
//
//        historyRepository.save(history);
//    }
}
