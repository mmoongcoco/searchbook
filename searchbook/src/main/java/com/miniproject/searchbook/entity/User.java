package com.miniproject.searchbook.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_USER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends Period{
    @Id @GeneratedValue @NotNull
    private Long userId;
    @NotNull
    private String userEmail;
    @NotNull
    private String userName;
    @NotNull
    private String userPassword;

    @Builder
    public User(String userEmail,String userName, String userPassword){
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
    }
}
