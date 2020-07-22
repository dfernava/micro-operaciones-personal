package com.proyecto.everis.dto;

import java.util.List;

import com.proyecto.everis.model.Account;
import com.proyecto.everis.model.Client;

import lombok.Data;

@Data
public class ClientAccountDTO {
	
	private Client client;
	
	private List<Account> accounts;

}
