package com.proyecto.everis.service;

import com.proyecto.everis.dto.ClientAccountDTO;
import com.proyecto.everis.model.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClientAccountService extends ICRUD<ClientAccountDTO>{
	
	Flux<Account> findByClientId(String id);

}
