package com.giap.shopoline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = {"/Cart", "/GioHang"})
public class CartController {
    private String message = "Hip hip__ day la gio hang";

    @RequestMapping(method = RequestMethod.GET)
    public String Index(Map<String, Object> model) {


        model.put("message", this.message);
        return "cart";
    }

    @RequestMapping(value = {"/delete", "/XoaTatCa"}, method = RequestMethod.GET)
    public String DeleteAll() {

        return "redirect:Index";
    }

    @RequestMapping(value = {"/deleteProduct/{id}", "/XoaSanPham/{id}"}, method = RequestMethod.GET)
    public String DeleteProduct() {

        return "redirect:Index";
    }

    @RequestMapping(value = {"/addItems/{id}{count}", "/ThemSanPham/{id}{count}"}, method = RequestMethod.GET)
    public String AddItems() {

        return "redirect:Index";
    }

    @RequestMapping(value = {"/addItem/{id}", "/ThemSanPham/{id}"}, method = RequestMethod.GET)
    public String AddItem() {

        return "redirect:Index";
    }

    @RequestMapping(value = {"/Payment", "/ThanhToan"}, method = RequestMethod.GET)
    public String viewPayment() {

        return "payment";
    }

    @RequestMapping(value = {"/Payment", "/ThanhToan"}, method = RequestMethod.POST)
    public String Payment() {

        return "redirect:Index";
    }

}
