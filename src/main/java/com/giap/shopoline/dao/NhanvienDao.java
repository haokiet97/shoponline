package com.giap.shopoline.dao;

import com.giap.shopoline.models.TblNhanvienEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class NhanvienDao {
    private Session currentSession;
    private Transaction currentTransaction;

    public NhanvienDao() {
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

    public void persist(TblNhanvienEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(TblNhanvienEntity entity) {
        getCurrentSession().update(entity);
    }

    public TblNhanvienEntity findById(String id) {
        TblNhanvienEntity TblNhanvienEntity = (TblNhanvienEntity) getCurrentSession().get(TblNhanvienEntity.class, id);
        return TblNhanvienEntity;
    }

    public void delete(TblNhanvienEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<TblNhanvienEntity> findAll() {
        List<TblNhanvienEntity> TblNhanvienEntitys = (List<TblNhanvienEntity>) getCurrentSession().createQuery("from TblNhanvienEntity").list();
        return TblNhanvienEntitys;
    }

    public void deleteAll() {
        List<TblNhanvienEntity> entityList = findAll();
        for (TblNhanvienEntity entity : entityList) {
            delete(entity);
        }
    }
}
