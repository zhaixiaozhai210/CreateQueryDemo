package com.example.demo.service;

//import java.util.List;

import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Station;

import java.util.List;

public interface StationService {

    List<Station> findListByJQL();
}
