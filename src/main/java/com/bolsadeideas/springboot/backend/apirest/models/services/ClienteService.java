package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IClienteDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;

	// Se puede omitir, ya que la Interface CrudRepository viene con
	// transaccionalidad, pero para los método nuevos que creemos en nuestra propia
	// interfaz, sí debemos anotarlo con @Transaccional
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) this.clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return this.clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return this.clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		this.clienteDao.deleteById(id);
	}

}
