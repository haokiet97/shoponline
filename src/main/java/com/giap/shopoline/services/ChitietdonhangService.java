package com.giap.shopoline.services;

import com.giap.shopoline.dao.ChitietdonhangDao;
import com.giap.shopoline.models.TblChitietdonhangEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChitietdonhangService {
    @Autowired
    private static ChitietdonhangDao dao;

    public ChitietdonhangService() {
        dao = new ChitietdonhangDao();
    }

    public void persist(TblChitietdonhangEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(TblChitietdonhangEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }


    public TblChitietdonhangEntity findById(String id) {
        dao.openCurrentSession();
        TblChitietdonhangEntity TblChitietdonhangEntity = dao.findById(id);
        dao.closeCurrentSession();
        return TblChitietdonhangEntity;
    }

    public void delete(String id) {
        dao.openCurrentSessionwithTransaction();
        TblChitietdonhangEntity TblChitietdonhangEntity = dao.findById(id);
        dao.delete(TblChitietdonhangEntity);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<TblChitietdonhangEntity> findAll() {
        dao.openCurrentSession();
        List<TblChitietdonhangEntity> TblChitietdonhangEntitys = dao.findAll();
        dao.closeCurrentSession();
        return TblChitietdonhangEntitys;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public ChitietdonhangDao ChitietdonhangDao() {
        return dao;
    }

}
