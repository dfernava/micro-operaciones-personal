package com.proyecto.everis.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.everis.model.ClientAccount;
import com.proyecto.everis.service.IClientAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientaccounts")
public class ClientAccountController {
	
	@Autowired
	private IClientAccountService service;
	
	@PostMapping
	Mono<ClientAccount> create(@Valid @RequestBody ClientAccount client){
		return service.create(client);
	}
	
	@GetMapping(produces = "application/json")
	Flux<ClientAccount> listAll(){
		return service.listAll();
	}
	
	@GetMapping(produces = "application/json",value="/{id}")
	Mono<ClientAccount> listById(@PathVariable String id){
		return service.finId(id);
	}
	
	@PutMapping
	Mono<ClientAccount> update(@Valid @RequestBody ClientAccount client){
		return service.update(client);
	}
	
	@DeleteMapping(value="/{id}")
	Mono<Void> deleteById(@PathVariable String id) {
		return service.delete(id);
	}

}
