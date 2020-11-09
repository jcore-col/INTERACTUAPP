package com.jcore.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.jcore.model.entity.GaUser;
import com.jcore.model.entity.GaUsrGroupMember;
import com.jcore.repository.GaUsrGroupMemberRepository;
import com.jcore.service_interface.GaUsrGroupMemberCrudservice;
import com.jcore.service_interface.GaUsrPropertyCrudService;

@Named
public class GaUsrGroupMemberService implements GaUsrGroupMemberCrudservice, Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private GaUsrGroupMemberRepository gaUsrGroupMemberRepository;
	
	@Transactional
	@Override
	public void insert(GaUsrGroupMember t) throws Exception {
		// TODO Auto-generated method stub
		this.gaUsrGroupMemberRepository.insert(t);
	}
	@Transactional
	@Override
	public void update(GaUsrGroupMember t) throws Exception {
		// TODO Auto-generated method stub
		this.gaUsrGroupMemberRepository.update(t);
	}
	@Transactional
	@Override
	public void delete(GaUsrGroupMember t) throws Exception {
		// TODO Auto-generated method stub
		this.gaUsrGroupMemberRepository.delete(t);
	}

	@Override
	public GaUsrGroupMember findById(GaUsrGroupMember t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GaUsrGroupMember> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}