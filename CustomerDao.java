package com.CarRental.dao;

import org.hibernate.Session;
import java.util.*;

import com.CarRental.entitiy.Customer;
import com.CarRental.util.HibernateUtil;

public class CustomerDao {

	 public void saveCustomer(Customer customer) {
	        org.hibernate.Transaction tx = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            tx = session.beginTransaction();
	            session.persist(customer);
	            tx.commit();
	        }
	    }

	    public Customer getCustomer(Long id) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.get(Customer.class, id);
	        }
	    }

	    public List<Customer> getAllCustomers() {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("from Customer", Customer.class).list();
	        }
	    }

	    public void deleteCustomer(Long id) {
	        org.hibernate.Transaction tx = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            tx = session.beginTransaction();
	            Customer customer = session.get(Customer.class, id);
	            if (customer != null) {
	                session.remove(customer);
	            }
	            tx.commit();
	        }
	    }
	}

		
	