package com.proyecto.everis.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.everis.model.ClientAccount;

@Repository
public interface IClientAccountRepository extends ReactiveMongoRepository<ClientAccount, String> {

}
