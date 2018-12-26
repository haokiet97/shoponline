package com.giap.shopoline.controller;

import com.giap.shopoline.models.TblSanphamEntity;
import com.giap.shopoline.services.DanhmucService;
import com.giap.shopoline.services.NhasanxuatService;
import com.giap.shopoline.services.SanphamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/", "/Index"})
public class HomeController {
    //@Value("${welcome.message:test}")
    private String message = "Hello, the giowis.. dday lafg hello";

    //Home page
    @RequestMapping(method = RequestMethod.GET)
    public String Index(Map<String, Object> model) {
        model.put("sanpham", new SanphamService().findAll());
        model.put("danhmuc", new DanhmucService().findAll());
        model.put("nhasanxuat", new NhasanxuatService().findAll());
        return "home";
    }

    //chitietsanpham
    @RequestMapping(value = {"/Detail/{id}", "/ChiTiet/{id}"}, method = RequestMethod.GET)
    public String Detail(Map<String, Object> model, @PathVariable("id") int id) {
        if (false) {
            return "redirect:home";
        }
        TblSanphamEntity sp = new SanphamService().findById(id);
        List<TblSanphamEntity> lst = new SanphamService().findAll();
        List<TblSanphamEntity> data = new ArrayList<TblSanphamEntity>();
        for (TblSanphamEntity item : lst) {
            if (item.getTblDanhmucByIdDanhmuc().getId() == sp.getTblDanhmucByIdDanhmuc().getId()) {
                if (data.size() < 4) {
                    data.add(item);
                }

            }
        }
        model.put("lstsanpham", data);
        model.put("sanpham", sp);
        return "detail";
    }

    //san pham theo  NSX
    @RequestMapping(value = {"/Producer/{id}", "/NhaSanXuat/{id}"}, method = RequestMethod.GET)
    public String Producer(Map<String, Object> model, @PathVariable("id") int id) {

        List<TblSanphamEntity> lst = new SanphamService().findAll();
        List<TblSanphamEntity> data = new ArrayList<TblSanphamEntity>();
        for (TblSanphamEntity item : lst) {
            if (item.getTblNhasanxuatByIdNhasanxuat().getId() == id) {
                data.add(item);
            }
        }
        model.put("lstsanpham", data);
        model.put("danhmuc", new DanhmucService().findAll());
        model.put("nhasanxuat", new NhasanxuatService().findAll());
        return "products_in_category";
    }

    //san pham theo danh muc
    @RequestMapping(value = {"/Category/{id}", "/DanhMuc/{id}"}, method = RequestMethod.GET)
    public String Category(Map<String, Object> model, @PathVariable("id") int id) {

        List<TblSanphamEntity> lst = new SanphamService().findAll();
        List<TblSanphamEntity> data = new ArrayList<TblSanphamEntity>();
        for (TblSanphamEntity item : lst) {
            if (item.getTblDanhmucByIdDanhmuc().getId() == id) {
                data.add(item);
            }
        }
        model.put("lstsanpham", data);
        model.put("danhmuc", new DanhmucService().findAll());
        model.put("nhasanxuat", new NhasanxuatService().findAll());
        return "products_in_category";
    }

    @RequestMapping(value = {"/Search/{key}", "/TimKiem/{key}"}, method = RequestMethod.GET)
    public String Search(Map<String, Object> model, @PathVariable("key") String key) {
        List<TblSanphamEntity> lst = new SanphamService().findAll();
        List<TblSanphamEntity> data = new ArrayList<TblSanphamEntity>();
        for (TblSanphamEntity item : lst) {
            if (item.getTblDanhmucByIdDanhmuc().getTen().indexOf(key) > 0) {
                data.add(item);
            }
        }
        model.put("lstsanpham", data);
        model.put("danhmuc", new DanhmucService().findAll());
        model.put("nhasanxuat", new NhasanxuatService().findAll());
        return "products_in_category";
    }
}
