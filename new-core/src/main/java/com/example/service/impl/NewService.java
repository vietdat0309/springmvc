package com.example.service.impl;

import com.example.converter.NewConverter;
import com.example.dto.NewDTO;
import com.example.entity.CategoryEntity;
import com.example.entity.NewEntity;
import com.example.repository.CategoryRepository;
import com.example.repository.NewRepository;
import com.example.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewService implements INewService {

    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    /*Custom JPA*/
   /* @Override
    public void findAll(NewDTO model, Pageable pageable) {

        List<NewEntity> news = newRepository.findAll(pageable);
        model.setListResult(news.stream().map(item -> newConverter.convertToDto(item)).collect(Collectors.toList()));
        model.setTotalItems(newRepository.getTotalItems().intValue());
    }*/

    /*Spring data JPA*/
    public void findAll(NewDTO model, Pageable pageable) {
        List<NewEntity> news = newRepository.findAll(pageable).getContent();
        model.setListResult(news.stream().map(item -> newConverter.convertToDto(item)).collect(Collectors.toList()));
        model.setTotalItems(newRepository.getTotalItems().intValue());
    }

    @Override
    @Transactional
    public NewDTO save(NewDTO newDTO) {
        CategoryEntity category = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        NewEntity newEntity = newConverter.convertToEntity(newDTO);
        newEntity.setCategory(category);
        newEntity = newRepository.save(newEntity);
        return newConverter.convertToDto(newEntity);
    }

    @Override
    @Transactional
    public NewDTO update(NewDTO updateDTO) {
        NewEntity existEntity = newRepository.findOne(updateDTO.getId());
        NewEntity updateNewEntity = newConverter.convertToEntity(updateDTO);
        updateNewEntity.setCategory(categoryRepository.findOneByCode(updateDTO.getCategoryCode()));
        updateNewEntity.setCreatedDate(existEntity.getCreatedDate());
        updateNewEntity.setCreatedBy(existEntity.getCreatedBy());
        updateNewEntity = newRepository.save(updateNewEntity);
        return newConverter.convertToDto(updateNewEntity);
    }

    @Override
    public NewDTO findById(Long id) {
        NewEntity newEntity = newRepository.findOne(id);
        return newConverter.convertToDto(newEntity);
    }
}
