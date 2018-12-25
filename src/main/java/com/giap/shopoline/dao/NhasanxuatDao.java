package com.giap.shopoline.dao;

import com.giap.shopoline.models.TblNhasanxuatEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class NhasanxuatDao {
    private Session currentSession;
    private Transaction currentTransaction;

    public NhasanxuatDao() {
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

    public void persist(TblNhasanxuatEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(TblNhasanxuatEntity entity) {
        getCurrentSession().update(entity);
    }

    public TblNhasanxuatEntity findById(String id) {
        TblNhasanxuatEntity TblNhasanxuatEntity = (TblNhasanxuatEntity) getCurrentSession().get(TblNhasanxuatEntity.class, id);
        return TblNhasanxuatEntity;
    }

    public void delete(TblNhasanxuatEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<TblNhasanxuatEntity> findAll() {
        List<TblNhasanxuatEntity> TblNhasanxuatEntitys = (List<TblNhasanxuatEntity>) getCurrentSession().createQuery("from TblNhasanxuatEntity").list();
        return TblNhasanxuatEntitys;
    }

    public void deleteAll() {
        List<TblNhasanxuatEntity> entityList = findAll();
        for (TblNhasanxuatEntity entity : entityList) {
            delete(entity);
        }
    }
}
