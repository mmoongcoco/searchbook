package com.miniproject.searchbook.service.signup;

import com.miniproject.searchbook.domain.UserDTO;
import com.miniproject.searchbook.entity.User;
import com.miniproject.searchbook.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    private final UserRepository userRepository;

    /* 회원가입 */
    @Override
    public void UserSignUp(UserDTO userDTO) {
        userDTO.setUserPassword(Base64.encode(userDTO.getUserPassword().getBytes())); // 암호화

        User user = userDTO.toEntity();

        userRepository.save(user);
    }

    /* 이메일 중복검사 */
    @Override
    public boolean checkEmail(String userEmail) {
        boolean checkEmail = userRepository.existsByUserEmail(userEmail);
        return checkEmail;
    }
}
