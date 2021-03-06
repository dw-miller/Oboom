package com.example.controller;


import com.example.entity.City;
import com.example.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 */
@RestController
@Controller
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class ApiController {

    @Resource
    private CityService cityService;


    @RequestMapping("/city/{id}")
    public City getCityById(@PathVariable("id")int id){
        return cityService.getCityById(id);
    }

    @RequestMapping("/transaction/save")
    public String saveTransaction() {
        cityService.saveTransaction();
        return "saveTransaction";
    }
    @RequestMapping("/user/login_view")
    public City savesTransaction() {
        return cityService.getCityById(3);
    }
    @RequestMapping("/user/index")
    public City savessTransaction() {
        return cityService.getCityById(3);
    }


}
