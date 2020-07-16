package com.proyecto.everis.model;

import java.util.List;

import lombok.Data;

@Data
public class ClientAccount {
	
	private String id;
	
	private Client client;
	
	private List<Account> accounts;

}
