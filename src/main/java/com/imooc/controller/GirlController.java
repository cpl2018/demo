package com.imooc.controller;

import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    /**
     * 查询女生列表
     * @return
     */

    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加女生
     *
     *
     * @return
     */
    @PostMapping(value = "/girls")

    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        return girlRepository.save(girl);

    }

    /**
     * 通过一个id查询女生
     */
    @GetMapping(value = "/girls/{id}")
    public Girl findById(@PathVariable("id") int id){
        return girlRepository.findOne(id);
    }
    /**
     * 更新一个女生
     */
    @PutMapping(value="/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") int id,
                            @RequestParam("cupSize") String cupSize,
                            @RequestParam("age") int age){
            Girl girl =new Girl();
            girl.setId(id);
            girl.setCupSize(cupSize);
            girl.setAge(age);
            return girlRepository.save(girl);
    }

    /**
     * 删除一个女生
     * @param id
     */
    @DeleteMapping(value="/girls/{id}")
    public void girlDel(@PathVariable("id") int id){
         girlRepository.delete(id);
    }

    /**
     * 根据年龄查询
     * @param age
     * @return
     */
    @GetMapping("/girls/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") int age){
        return girlRepository.findByAge(age);
    }

    /**
     * 直接保存两个女生
     */
    @PostMapping("/girls/two")
    public void girlTwo(){
        girlService.girlsaveTwo();
    }
}
