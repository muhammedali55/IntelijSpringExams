package com.SpringDeneme.SpringDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

@NoRepositoryBean
public interface NaturalRespository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    // entity de naturalid bulunan tek bir alan var ise bu methosu kullanın
    Optional<T> findBySimpleNaturalId(ID naturalId);
    // Entity tanımınız birden çok naturalid alanına sahip ise bu metodu kullanın
    Optional<T> findByNaturalId(Map<String, Object> naturalIds);
}
