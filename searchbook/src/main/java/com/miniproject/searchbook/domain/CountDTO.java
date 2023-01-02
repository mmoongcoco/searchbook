package com.miniproject.searchbook.domain;

import com.miniproject.searchbook.entity.Count;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CountDTO {
    private Long countId;
    private String countKeyword;
    private Long countNumber;

    @QueryProjection
    public CountDTO(Long countId, String countKeyword, Long countNumber){
        this.countId = countId;
        this.countKeyword = countKeyword;
        this.countNumber = countNumber;
    }

    public Count toEntity(){
        return Count.builder()
                .countKeyword(countKeyword)
                .countNumber(countNumber)
                .build();
    }
}
