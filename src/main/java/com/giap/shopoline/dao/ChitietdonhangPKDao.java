package com.giap.shopoline.dao;

import com.giap.shopoline.models.TblChitietdonhangEntityPK;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ChitietdonhangPKDao {
    private Session currentSession;
    private Transaction currentTransaction;

    public ChitietdonhangPKDao() {
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

    public void persist(TblChitietdonhangEntityPK entity) {
        getCurrentSession().save(entity);
    }

    public void update(TblChitietdonhangEntityPK entity) {
        getCurrentSession().update(entity);
    }

    public TblChitietdonhangEntityPK findById(String id) {
        TblChitietdonhangEntityPK TblChitietdonhangEntityPK = (TblChitietdonhangEntityPK) getCurrentSession().get(TblChitietdonhangEntityPK.class, id);
        return TblChitietdonhangEntityPK;
    }

    public void delete(TblChitietdonhangEntityPK entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<TblChitietdonhangEntityPK> findAll() {
        List<TblChitietdonhangEntityPK> TblChitietdonhangEntityPKs = (List<TblChitietdonhangEntityPK>) getCurrentSession().createQuery("from TblChitietdonhangEntityPK").list();
        return TblChitietdonhangEntityPKs;
    }

    public void deleteAll() {
        List<TblChitietdonhangEntityPK> entityList = findAll();
        for (TblChitietdonhangEntityPK entity : entityList) {
            delete(entity);
        }
    }
}
