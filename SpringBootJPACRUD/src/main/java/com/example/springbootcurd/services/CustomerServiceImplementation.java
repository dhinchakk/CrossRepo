package com.example.springbootcurd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootcurd.converison.ConverisonLayer;
import com.example.springbootcurd.dao.CustomerDAOImplementation;
import com.example.springbootcurd.domain.Customers;
import com.example.springbootcurd.webmodel.Customerweb;

@Service
public class CustomerServiceImplementation implements CustomerService {
	@Autowired
	private CustomerDAOImplementation customerDAOImplementation;

	@Override
	public void save(Customerweb customerweb) {
		ConverisonLayer conversionlayer = new ConverisonLayer();

		Customers customerDomain = conversionlayer.toCustomer(customerweb);

		customerDAOImplementation.save(customerDomain);
		System.out.println(customerDomain + "from save");
	}

	@Override
	public Customerweb Select(Long id) {
		Customers customers=customerDAOImplementation.findOne(id);
		ConverisonLayer converisonLayer=new ConverisonLayer();
		Customerweb customerweb=converisonLayer.toCustomerweb(customers);
		return customerweb;
	}

	@Override
	public List<Customerweb> Select() {
		List<Customers> list = (List<Customers>) customerDAOImplementation.findAll();
		//System.out.println(list.toString() + "from select");
		ConverisonLayer converisonLayer = new ConverisonLayer();
		List<Customerweb> customerwebs = converisonLayer.toCustomerwebs(list);

		System.out.println(customerwebs);
		return customerwebs;
	}

	@Override
	public void update(Customerweb customerweb) {
		ConverisonLayer converisonLayer = new ConverisonLayer();
		Customers customerDomain = converisonLayer.toCustomer(customerweb);
System.out.println("in update");
System.out.println("b4 save"+customerDomain);
customerDAOImplementation.save(customerDomain);

	//	customerDAOImplementation.save(customerDAOImplementation.findOne(customerDomain.getId()));
		System.out.println("from update after update"+customerDomain );
	}

	@Override
	public void delete(Long id) {
		customerDAOImplementation.delete(id);

	}

}
