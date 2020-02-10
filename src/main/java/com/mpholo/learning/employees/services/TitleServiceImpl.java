package com.mpholo.learning.employees.services;

import com.mpholo.learning.employees.DTO.TitleDTO;
import com.mpholo.learning.employees.mapper.TitleMapper;
import com.mpholo.learning.employees.models.Employee;
import com.mpholo.learning.employees.models.Title;
import com.mpholo.learning.employees.repositories.TitleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitleServiceImpl implements  TitleService {
    private final TitleMapper titleMapper;

   private final TitleRepository titleRepository;

    public TitleServiceImpl(TitleMapper titleMapper, TitleRepository titleRepository) {
        this.titleMapper = titleMapper;
        this.titleRepository = titleRepository;
    }

    @Override
    public List<TitleDTO> findTitleByEmployee(Employee employee) {
        return titleRepository.findTitleByEmployee(employee)
                .stream()
                .map(titleMapper::titleToTitleDTO)
                .collect(Collectors.toList());
    }
}
