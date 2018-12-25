package com.giap.shopoline.dao;

import com.giap.shopoline.models.TblQuyenEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QuyenDao {
    private Session currentSession;
    private Transaction currentTransaction;

    public QuyenDao() {
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

    public void persist(TblQuyenEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(TblQuyenEntity entity) {
        getCurrentSession().update(entity);
    }

    public TblQuyenEntity findById(String id) {
        TblQuyenEntity TblQuyenEntity = (TblQuyenEntity) getCurrentSession().get(TblQuyenEntity.class, id);
        return TblQuyenEntity;
    }

    public void delete(TblQuyenEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<TblQuyenEntity> findAll() {
        List<TblQuyenEntity> TblQuyenEntitys = (List<TblQuyenEntity>) getCurrentSession().createQuery("from TblQuyenEntity").list();
        return TblQuyenEntitys;
    }

    public void deleteAll() {
        List<TblQuyenEntity> entityList = findAll();
        for (TblQuyenEntity entity : entityList) {
            delete(entity);
        }
    }
}
