package com.jcore.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.jcore.model.entity.GaRole;
import com.jcore.repository.GaRoleRepository;
import com.jcore.service_interface.GaRoleCrudService;
import com.jcore.utils.Ga_Gbl_Var;

//Clase de mantenimiento para entity usa las clase de tipo EntityManager
@Named
public class GaRoleService implements GaRoleCrudService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private GaRoleRepository gaRoleRepository;
	
	@Transactional
	@Override
	public void insert(GaRole t) throws Exception {
		// TODO Auto-generated method stub
		t.setFecActu(Ga_Gbl_Var.getFecActual());
		this.gaRoleRepository.insert(t);
		
	}
	
	@Transactional
	@Override
	public void update(GaRole t) throws Exception {
		// TODO Auto-generated method stub
		this.gaRoleRepository.update(t);
	}

	@Transactional
	@Override
	public void delete(GaRole t) throws Exception {
		// TODO Auto-generated method stub
		this.gaRoleRepository.delete(t);
	}

	@Override
	public GaRole findById(GaRole t) throws Exception {
		// TODO Auto-generated method stub
		return this.gaRoleRepository.findById(t);
	}

	@Override
	public List<GaRole> findAll() throws Exception {
		// TODO Auto-generated method stub
		return this.gaRoleRepository.findAll();
	}

	
	
}
