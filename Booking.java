package com.CarRental.entitiy;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Booking")

public class Booking {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long bookingId;

	    @ManyToOne
	    @JoinColumn(name = "customer_id")
	    private Customer customer;

	    @ManyToOne
	    @JoinColumn(name = "car_id")
	    private Car car;

	    public Long getBookingId() {
			return bookingId;
		}

		public void setBookingId(Long bookingId) {
			this.bookingId = bookingId;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Car getCar() {
			return car;
		}

		public void setCar(Car car) {
			this.car = car;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Payment getPayment() {
			return payment;
		}

		public void setPayment(Payment payment) {
			this.payment = payment;
		}

		@Temporal(TemporalType.DATE)
	    private Date startDate;

	    @Temporal(TemporalType.DATE)
	    private Date endDate;

	    private String status;

	    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
	    private Payment payment;

}
