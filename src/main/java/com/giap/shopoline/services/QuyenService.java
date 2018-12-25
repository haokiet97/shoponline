package com.giap.shopoline.services;

import com.giap.shopoline.dao.QuyenDao;
import com.giap.shopoline.models.TblQuyenEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuyenService {
    @Autowired
    private static QuyenDao dao;

    public QuyenService() {
        dao = new QuyenDao();
    }

    public void persist(TblQuyenEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(TblQuyenEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }


    public TblQuyenEntity findById(String id) {
        dao.openCurrentSession();
        TblQuyenEntity TblQuyenEntity = dao.findById(id);
        dao.closeCurrentSession();
        return TblQuyenEntity;
    }

    public void delete(String id) {
        dao.openCurrentSessionwithTransaction();
        TblQuyenEntity TblQuyenEntity = dao.findById(id);
        dao.delete(TblQuyenEntity);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<TblQuyenEntity> findAll() {
        dao.openCurrentSession();
        List<TblQuyenEntity> TblQuyenEntitys = dao.findAll();
        dao.closeCurrentSession();
        return TblQuyenEntitys;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public QuyenDao QuyenDao() {
        return dao;
    }

}
