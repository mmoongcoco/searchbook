package com.miniproject.searchbook.service.login;

import com.miniproject.searchbook.domain.UserDTO;
import com.miniproject.searchbook.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    /* 로그인 */
    public User login(UserDTO userDTO);
}
