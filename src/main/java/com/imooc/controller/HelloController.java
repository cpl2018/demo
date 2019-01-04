package com.imooc.controller;

import com.imooc.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

//    @Value("${cupSize}")
//    private String cupSize;
//    @Value("${age}")
//    private int age;
//    @Value("${cons}")
//    private  String cons;
    @Autowired
    private GirlProperties girlProperties;
//    private  GirlProperties girlProperties =new GirlProperties();

//    public GirlProperties getGirlProperties() {
//        return girlProperties;
//    }
//
//    public void setGirlProperties(GirlProperties girlProperties) {
//        this.girlProperties = girlProperties;
//    }

    //    @RequestMapping(value="/hello/{id}" ,method = RequestMethod.POST)
    @GetMapping(value = "/hello/{id}")
    public String say(@PathVariable("id") Integer id){
        return "id"+id+girlProperties.getCupSize()+girlProperties.getAge();
    }
}
