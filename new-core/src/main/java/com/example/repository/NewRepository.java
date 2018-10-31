package com.example.repository;

import com.example.entity.NewEntity;
import com.example.repository.custom.NewRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository<NewEntity, Long>, NewRepositoryCustom {

}
