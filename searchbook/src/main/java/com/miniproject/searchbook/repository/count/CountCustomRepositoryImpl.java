package com.miniproject.searchbook.repository.count;

import com.miniproject.searchbook.domain.CountDTO;
import com.miniproject.searchbook.domain.QCountDTO;
import com.miniproject.searchbook.entity.Count;
import com.miniproject.searchbook.entity.QCount;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CountCustomRepositoryImpl implements CountCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CountDTO> keywordTop10() {
        List<CountDTO> counts = jpaQueryFactory.select(new QCountDTO(
                QCount.count.countId,
                QCount.count.countKeyword,
                QCount.count.countNumber
        ))
                .from(QCount.count)
                .orderBy(QCount.count.countNumber.desc())
                .limit(10)
                .fetch();

        return counts;
    }
}
