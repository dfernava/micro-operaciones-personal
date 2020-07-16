package com.proyecto.everis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.everis.model.ClientAccount;
import com.proyecto.everis.repository.IClientAccountRepository;
import com.proyecto.everis.service.IClientAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientAccountServiceImpl implements IClientAccountService {
	
	@Autowired
	private IClientAccountRepository repository;

	@Override
	public Mono<ClientAccount> create(ClientAccount t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public Mono<ClientAccount> update(ClientAccount t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public Mono<Void> delete(String id) {
		// TODO Auto-generated method stub
		return repository.deleteById(id);
	}

	@Override
	public Mono<ClientAccount> finId(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Flux<ClientAccount> listAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<Void> deleteAll() {
		// TODO Auto-generated method stub
		return repository.deleteAll();
	}

}
