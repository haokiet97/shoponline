package com.giap.shopoline.dao;

import com.giap.shopoline.models.TblKhachhangEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class KhachhangDao {
    private Session currentSession;
    private Transaction currentTransaction;

    public KhachhangDao() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(TblKhachhangEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(TblKhachhangEntity entity) {
        getCurrentSession().update(entity);
    }

    public TblKhachhangEntity findById(String id) {
        TblKhachhangEntity TblKhachhangEntity = (TblKhachhangEntity) getCurrentSession().get(TblKhachhangEntity.class, id);
        return TblKhachhangEntity;
    }

    public void delete(TblKhachhangEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<TblKhachhangEntity> findAll() {
        List<TblKhachhangEntity> TblKhachhangEntitys = (List<TblKhachhangEntity>) getCurrentSession().createQuery("from TblKhachhangEntity").list();
        return TblKhachhangEntitys;
    }

    public void deleteAll() {
        List<TblKhachhangEntity> entityList = findAll();
        for (TblKhachhangEntity entity : entityList) {
            delete(entity);
        }
    }
}
