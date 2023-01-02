package com.miniproject.searchbook.service.count;

import com.miniproject.searchbook.domain.CountDTO;
import com.miniproject.searchbook.entity.Count;
import com.miniproject.searchbook.repository.count.CountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountServiceImpl implements CountService{
    private final CountRepository countRepository;

    @Override
    public void saveCount(String countKeyword) {

        List<Count> counts = countRepository.findAll();

        for (Count count : counts) {
            if(count.getCountKeyword().equals(countKeyword)){
                count.plusCountNumber(count.getCountNumber()+1L);
                return;
            }
        }
        CountDTO countDTO = new CountDTO();
        countDTO.setCountKeyword(countKeyword);
        countDTO.setCountNumber(1L);
        Count count = countDTO.toEntity();

        countRepository.save(count);



    }

    @Override
    public List<CountDTO> keywordTop10() {
        return countRepository.keywordTop10();
    }

}
