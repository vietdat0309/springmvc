package com.example.repository.custom.impl;

import com.example.entity.NewEntity;
import com.example.repository.custom.NewRepositoryCustom;
import com.example.repository.paging.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Repository
public class NewRepositoryImpl implements NewRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<NewEntity> findAll(Pageable pageable) {
        /*SQL native*/
        /*StringBuilder sql = new StringBuilder("SELECT * FROM new AS n");
        Query query = entityManager.createNativeQuery(sql.toString(), NewEntity.class);
        if(pageable.getOffset() != null){
            query.setFirstResult(pageable.getOffset());
        }
        if(pageable.getPageSize() != null) {
            query.setMaxResults(pageable.getPageSize());
        }*/

        StringBuilder sql = new StringBuilder("FROM NewEntity");
        Query query = entityManager.createQuery(sql.toString());
        if(pageable.getOffset() != null){
            query.setFirstResult(pageable.getOffset());
        }
        if(pageable.getPageSize() != null) {
            query.setMaxResults(pageable.getPageSize());
        }

        return query.getResultList();
    }

    @Override
    public Long getTotalItems() {
        /*SQL native*/
        /*StringBuilder sql = new StringBuilder("SELECT COUNT (*) FROM new AS n");
        Query query = entityManager.createNativeQuery(sql.toString());
        List<BigInteger> bigIntegers = query.getResultList();
        return Long.parseLong(bigIntegers.get(0).toString(), 10);*/

        StringBuilder sql = new StringBuilder("SELECT COUNT (*) FROM NewEntity");
        Query query = entityManager.createQuery(sql.toString());
        return (Long) query.getResultList().get(0);
    }
}
