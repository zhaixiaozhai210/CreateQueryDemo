package com.example.demo;

import com.example.demo.dao.BaseDaoFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseDaoFactoryBean.class)
public class CreateQueryDemo {
    public static void main(String[] args) {
        SpringApplication.run(CreateQueryDemo.class, args);
    }
}
