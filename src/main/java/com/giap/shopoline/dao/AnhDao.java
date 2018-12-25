package com.giap.shopoline.dao;

import java.util.List;

import com.giap.shopoline.models.TblAnhEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("AnhData")
public class AnhDao implements DaoInterfaces<TblAnhEntity, String> {

    private Session currentSession;

    private Transaction currentTransaction;

    public AnhDao() {

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
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
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

    public void persist(TblAnhEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(TblAnhEntity entity) {
        getCurrentSession().update(entity);
    }

    public TblAnhEntity findById(String id) {
        TblAnhEntity TblAnhEntity = (TblAnhEntity) getCurrentSession().get(TblAnhEntity.class, id);
        return TblAnhEntity;
    }

    public void delete(TblAnhEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<TblAnhEntity> findAll() {
        List<TblAnhEntity> TblAnhEntitys = (List<TblAnhEntity>) getCurrentSession().createQuery("from TblAnhEntity").list();
        return TblAnhEntitys;
    }

    public void deleteAll() {
        List<TblAnhEntity> entityList = findAll();
        for (TblAnhEntity entity : entityList) {
            delete(entity);
        }
    }

}
