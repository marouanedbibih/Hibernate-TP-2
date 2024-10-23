package org.marouane.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.marouane.IDao.IDao;
import org.marouane.models.Salle;
import org.marouane.util.HibernateUtil;

public class SalleServiceImpl implements IDao<Salle> {

    @SuppressWarnings("deprecation")
    @Override
    public boolean create(Salle e) {
        Session session = null;
        Transaction transaction = null;
        boolean isCreated = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(e);
            transaction.commit();
            isCreated = true;
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isCreated;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean update(Salle e) {
        Session session = null;
        Transaction transaction = null;
        boolean isUpdated = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(e);
            transaction.commit();
            isUpdated = true;
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isUpdated;
    }

    @SuppressWarnings("deprecation")
    @Override 
    public boolean delete(Salle e) {
        Session session = null;
        Transaction transaction = null;
        boolean isDeleted = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(e);
            transaction.commit();
            isDeleted = true;
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isDeleted;
    }

    @Override
    public Salle findById(Long id) {
        Session session = null;
        Transaction transaction = null;
        Salle salle = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            salle = session.get(Salle.class, id);
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return salle;
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    @Override
    public List<Salle> findAll() {
        Session session = null;
        Transaction transaction = null;
        List<Salle> salles = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            salles = session.createQuery("from Salle").list();
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return salles;
    }

}
