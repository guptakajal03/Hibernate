package com.CarRental.entitiy;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Car")
public class Car {
@Id


@GeneratedValue(strategy = GenerationType.IDENTITY)

	 private Long carId;

	    private String brand;
	    private String model;
	    private int year;
	    private String licensePlate;
	    private double rentalRate;
	    private String status;
	  

	    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
	    private List<Booking> bookings;

		public Long getCarId() {
			return carId;
		}

		public void setCarId(Long carId) {
			this.carId = carId;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public String getLicensePlate() {
			return licensePlate;
		}

		public void setLicensePlate(String licensePlate) {
			this.licensePlate = licensePlate;
		}

		public double getRentalRate() {
			return rentalRate;
		}

		public void setRentalRate(double rentalRate) {
			this.rentalRate = rentalRate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<Booking> getBookings() {
			return bookings;
		}

		public void setBookings(List<Booking> bookings) {
			this.bookings = bookings;
		}

}
