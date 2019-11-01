package com.SpringDeneme.SpringDemo.dao.jpa;

import com.SpringDeneme.SpringDemo.dao.NaturalRespository;
import org.hibernate.NaturalIdLoadAccess;
import org.hibernate.Session;


import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

@Transactional(readOnly = true)
public class NaturalRepositoryImpl <T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements NaturalRespository<T, ID> {


    private final EntityManager entityManager;


    public NaturalRepositoryImpl(JpaEntityInformation jpaEntityInformation,
                                 EntityManager entityManager) {
        super(jpaEntityInformation, entityManager);
        this.entityManager = entityManager;
    }
    @Override
    public Optional<T> findBySimpleNaturalId(ID naturalId) {
        Optional<T> entity = entityManager.unwrap(Session.class)
                .bySimpleNaturalId(this.getDomainClass())
                .loadOptional(naturalId);
        return entity;
    }
    @Override
    public Optional<T> findByNaturalId(Map<String, Object> naturalIds) {
        NaturalIdLoadAccess<T> loadAccess
                = entityManager.unwrap(Session.class).byNaturalId(this.getDomainClass());
        naturalIds.forEach(loadAccess::using);
        return loadAccess.loadOptional();
    }
}