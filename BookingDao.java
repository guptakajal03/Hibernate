package com.CarRental.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CarRental.entitiy.Booking;
import com.CarRental.util.HibernateUtil;

public class BookingDao {

	 public void saveBooking(Booking booking) {
	        Transaction tx = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            tx = session.beginTransaction();
	            session.persist(booking);
	            tx.commit();
	        }
	    }

	    public Booking getBooking(Long id) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.get(Booking.class, id);
	        }
	    }

	    public List<Booking> getAllBookings() {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("from Booking", Booking.class).list();
	        }
	    }

	    public void deleteBooking(Long id) {
	        Transaction tx = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            tx = session.beginTransaction();
	            Booking booking = session.get(Booking.class, id);
	            if (booking != null) {
	                session.remove(booking);
	            }
	            tx.commit();
	        }
	    }
	}


