package com.proyecto.everis.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.everis.model.ClientCredit;

@Repository
public interface IClientCreditRepository extends ReactiveMongoRepository<ClientCredit, String>{

}
