package com.giap.shopoline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = {"/", "/Index"})
public class HomeController {
    //@Value("${welcome.message:test}")
    private String message = "Hello, the giowis.. dday lafg hello";

    //Home page
    @RequestMapping(method = RequestMethod.GET)
    public String Index(Map<String, Object> model) {
        model.put("message", this.message);
        return "home";
    }
    //chitietsanpham
    @RequestMapping(value ={"/Detail/{id}","/ChiTiet/{id}"},method = RequestMethod.GET)
    public String Detail(Map<String, Object> model) {

        model.put("message", this.message);
        return "detail";
    }
    //san pham theo  NSX
    @RequestMapping(value ={"/Producer/{id}","/NhaSanXuat/{id}"},method = RequestMethod.GET)
    public String Producer(Map<String, Object> model) {

        model.put("message", this.message);
        return "products_in_producer";
    }

    //san pham theo danh muc
    @RequestMapping(value ={"/Category/{id}","/DanhMuc/{id}"},method = RequestMethod.GET)
    public String Category(Map<String, Object> model) {

        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping(value ={"/Search/{key}","/TimKiem/{key}"},method = RequestMethod.GET)
    public String Search(Map<String, Object> model) {

        model.put("message", this.message);
        return "search";
    }
}
