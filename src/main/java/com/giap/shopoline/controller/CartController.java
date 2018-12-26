package com.giap.shopoline.controller;

import com.giap.shopoline.models.CartItem;
import com.giap.shopoline.models.TblSanphamEntity;
import com.giap.shopoline.services.SanphamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/Cart", "/GioHang"})
public class CartController {
    private String message = "Hip hip__ day la gio hang";


    @RequestMapping(method = RequestMethod.GET)
    public String Index(Map<String, Object> model) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession(true);//true will create if necessary
        List<CartItem> cart = (List<CartItem>) session.getAttribute("items");

        if (cart == null) {
            model.put("notice", "Thông Báo");
            return "notice";
        } else if (cart.size() == 0) {
            model.put("notice", "Thông Báo");
            return "notice";
        }


        model.put("notice", "Thông Báo");
        return "cart";
    }

    @RequestMapping(value = {"/deleteAll", "/XoaTatCa"}, method = RequestMethod.GET)
    public String DeleteAll() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession(true);//true will create if necessary
        session.setAttribute("items", null);
        return "redirect:/Cart";
    }

    @RequestMapping(value = {"/deleteProduct/{id}", "/XoaSanPham/{id}"}, method = RequestMethod.GET)
    public String DeleteProduct(@PathVariable("id") int id) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession(true);//true will create if necessary

        TblSanphamEntity sanpham = new SanphamService().findById(id);
        List<CartItem> cart = (List<CartItem>) session.getAttribute("items");
        if (cart != null) {
            List<CartItem> list = (List<CartItem>) cart;
            for (CartItem item : list) {
                if (item.getSanPham().equals(sanpham)) {
                    list.remove(item);
                    session.setAttribute("items", list);
                    return "redirect:/Cart";
                }
            }

        }

        return "redirect:/Cart";
    }

    @RequestMapping(value = {"/addItems/{id}/{count}", "/ThemSanPham/{id}/{count}"}, method = RequestMethod.GET)
    public String AddItems(@PathVariable("id") int id, @PathVariable("count") int count) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession(true);//true will create if necessary

        TblSanphamEntity sanpham = new SanphamService().findById(id);
        List<CartItem> cart = (List<CartItem>) session.getAttribute("items");
        if (cart != null) {
            //lay du lieu ra tu session
            List<CartItem> list = (List<CartItem>) cart;
            //neu san pham da cos trong session
            if (list.stream().filter(o -> o.getSanPham().equals(sanpham)).findFirst().isPresent()) {
                for (CartItem item : list) {
                    if (item.getSanPham().getId() == id) {
                        item.setCount(item.getCount() + count);
                        if (item.getCount() < 1) {
                            list.remove(item);
                        }

                        if (list.size() == 0) {
                            session.setAttribute("items", null);
                        }
                        return "redirect:/Cart";
                    }
                }

            } else {
                //tao moi 1 cart tu models
                CartItem item = new CartItem();
                //add du lieu tu tham so
                item.setSanPham(sanpham);
                item.setCount(1);
                list.add(item);
            }
            //gan vao session
            session.setAttribute("items", list);
        } else {

            //tao moi 1 cart tu models

            if (count > 0) {
                CartItem item = new CartItem(sanpham, 1);
                //add du lieu tu tham so

                List<CartItem> list = new ArrayList<CartItem>();
                list.add(item);

                //gan vao session
                session.setAttribute("items", list);
            }

        }


        return "redirect:/Cart";


    }

    @RequestMapping(value = {"/addItem/{id}", "/ThemSanPham/{id}"}, method = RequestMethod.GET)
    public String AddItem(@PathVariable("id") int id) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession(true);//true will create if necessary

        TblSanphamEntity sanpham = new SanphamService().findById(id);
        List<CartItem> cart = (List<CartItem>) session.getAttribute("items");
        if (cart != null) {
            //lay du lieu ra tu session
            List<CartItem> list = (List<CartItem>) cart;
            //neu san pham da cos trong session
            if (list.stream().filter(o -> o.getSanPham().equals(sanpham)).findFirst().isPresent()) {
                for (CartItem item : list) {
                    if (item.getSanPham().getId() == id) {
                        item.setCount(item.getCount() + 1);

                    }
                }

            } else {
                //tao moi 1 cart tu models
                CartItem item = new CartItem();
                //add du lieu tu tham so
                item.setSanPham(sanpham);
                item.setCount(1);
                list.add(item);
            }
            //gan vao session
            session.setAttribute("items", list);
        } else {
            //tao moi 1 cart tu models
            CartItem item = new CartItem(sanpham, 1);
            //add du lieu tu tham so

            List<CartItem> list = new ArrayList<CartItem>();
            list.add(item);

            //gan vao session
            session.setAttribute("items", list);
        }

        return "redirect:/Cart";

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
