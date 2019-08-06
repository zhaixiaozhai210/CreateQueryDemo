package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class BaseDaoImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID>
        implements BaseDao<T, ID>{

    public BaseDaoImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

}
