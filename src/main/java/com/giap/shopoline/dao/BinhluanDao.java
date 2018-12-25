package com.giap.shopoline.dao;

import com.giap.shopoline.models.TblBinhluanEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BinhluanDao {
    private Session currentSession;
    private Transaction currentTransaction;

    public BinhluanDao() {
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

    public void persist(TblBinhluanEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(TblBinhluanEntity entity) {
        getCurrentSession().update(entity);
    }

    public TblBinhluanEntity findById(String id) {
        TblBinhluanEntity TblBinhluanEntity = (TblBinhluanEntity) getCurrentSession().get(TblBinhluanEntity.class, id);
        return TblBinhluanEntity;
    }

    public void delete(TblBinhluanEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<TblBinhluanEntity> findAll() {
        List<TblBinhluanEntity> TblBinhluanEntitys = (List<TblBinhluanEntity>) getCurrentSession().createQuery("from TblBinhluanEntity").list();
        return TblBinhluanEntitys;
    }

    public void deleteAll() {
        List<TblBinhluanEntity> entityList = findAll();
        for (TblBinhluanEntity entity : entityList) {
            delete(entity);
        }
    }
}
