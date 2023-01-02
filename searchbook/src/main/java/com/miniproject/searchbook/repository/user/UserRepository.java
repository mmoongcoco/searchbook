package com.miniproject.searchbook.repository.user;

import com.miniproject.searchbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {

    // 회원가입시 userEmail 체크
    public boolean existsByUserEmail(String userEmail);

    // 로그인시 userEmail 체크
    public User findByUserEmail(String userEmail);
}
