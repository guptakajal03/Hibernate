package com.CarRental.dao;

import java.util.List;

import org.hibernate.Session;

import com.CarRental.entitiy.Car;
import com.CarRental.util.HibernateUtil;

public class CarDao {

	 public void saveCar(Car car) {
	        org.hibernate.Transaction tx = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            tx = session.beginTransaction();
	            session.persist(car);
	            tx.commit();
	        }
	    }

	    public Car getCar(Long id) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.get(Car.class, id);
	        }
	    }

	    public List<Car> getAllCars() {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("from Car", Car.class).list();
	        }
	    }

	    public void deleteCar(Long id) {
	        org.hibernate.Transaction tx = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            tx = session.beginTransaction();
	            Car car = session.get(Car.class, id);
	            if (car != null) {
	                session.remove(car);
	            }
	            tx.commit();
	        }
	    }
	}
