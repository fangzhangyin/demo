package com.example.demo.controller;

import com.example.demo.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.CustomerServiceImpl;

import java.util.Date;
import java.util.List;

@Controller
public class customer {

    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping("selectAll")
    @ResponseBody
    public List<Customer> selectAll(){
        List<Customer> customers = null;
        customers = customerService.selectAll();
        return customers;

    }

    @RequestMapping("index")
    public  String index(){
        return "manager_Customer";
    }


    @RequestMapping("login")
    public String  alogin(){return "login";}

    @RequestMapping("registerHtml")
    public String register(){return "reg";}

    @RequestMapping("delete")
    @ResponseBody
    public String delete(int cid){

        String result = customerService.delete(cid);
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(@RequestBody Customer customer){
            System.out.println(customer);
            String result = null;
            result = customerService.update(customer);
            return result;
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insert(@RequestBody Customer customer){
        String result = null;
        customer.setDate(new Date());
        result = customerService.insert(customer);
        return result;
    }



}
