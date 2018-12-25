package com.giap.shopoline.services;

import com.giap.shopoline.dao.ChitietdonhangPKDao;
import com.giap.shopoline.models.TblChitietdonhangEntityPK;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChitietdonhangPKService {
    @Autowired
    private static ChitietdonhangPKDao dao;

    public ChitietdonhangPKService() {
        dao = new ChitietdonhangPKDao();
    }

    public void persist(TblChitietdonhangEntityPK entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(TblChitietdonhangEntityPK entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }


    public TblChitietdonhangEntityPK findById(String id) {
        dao.openCurrentSession();
        TblChitietdonhangEntityPK TblChitietdonhangEntityPK = dao.findById(id);
        dao.closeCurrentSession();
        return TblChitietdonhangEntityPK;
    }

    public void delete(String id) {
        dao.openCurrentSessionwithTransaction();
        TblChitietdonhangEntityPK TblChitietdonhangEntityPK = dao.findById(id);
        dao.delete(TblChitietdonhangEntityPK);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<TblChitietdonhangEntityPK> findAll() {
        dao.openCurrentSession();
        List<TblChitietdonhangEntityPK> TblChitietdonhangEntityPKs = dao.findAll();
        dao.closeCurrentSession();
        return TblChitietdonhangEntityPKs;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public ChitietdonhangPKDao ChitietdonhangPKDao() {
        return dao;
    }

}
