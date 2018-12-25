package com.giap.shopoline.services;

import com.giap.shopoline.dao.AnhDao;
import com.giap.shopoline.models.TblAnhEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnhService {
    @Autowired
    @Qualifier("AnhData")
    private static AnhDao dao;

    public AnhService() {
        dao = new AnhDao();
    }

    public void persist(TblAnhEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(TblAnhEntity entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public TblAnhEntity findById(String id) {
        dao.openCurrentSession();
        TblAnhEntity book = dao.findById(id);
        dao.closeCurrentSession();
        return book;
    }

    public void delete(String id) {
        dao.openCurrentSessionwithTransaction();
        TblAnhEntity book = dao.findById(id);
        dao.delete(book);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<TblAnhEntity> findAll() {
        dao.openCurrentSession();
        List<TblAnhEntity> books = dao.findAll();
        dao.closeCurrentSession();
        return books;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public AnhDao anhDao() {
        return dao;
    }


}
