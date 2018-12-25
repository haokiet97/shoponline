package com.giap.shopoline.services;

import com.giap.shopoline.dao.NhanvienDao;
import com.giap.shopoline.models.TblNhanvienEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NhanvienService {
    @Autowired
    private static NhanvienDao dao;

    public NhanvienService() {
        dao = new NhanvienDao();
    }

    public void persist(TblNhanvienEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(TblNhanvienEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }


    public TblNhanvienEntity findById(String id) {
        dao.openCurrentSession();
        TblNhanvienEntity TblNhanvienEntity = dao.findById(id);
        dao.closeCurrentSession();
        return TblNhanvienEntity;
    }

    public void delete(String id) {
        dao.openCurrentSessionwithTransaction();
        TblNhanvienEntity TblNhanvienEntity = dao.findById(id);
        dao.delete(TblNhanvienEntity);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<TblNhanvienEntity> findAll() {
        dao.openCurrentSession();
        List<TblNhanvienEntity> TblNhanvienEntitys = dao.findAll();
        dao.closeCurrentSession();
        return TblNhanvienEntitys;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public NhanvienDao NhanvienDao() {
        return dao;
    }

}
