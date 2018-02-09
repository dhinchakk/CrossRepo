package com.example.springbootcurd.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.example.springbootcurd.domain.Customers;

public interface CustomerDAOImplementation extends CrudRepository<Customers, Serializable> {

}
