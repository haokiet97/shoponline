package com.giap.shopoline.services;

import com.giap.shopoline.dao.DanhmucDao;
import com.giap.shopoline.models.TblDanhmucEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DanhmucService {
    @Autowired
    private static DanhmucDao dao;

    public DanhmucService() {
        dao = new DanhmucDao();
    }

    public void persist(TblDanhmucEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(TblDanhmucEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }


    public TblDanhmucEntity findById(String id) {
        dao.openCurrentSession();
        TblDanhmucEntity TblDanhmucEntity = dao.findById(id);
        dao.closeCurrentSession();
        return TblDanhmucEntity;
    }

    public void delete(String id) {
        dao.openCurrentSessionwithTransaction();
        TblDanhmucEntity TblDanhmucEntity = dao.findById(id);
        dao.delete(TblDanhmucEntity);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<TblDanhmucEntity> findAll() {
        dao.openCurrentSession();
        List<TblDanhmucEntity> TblDanhmucEntitys = dao.findAll();
        dao.closeCurrentSession();
        return TblDanhmucEntitys;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public DanhmucDao DanhmucDao() {
        return dao;
    }

}
