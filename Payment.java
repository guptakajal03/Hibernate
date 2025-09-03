package com.CarRental.entitiy;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Payment")
public class Payment {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long paymentId;

	    @OneToOne
	    @JoinColumn(name = "booking_id")
	    private Booking booking;

	    private double amount;

	    @Temporal(TemporalType.DATE)
	    private Date paymentDate;

	    private String method;
	    private String status;
		public Long getPaymentId() {
			return paymentId;
		}
		public void setPaymentId(Long paymentId) {
			this.paymentId = paymentId;
		}
		public Booking getBooking() {
			return booking;
		}
		public void setBooking(Booking booking) {
			this.booking = booking;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public Date getPaymentDate() {
			return paymentDate;
		}
		public void setPaymentDate(Date paymentDate) {
			this.paymentDate = paymentDate;
		}
		public String getMethod() {
			return method;
		}
		public void setMethod(String method) {
			this.method = method;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

}
