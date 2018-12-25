package com.giap.shopoline.services;

import com.giap.shopoline.dao.DondathangDao;
import com.giap.shopoline.models.TblDondathangEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DondathangService {
    @Autowired
    private static DondathangDao dao;

    public DondathangService() {
        dao = new DondathangDao();
    }

    public void persist(TblDondathangEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(TblDondathangEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }


    public TblDondathangEntity findById(String id) {
        dao.openCurrentSession();
        TblDondathangEntity TblDondathangEntity = dao.findById(id);
        dao.closeCurrentSession();
        return TblDondathangEntity;
    }

    public void delete(String id) {
        dao.openCurrentSessionwithTransaction();
        TblDondathangEntity TblDondathangEntity = dao.findById(id);
        dao.delete(TblDondathangEntity);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<TblDondathangEntity> findAll() {
        dao.openCurrentSession();
        List<TblDondathangEntity> TblDondathangEntitys = dao.findAll();
        dao.closeCurrentSession();
        return TblDondathangEntitys;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public DondathangDao DondathangDao() {
        return dao;
    }

}
