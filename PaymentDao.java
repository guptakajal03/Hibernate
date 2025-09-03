package com.CarRental.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CarRental.entitiy.Payment;
import com.CarRental.util.HibernateUtil;

public class PaymentDao {

	 public void savePayment(Payment payment) {
	        Transaction tx = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            tx = session.beginTransaction();
	            session.persist(payment);
	            tx.commit();
	        }
	    }

	    public Payment getPayment(Long id) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.get(Payment.class, id);
	        }
	    }

	    public List<Payment> getAllPayments() {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("from Payment", Payment.class).list();
	        }
	    }

	    public void deletePayment(Long id) {
	        Transaction tx = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            tx = session.beginTransaction();
	            Payment payment = session.get(Payment.class, id);
	            if (payment != null) {
	                session.remove(payment);
	            }
	            tx.commit();
	        }
	    }
	}
