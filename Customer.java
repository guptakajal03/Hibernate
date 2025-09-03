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
@Table(name = "customer")
public class Customer {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long customerId;

	    private String name;
	    private String email;
	    private String phone;
	    private String licenseNo;

	    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	    private List<Booking> bookings;

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getLicenseNo() {
			return licenseNo;
		}

		public void setLicenseNo(String licenseNo) {
			this.licenseNo = licenseNo;
		}

		public List<Booking> getBookings() {
			return bookings;
		}

		public void setBookings(List<Booking> bookings) {
			this.bookings = bookings;
		}
}