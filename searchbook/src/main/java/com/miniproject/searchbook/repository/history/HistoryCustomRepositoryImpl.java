package com.miniproject.searchbook.repository.history;

import com.miniproject.searchbook.domain.HistoryDTO;
import com.miniproject.searchbook.domain.QHistoryDTO;
import com.miniproject.searchbook.entity.History;
import com.miniproject.searchbook.entity.QHistory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HistoryCustomRepositoryImpl implements HistoryCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<HistoryDTO> myHistory10(Long userId) {
        List<HistoryDTO> myHistories = jpaQueryFactory.select(new QHistoryDTO(
                QHistory.history.historyId,
                QHistory.history.user.userId,
                QHistory.history.keyword,
                QHistory.history.createdDate
        ))
                .from(QHistory.history)
                .where(QHistory.history.user.userId.eq(userId))
                .orderBy(QHistory.history.createdDate.desc())
                .limit(10)
                .fetch();

        return myHistories;
    }
}
