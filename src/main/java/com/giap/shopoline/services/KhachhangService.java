package com.giap.shopoline.services;

import com.giap.shopoline.dao.KhachhangDao;
import com.giap.shopoline.models.TblKhachhangEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class KhachhangService {
    @Autowired
    private static KhachhangDao dao;

    public KhachhangService() {
        dao = new KhachhangDao();
    }

    public void persist(TblKhachhangEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(TblKhachhangEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }


    public TblKhachhangEntity findById(String id) {
        dao.openCurrentSession();
        TblKhachhangEntity TblKhachhangEntity = dao.findById(id);
        dao.closeCurrentSession();
        return TblKhachhangEntity;
    }

    public void delete(String id) {
        dao.openCurrentSessionwithTransaction();
        TblKhachhangEntity TblKhachhangEntity = dao.findById(id);
        dao.delete(TblKhachhangEntity);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<TblKhachhangEntity> findAll() {
        dao.openCurrentSession();
        List<TblKhachhangEntity> TblKhachhangEntitys = dao.findAll();
        dao.closeCurrentSession();
        return TblKhachhangEntitys;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public KhachhangDao KhachhangDao() {
        return dao;
    }

}
