package com.miniproject.searchbook.repository.count;

import com.miniproject.searchbook.entity.Count;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountRepository extends JpaRepository<Count, Long>, CountCustomRepository {

//    // keyword TOP10 에 사용될 keyword
//    public Count findByKeyword(String countKeyword);
}
