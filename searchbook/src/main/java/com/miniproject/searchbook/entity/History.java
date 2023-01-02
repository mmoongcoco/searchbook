package com.miniproject.searchbook.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_HISTORY")
@Getter
@NoArgsConstructor
public class History extends Period{

    @Id @GeneratedValue @NotNull
    private Long historyId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY) // 한사람에 history는 여러개일 수 있음.
    private User user;

    @NotNull
    private String keyword;

    
    public void changeUser(User user){
        this.user = user;
    }

    @Builder
    public History(String keyword){
        this.keyword = keyword;
    }
}
