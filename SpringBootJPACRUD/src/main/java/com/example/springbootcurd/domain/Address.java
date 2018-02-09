package com.example.springbootcurd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="add")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String street;
	private String state;
	////@ManyToOne(fetch=FetchType.EAGER)
	//@JoinColumn(name = "customer_id")
	//private Customers customers;
	// @ManyToOne(fetch = FetchType.LAZY)
	// private Customers customers;

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "AddressDomain [id=" + id + ", street=" + street + ", state=" + state + "]";
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

}
