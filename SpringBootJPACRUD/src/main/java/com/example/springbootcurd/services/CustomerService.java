package com.example.springbootcurd.services;

import java.util.List;

import com.example.springbootcurd.webmodel.Customerweb;

public interface CustomerService {
	public void save(Customerweb customerweb);
	public Customerweb Select(Long id);
	public List<Customerweb> Select();
	public void update(Customerweb customerweb);
	public void delete (Long id);
	
	

}
