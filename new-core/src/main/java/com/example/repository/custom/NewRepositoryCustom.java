package com.example.repository.custom;

import com.example.entity.NewEntity;
import com.example.repository.paging.Pageable;

import java.util.List;

public interface NewRepositoryCustom {
    List<NewEntity> findAll(Pageable pageable);
    Long getTotalItems();
}
