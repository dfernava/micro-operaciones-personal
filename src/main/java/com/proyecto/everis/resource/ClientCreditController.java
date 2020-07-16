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

import com.proyecto.everis.model.ClientCredit;
import com.proyecto.everis.service.IClientCreditService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientcredits")
public class ClientCreditController {
	
	@Autowired
	private IClientCreditService service;
	
	@PostMapping
	Mono<ClientCredit> create(@Valid @RequestBody ClientCredit client){
		return service.create(client);
	}
	
	@GetMapping(produces = "application/json")
	Flux<ClientCredit> listAll(){
		return service.listAll();
	}
	
	@GetMapping(produces = "application/json",value="/{id}")
	Mono<ClientCredit> listById(@PathVariable String id){
		return service.finId(id);
	}
	
	@PutMapping
	Mono<ClientCredit> update(@Valid @RequestBody ClientCredit client){
		return service.update(client);
	}
	
	@DeleteMapping(value="/{id}")
	Mono<Void> deleteById(@PathVariable String id) {
		return service.delete(id);
	}

}
