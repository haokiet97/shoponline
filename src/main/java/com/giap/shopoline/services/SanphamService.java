package com.giap.shopoline.services;

import com.giap.shopoline.dao.SanphamDao;
import com.giap.shopoline.models.TblSanphamEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SanphamService {
    @Autowired
    private static SanphamDao dao;

    public SanphamService() {
        dao = new SanphamDao();
    }

    public void persist(TblSanphamEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(TblSanphamEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }


    public TblSanphamEntity findById(String id) {
        dao.openCurrentSession();
        TblSanphamEntity TblSanphamEntity = dao.findById(id);
        dao.closeCurrentSession();
        return TblSanphamEntity;
    }

    public void delete(String id) {
        dao.openCurrentSessionwithTransaction();
        TblSanphamEntity TblSanphamEntity = dao.findById(id);
        dao.delete(TblSanphamEntity);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<TblSanphamEntity> findAll() {
        dao.openCurrentSession();
        List<TblSanphamEntity> TblSanphamEntitys = dao.findAll();
        dao.closeCurrentSession();
        return TblSanphamEntitys;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public SanphamDao SanphamDao() {
        return dao;
    }

}
