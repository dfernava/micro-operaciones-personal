package com.proyecto.everis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.everis.model.ClientCredit;
import com.proyecto.everis.repository.IClientCreditRepository;
import com.proyecto.everis.service.IClientCreditService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientCreditServiceImpl implements IClientCreditService {

	@Autowired
	private IClientCreditRepository repository;
	
	@Override
	public Mono<ClientCredit> create(ClientCredit t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public Mono<ClientCredit> update(ClientCredit t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public Mono<Void> delete(String id) {
		// TODO Auto-generated method stub
		return repository.deleteById(id);
	}

	@Override
	public Mono<ClientCredit> finId(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Flux<ClientCredit> listAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<Void> deleteAll() {
		// TODO Auto-generated method stub
		return repository.deleteAll();
	}

}
