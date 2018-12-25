package com.giap.shopoline.services;

import com.giap.shopoline.dao.BinhluanDao;
import com.giap.shopoline.models.TblBinhluanEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BinhluanService {
    @Autowired
    private static BinhluanDao dao;

    public BinhluanService() {
        dao = new BinhluanDao();
    }

    public void persist(TblBinhluanEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(TblBinhluanEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }


    public TblBinhluanEntity findById(String id) {
        dao.openCurrentSession();
        TblBinhluanEntity TblBinhluanEntity = dao.findById(id);
        dao.closeCurrentSession();
        return TblBinhluanEntity;
    }

    public void delete(String id) {
        dao.openCurrentSessionwithTransaction();
        TblBinhluanEntity TblBinhluanEntity = dao.findById(id);
        dao.delete(TblBinhluanEntity);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<TblBinhluanEntity> findAll() {
        dao.openCurrentSession();
        List<TblBinhluanEntity> TblBinhluanEntitys = dao.findAll();
        dao.closeCurrentSession();
        return TblBinhluanEntitys;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public BinhluanDao BinhluanDao() {
        return dao;
    }

}
