package com.trabajo.demo.models.dao;

import org.springframework.data.repository.CrudRepository;


import com.trabajo.demo.models.entities.Factura;

public interface IFacturaDao extends CrudRepository<Factura,Long> {

}
