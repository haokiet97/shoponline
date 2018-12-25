package com.giap.shopoline.dao;

import com.giap.shopoline.models.TblTaikhoanEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TaikhoanDao {

    private Session currentSession;
    private Transaction currentTransaction;

    public TaikhoanDao() {
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

    public void persist(TblTaikhoanEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(TblTaikhoanEntity entity) {
        getCurrentSession().update(entity);
    }

    public TblTaikhoanEntity findById(String id) {
        TblTaikhoanEntity TblTaikhoanEntity = (TblTaikhoanEntity) getCurrentSession().get(TblTaikhoanEntity.class, id);
        return TblTaikhoanEntity;
    }

    public void delete(TblTaikhoanEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<TblTaikhoanEntity> findAll() {
        List<TblTaikhoanEntity> TblTaikhoanEntitys = (List<TblTaikhoanEntity>) getCurrentSession().createQuery("from TblTaikhoanEntity").list();
        return TblTaikhoanEntitys;
    }

    public void deleteAll() {
        List<TblTaikhoanEntity> entityList = findAll();
        for (TblTaikhoanEntity entity : entityList) {
            delete(entity);
        }
    }
}
