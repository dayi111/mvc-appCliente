package com.trabajo.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabajo.demo.models.dao.IFacturaDao;
import com.trabajo.demo.models.entities.Factura;



@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaDao facturaDao;
	
	@Transactional(readOnly=true)
	public List<Factura> findAll() {
		return (List<Factura>)facturaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Factura cliente) {
		facturaDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Factura findById(Long id) {
		return facturaDao.findById(id).orElse(null);
				
	}

	@Override
	@Transactional
	public void delete(Long id) {
		facturaDao.deleteById(id);
		
	}

	
	
}
