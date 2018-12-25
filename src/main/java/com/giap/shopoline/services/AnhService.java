package com.giap.shopoline.services;

import com.giap.shopoline.dao.AnhDao;
import com.giap.shopoline.models.TblAnhEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnhService {
    private static AnhDao Anhdao;

    public AnhService() {
        Anhdao = new AnhDao();
    }

    public void persist(TblAnhEntity entity) {
        Anhdao.openCurrentSessionwithTransaction();
        Anhdao.persist(entity);
        Anhdao.closeCurrentSessionwithTransaction();
    }

    public void update(TblAnhEntity entity) {
        Anhdao.openCurrentSessionwithTransaction();
        Anhdao.update(entity);
        Anhdao.closeCurrentSessionwithTransaction();
    }


    public TblAnhEntity findById(String id) {
        Anhdao.openCurrentSession();
        TblAnhEntity TblAnhEntity = Anhdao.findById(id);
        Anhdao.closeCurrentSession();
        return TblAnhEntity;
    }

    public void delete(String id) {
        Anhdao.openCurrentSessionwithTransaction();
        TblAnhEntity TblAnhEntity = Anhdao.findById(id);
        Anhdao.delete(TblAnhEntity);
        Anhdao.closeCurrentSessionwithTransaction();
    }

    public List<TblAnhEntity> findAll() {
        Anhdao.openCurrentSession();
        List<TblAnhEntity> TblAnhEntitys = Anhdao.findAll();
        Anhdao.closeCurrentSession();
        return TblAnhEntitys;
    }

    public void deleteAll() {
        Anhdao.openCurrentSessionwithTransaction();
        Anhdao.deleteAll();
        Anhdao.closeCurrentSessionwithTransaction();
    }

    public AnhDao Anhdao() {
        return Anhdao;
    }


}
