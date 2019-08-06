package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Company;
import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Station;
import com.example.demo.service.CompanyService;
import com.example.demo.service.ManufacturerService;
import com.example.demo.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    ManufacturerService manufacturerService;

    @Autowired
    StationService stationService;

    @Autowired
    CompanyService companyService;

    @GetMapping("/manufacturer-list")
    public JSONObject manufacturerList(){
        JSONObject object = new JSONObject();
        List<Manufacturer> list =  manufacturerService.findListByJQL();
        object.put("content",list);
        return object;
    }

    @GetMapping("/station-list")
    public JSONObject stationList(){
        JSONObject object = new JSONObject();
        List<Station> list =  stationService.findListByJQL();
        object.put("content",list);
        return object;
    }

    @GetMapping("/company-list")
    public JSONObject companyList(){
        JSONObject object = new JSONObject();
        List<Company> list =  companyService.findListByJQL();
        object.put("content",list);
        return object;
    }
}
