package org.marouane.services;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.marouane.IDao.IDao;
import org.marouane.models.Machine;
import org.marouane.util.HibernateUtil;

import jakarta.persistence.Query;

public class MachineServiceImpl implements IDao<Machine> {

    @SuppressWarnings("deprecation")
    @Override
    public boolean create(Machine e) {
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
    public boolean update(Machine e) {
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
    public boolean delete(Machine e) {
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
    public Machine findById(Long id) {
        Session session = null;
        Transaction transaction = null;
        Machine machine = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            machine = session.get(Machine.class, id);
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
        return machine;
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    @Override
    public List<Machine> findAll() {
        Session session = null;
        Transaction transaction = null;
        List<Machine> machines = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            machines = session.createQuery("from Machine").list();
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
        return machines;
    }

    // Method to fetch machines between two dates using JPQL
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<Machine> findBetweenDate(Date date1, Date date2) {
        Session session = null;
        Transaction transaction = null;
        List<Machine> machines = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.getNamedQuery("findBetweenDate");
            query.setParameter("date1", date1);
            query.setParameter("date2", date2);
            machines = query.getResultList();
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
        return machines;
    }
    
}
