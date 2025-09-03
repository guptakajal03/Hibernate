package com.CarRental.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.CarRental.entitiy.Booking;
import com.CarRental.entitiy.Car;
import com.CarRental.entitiy.Customer;
import com.CarRental.entitiy.Payment;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration();

            // DB Connection Properties
            config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/EmployeeDB?useSSL=false&serverTimezone=UTC");
            config.setProperty("hibernate.connection.username", "root");
            config.setProperty("hibernate.connection.password", "SQL#cul8r");
            config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

            // Hibernate Properties
            config.setProperty("hibernate.hbm2ddl.auto", "create"); // auto create table
            config.setProperty("hibernate.show_sql", "true");

            // Register Entity
            config.addAnnotatedClass(Customer.class);
            config.addAnnotatedClass(Car.class);
            config.addAnnotatedClass(Booking.class);
            config.addAnnotatedClass(Payment.class);

            sessionFactory = config.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}