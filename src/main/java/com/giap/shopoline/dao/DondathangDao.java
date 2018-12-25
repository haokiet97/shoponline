package com.giap.shopoline.dao;

import com.giap.shopoline.models.TblDondathangEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DondathangDao {
    private Session currentSession;
    private Transaction currentTransaction;

    public DondathangDao() {
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

    public void persist(TblDondathangEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(TblDondathangEntity entity) {
        getCurrentSession().update(entity);
    }

    public TblDondathangEntity findById(String id) {
        TblDondathangEntity TblDondathangEntity = (TblDondathangEntity) getCurrentSession().get(TblDondathangEntity.class, id);
        return TblDondathangEntity;
    }

    public void delete(TblDondathangEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<TblDondathangEntity> findAll() {
        List<TblDondathangEntity> TblDondathangEntitys = (List<TblDondathangEntity>) getCurrentSession().createQuery("from TblDondathangEntity").list();
        return TblDondathangEntitys;
    }

    public void deleteAll() {
        List<TblDondathangEntity> entityList = findAll();
        for (TblDondathangEntity entity : entityList) {
            delete(entity);
        }
    }
}
