package com.miniproject.searchbook.domain;

import com.miniproject.searchbook.entity.User;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserDTO {
    private Long userId;
    private String userEmail;
    private String userName;
    private String userPassword;

    @QueryProjection
    public UserDTO(Long userId, String userEmail, String userName, String userPassword){
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User toEntity(){
        return User.builder()
                .userEmail(userEmail)
                .userName(userName)
                .userPassword(userPassword)
                .build();
    }
}
