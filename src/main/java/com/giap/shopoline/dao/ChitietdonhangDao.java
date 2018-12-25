package com.giap.shopoline.dao;

import com.giap.shopoline.models.TblChitietdonhangEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ChitietdonhangDao {
    private Session currentSession;
    private Transaction currentTransaction;

    public ChitietdonhangDao() {
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

    public void persist(TblChitietdonhangEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(TblChitietdonhangEntity entity) {
        getCurrentSession().update(entity);
    }

    public TblChitietdonhangEntity findById(String id) {
        TblChitietdonhangEntity TblChitietdonhangEntity = (TblChitietdonhangEntity) getCurrentSession().get(TblChitietdonhangEntity.class, id);
        return TblChitietdonhangEntity;
    }

    public void delete(TblChitietdonhangEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<TblChitietdonhangEntity> findAll() {
        List<TblChitietdonhangEntity> TblChitietdonhangEntitys = (List<TblChitietdonhangEntity>) getCurrentSession().createQuery("from TblChitietdonhangEntity").list();
        return TblChitietdonhangEntitys;
    }

    public void deleteAll() {
        List<TblChitietdonhangEntity> entityList = findAll();
        for (TblChitietdonhangEntity entity : entityList) {
            delete(entity);
        }
    }
}
