package com.giap.shopoline.services;

import com.giap.shopoline.dao.TaikhoanDao;
import com.giap.shopoline.models.TblTaikhoanEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaikhoanService {
    @Autowired
    private static TaikhoanDao dao;

    public TaikhoanService() {
        dao = new TaikhoanDao();
    }

    public void persist(TblTaikhoanEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(TblTaikhoanEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }


    public TblTaikhoanEntity findById(String id) {
        dao.openCurrentSession();
        TblTaikhoanEntity TblTaikhoanEntity = dao.findById(id);
        dao.closeCurrentSession();
        return TblTaikhoanEntity;
    }

    public void delete(String id) {
        dao.openCurrentSessionwithTransaction();
        TblTaikhoanEntity TblTaikhoanEntity = dao.findById(id);
        dao.delete(TblTaikhoanEntity);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<TblTaikhoanEntity> findAll() {
        dao.openCurrentSession();
        List<TblTaikhoanEntity> TblTaikhoanEntitys = dao.findAll();
        dao.closeCurrentSession();
        return TblTaikhoanEntitys;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public TaikhoanDao TaikhoanDao() {
        return dao;
    }

}
