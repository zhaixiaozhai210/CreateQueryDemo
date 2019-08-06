package com.example.demo.dao;


import com.example.demo.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 文件名字:ManufacturerDao.java<br>
 * 文件作用:厂商的Dao层<br>
 */
@Repository
public interface ManufacturerDao extends JpaRepository<Manufacturer, String>, Serializable {

}
