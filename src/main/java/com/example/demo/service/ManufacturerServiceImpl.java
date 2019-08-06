package com.example.demo.service;

import com.example.demo.dao.ManufacturerDao;
import com.example.demo.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    ManufacturerDao manufacturerDao;

    @Override
    public List<Manufacturer> findListByJQL() {
        return manufacturerDao.findAll();
    }
}
