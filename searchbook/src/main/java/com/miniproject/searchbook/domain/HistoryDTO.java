package com.miniproject.searchbook.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.miniproject.searchbook.entity.History;
import com.miniproject.searchbook.entity.User;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@NoArgsConstructor
public class HistoryDTO {
    private Long historyId;
    private Long userId;
    private String keyword;
    /* 내 검색 내역에서 사용 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime createdDate;


    @QueryProjection
    public HistoryDTO(Long historyId,Long userId,String keyword){
        this.historyId = historyId;
        this.userId = userId;
        this.keyword = keyword;
    }

    @QueryProjection
    public HistoryDTO(Long historyId,Long userId,String keyword,LocalDateTime createdDate){
        this.historyId = historyId;
        this.userId = userId;
        this.keyword = keyword;
        this.createdDate = createdDate;
    }

    public History toEntity(){
        return History.builder()
                .keyword(keyword)
                .build();
    }
}
