package com.giap.shopoline.dao;

import com.giap.shopoline.models.TblSanphamEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SanPhamDao {

    private Session currentSession;
    private Transaction currentTransaction;

    public SanPhamDao() {
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

    public void persist(TblSanphamEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(TblSanphamEntity entity) {
        getCurrentSession().update(entity);
    }

    public TblSanphamEntity findById(String id) {
        TblSanphamEntity TblSanphamEntity = (TblSanphamEntity) getCurrentSession().get(TblSanphamEntity.class, id);
        return TblSanphamEntity;
    }

    public void delete(TblSanphamEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<TblSanphamEntity> findAll() {
        List<TblSanphamEntity> TblSanphamEntitys = (List<TblSanphamEntity>) getCurrentSession().createQuery("from TblSanphamEntity").list();
        return TblSanphamEntitys;
    }

    public void deleteAll() {
        List<TblSanphamEntity> entityList = findAll();
        for (TblSanphamEntity entity : entityList) {
            delete(entity);
        }
    }
}
