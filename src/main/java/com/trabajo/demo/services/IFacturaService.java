package com.trabajo.demo.services;

import java.util.List;


import com.trabajo.demo.models.entities.Factura;

public interface IFacturaService {
	
	public List<Factura>findAll();
	
	public void save(Factura factura);
	
	public Factura findById(Long id);
	
	public void delete(Long id);
	}


