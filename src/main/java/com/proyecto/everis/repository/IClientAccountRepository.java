package com.proyecto.everis.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.everis.dto.ClientAccountDTO;
import com.proyecto.everis.model.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IClientAccountRepository extends ReactiveMongoRepository<ClientAccountDTO, String> {
	
	@Query("client._id:?0")
	Flux<Account> findByClientId(@Param("id") String id);

}
