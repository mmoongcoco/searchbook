package com.miniproject.searchbook.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_COUNT")
@Getter
@NoArgsConstructor
public class Count extends Period {
    @Id @NotNull @GeneratedValue
    private Long countId;
    @NotNull
    private String countKeyword;
    @NotNull
    private Long countNumber;

    public void plusCountNumber(Long countNumber){
        this.countNumber = countNumber;
    }

    @Builder
    public Count(String countKeyword, Long countNumber){
        this.countKeyword = countKeyword;
        this.countNumber = countNumber;
    }
}
