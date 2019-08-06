package com.example.demo.service;


import com.example.demo.dao.CompanyDao;
import com.example.demo.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyDao companyDao;

    @Override
    public List<Company> findListByJQL() {
        return companyDao.findAll();
    }
}
