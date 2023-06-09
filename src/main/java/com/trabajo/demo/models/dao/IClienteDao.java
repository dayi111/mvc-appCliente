package com.trabajo.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.trabajo.demo.models.entities.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long> {

}
