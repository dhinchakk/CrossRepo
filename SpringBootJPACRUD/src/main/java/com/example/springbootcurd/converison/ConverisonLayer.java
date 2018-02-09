package com.example.springbootcurd.converison;

import java.util.ArrayList;
import java.util.List;

import com.example.springbootcurd.domain.Address;
import com.example.springbootcurd.domain.Customers;
import com.example.springbootcurd.webmodel.Addressweb;
import com.example.springbootcurd.webmodel.Customerweb;

public class ConverisonLayer {

	public Customers toCustomer(Customerweb customerweb) {

		Customers customerDomain = new Customers();
		List<Addressweb> addressweb = customerweb.address;
		List<Address> address = new ArrayList<>();

		customerDomain.setId(customerweb.id);
		customerDomain.setFirstName(customerweb.firstName);
		customerDomain.setLastName(customerweb.lastName);
		// customerDomain.setAddressDomain(customerweb.address);

		for (Addressweb addressWeb : addressweb) {
			Address addressDomain = new Address();
			addressDomain.setId(addressWeb.id);
			addressDomain.setState(addressWeb.state);
			addressDomain.setStreet(addressWeb.street);
			address.add(addressDomain);
		}
		customerDomain.setAddress(address);
		// customerDAOImplementation.save(customerDomain);
		// System.out.println(customerDomain+"from save");

		return customerDomain;

	}

	public List<Customerweb> toCustomerwebs(List<Customers> customer) {
		// List<Customers> list = (List<Customers>) customerDAOImplementation.findAll();
		// System.out.println(list.toString() + "from select");

		List<Customerweb> customerwebs = new ArrayList<>();
		for (Customers customers : customer) {
			Customerweb customerweb = new Customerweb();

			customerweb.id = customers.getId();
			customerweb.firstName = customers.getFirstName();
			customerweb.lastName = customers.getLastName();

			List<Address> addresses = customers.getAddress();
			List<Addressweb> addresswebs = new ArrayList<>();
			for (Address address : addresses) {
				Addressweb addressweb = new Addressweb();
				addressweb.id = address.getId();
				addressweb.state = address.getState();
				addressweb.street = address.getStreet();
				addresswebs.add(addressweb);
			}
			customerweb.address = addresswebs;
			customerwebs.add(customerweb);

		}
		return customerwebs;

	}

	public Customerweb toCustomerweb(Customers customers) {
		Customerweb customerweb = new Customerweb();
		List<Address> addresses = customers.getAddress();
		List<Addressweb> addresswebs = new ArrayList<>();
		customerweb.id = customers.getId();
		customerweb.firstName = customers.getFirstName();
		customerweb.lastName = customers.getLastName();

		for (Address address : addresses) {
			Addressweb addressweb = new Addressweb();
			addressweb.id = address.getId();
			addressweb.state = address.getState();
			addressweb.street = address.getStreet();
			addresswebs.add(addressweb);
		}
		customerweb.address = addresswebs;

		return customerweb;
	}

}
