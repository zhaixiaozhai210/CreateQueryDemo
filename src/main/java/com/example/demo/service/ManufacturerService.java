package com.example.demo.service;

//import java.util.List;

import com.example.demo.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    List<Manufacturer> findListByJQL();
}
