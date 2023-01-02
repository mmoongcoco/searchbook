package com.miniproject.searchbook.repository.history;

import com.miniproject.searchbook.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long>, HistoryCustomRepository {
}
