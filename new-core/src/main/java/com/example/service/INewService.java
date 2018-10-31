package com.example.service;

import com.example.dto.NewDTO;
import org.springframework.data.domain.Pageable;


public interface INewService  {
    void findAll(NewDTO model, Pageable pageable);
    NewDTO save(NewDTO newDTO);
    NewDTO update(NewDTO updateDTO);
    NewDTO findById(Long id);
}
