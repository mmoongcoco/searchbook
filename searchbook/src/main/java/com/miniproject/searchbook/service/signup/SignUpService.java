package com.miniproject.searchbook.service.signup;

import com.miniproject.searchbook.domain.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface SignUpService {
    /* 회원가입 */
    public void UserSignUp(UserDTO userDTO);

    /* 이메일 중복검사 */
    public boolean checkEmail(String userEmail);
}
