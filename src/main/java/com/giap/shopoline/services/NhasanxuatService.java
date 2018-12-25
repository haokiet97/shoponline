package com.giap.shopoline.services;

import com.giap.shopoline.dao.NhasanxuatDao;
import com.giap.shopoline.models.TblNhasanxuatEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NhasanxuatService {
    @Autowired
    private static NhasanxuatDao dao;

    public NhasanxuatService() {
        dao = new NhasanxuatDao();
    }

    public void persist(TblNhasanxuatEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(TblNhasanxuatEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }


    public TblNhasanxuatEntity findById(String id) {
        dao.openCurrentSession();
        TblNhasanxuatEntity TblNhasanxuatEntity = dao.findById(id);
        dao.closeCurrentSession();
        return TblNhasanxuatEntity;
    }

    public void delete(String id) {
        dao.openCurrentSessionwithTransaction();
        TblNhasanxuatEntity TblNhasanxuatEntity = dao.findById(id);
        dao.delete(TblNhasanxuatEntity);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<TblNhasanxuatEntity> findAll() {
        dao.openCurrentSession();
        List<TblNhasanxuatEntity> TblNhasanxuatEntitys = dao.findAll();
        dao.closeCurrentSession();
        return TblNhasanxuatEntitys;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public NhasanxuatDao NhasanxuatDao() {
        return dao;
    }

}
