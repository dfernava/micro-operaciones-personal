package com.proyecto.everis.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.everis.model.Account;

@Repository
public interface IAccountRepository extends ReactiveMongoRepository<Account, String> {

}
