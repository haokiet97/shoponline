package com.giap.shopoline.dao;

import com.giap.shopoline.models.TblDanhmucEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DanhmucDao {
    private Session currentSession;
    private Transaction currentTransaction;

    public DanhmucDao() {
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

    public void persist(TblDanhmucEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(TblDanhmucEntity entity) {
        getCurrentSession().update(entity);
    }

    public TblDanhmucEntity findById(String id) {
        TblDanhmucEntity TblDanhmucEntity = (TblDanhmucEntity) getCurrentSession().get(TblDanhmucEntity.class, id);
        return TblDanhmucEntity;
    }

    public void delete(TblDanhmucEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<TblDanhmucEntity> findAll() {
        List<TblDanhmucEntity> TblDanhmucEntitys = (List<TblDanhmucEntity>) getCurrentSession().createQuery("from TblDanhmucEntity").list();
        return TblDanhmucEntitys;
    }

    public void deleteAll() {
        List<TblDanhmucEntity> entityList = findAll();
        for (TblDanhmucEntity entity : entityList) {
            delete(entity);
        }
    }
}
