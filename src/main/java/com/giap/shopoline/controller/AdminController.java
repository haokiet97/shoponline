package com.giap.shopoline.controller;

import com.giap.shopoline.models.TblAnhEntity;
import com.giap.shopoline.services.AnhService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/Admin")
public class AdminController {
    @RequestMapping(method = RequestMethod.GET)
    public String Index(Map<String, Object> model) {
        List<TblAnhEntity> datas = new AnhService().findAll();
        model.put("data", datas);
        return "admin";
    }

}
