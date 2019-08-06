package com.example.demo.service;

//import java.util.List;

import com.example.demo.dao.StationDao;
import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService{

    @Autowired
    StationDao stationDao;

    @Override
    public List<Station> findListByJQL() {
        return stationDao.findAll();
    }
}
