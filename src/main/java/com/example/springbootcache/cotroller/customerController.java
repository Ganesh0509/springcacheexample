package com.example.springbootcache.cotroller;

import com.example.springbootcache.doa.CustomerDao;
import com.example.springbootcache.entity.CustomerParams;
import com.example.springbootcache.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/students")
@CacheConfig(cacheNames = "customers")
public class customerController{
    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/hi")
    public String getCutomer() {
      return "test";
    }

    @GetMapping("/{id}")
    @Cacheable()
    public CustomerParams read(@PathVariable("id") long id) {
        return customerDao.getEmployeeList(id);
    }
}
