package com.miniproject.searchbook.service.login;

import com.miniproject.searchbook.domain.UserDTO;
import com.miniproject.searchbook.entity.User;
import com.miniproject.searchbook.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{
    private final UserRepository userRepository;

    /* 로그인 */
    @Override
    public User login(UserDTO userDTO) {
        if (Optional.ofNullable(userRepository.findByUserEmail(userDTO.getUserEmail())).isPresent()){
            User user = userRepository.findByUserEmail(userDTO.getUserEmail());
            if(userDTO.getUserPassword().equals(
                    new String(Base64.decode(user.getUserPassword())))){
                return user;
            }
        }
        return null;
    }
}
