package com.jcore.service;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

import com.jcore.model.entity.GaUser;
import com.jcore.model.entity.GaUsrProperty;
import com.jcore.repository.GaUsrPropertyRepository;
import com.jcore.service_interface.GaUsrPropertyCrudService;
import com.jcore.utils.Ga_Gbl_Var;

//Clase de mantenimiento para entity usa las clase de tipo EntityManager
@Named
public class GaUsrPropertyService implements GaUsrPropertyCrudService, Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private GaUsrPropertyRepository gaUsrPropertyRepository;
	
	@Transactional
	@Override
	public void insert(GaUsrProperty t) throws Exception {
		// TODO Auto-generated method stub
		this.gaUsrPropertyRepository.insert(t);
	}

	@Transactional
	@Override
	public void update(GaUsrProperty t) throws Exception {
		// TODO Auto-generated method stub
		this.gaUsrPropertyRepository.update(t);
	}

	@Transactional
	@Override
	public void delete(GaUsrProperty t) throws Exception {
		// TODO Auto-generated method stub
		this.gaUsrPropertyRepository.delete(t);
	}

	@Override
	public GaUsrProperty findById(GaUsrProperty t) throws Exception {
		// TODO Auto-generated method stub
		return this.gaUsrPropertyRepository.findById(t);
	}

	@Override
	public List<GaUsrProperty> findAll() throws Exception {
		// TODO Auto-generated method stub
		return this.gaUsrPropertyRepository.findAll();
	}

	@Override
	public GaUsrProperty buscaPorUsr(String p_cod_usr) throws Exception {
		// TODO Auto-generated method stub
		return this.gaUsrPropertyRepository.buscaPorUsr(p_cod_usr);
	}

}
