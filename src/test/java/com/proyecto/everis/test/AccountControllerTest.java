package com.proyecto.everis.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.proyecto.everis.model.Account;
import com.proyecto.everis.model.Client;
import com.proyecto.everis.model.Product;
import com.proyecto.everis.resource.AccountController;
import com.proyecto.everis.service.impl.AccountServiceImpl;

import reactor.core.publisher.Mono;

@WebFluxTest(controllers = AccountController.class)
public class AccountControllerTest {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@Autowired
	private AccountServiceImpl accountService;
	
	@Test
	public void createAccount() {
		Account ac=new Account();
		Client cl=new Client();
		cl.setId("1");
		cl.setNameClient("PEPE");
		cl.setNumDoc("12345678");
		cl.setTypeDoc("DNI");
		cl.setTypeClient("PERSONAL");
		Product pr=new Product();
		pr.setId("1");
		pr.setNameProduct("TARJETA MC");
		pr.setTypeProduct("CREDITO");
		ac.setId("1");
		ac.setClientId("1");
		ac.setProductId("1");
		ac.setDescripcion("pro todo los");
		LocalDateTime fechaDateTime= LocalDateTime.now();
		ac.setFecha_apertura(fechaDateTime);
		ac.setMonto(123.00);
		List<String> titulares= new ArrayList<String>();
		titulares.add("lll");
		titulares.add("ppp");
		ac.setFirmantes(titulares);		
		ac.setTitulares(titulares);
		accountService.deleteAll();
		
		webTestClient.post().uri("/personalaccounts")
		.accept(MediaType.APPLICATION_JSON)
		.body(Mono.just(ac),Account.class)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON.toString())
		.expectBody()
		.jsonPath("$.client.nameClient", "PEPE");
	}
	
	@Test
	public void listAccount() {
		webTestClient.get().uri("/personalaccounts")
				.exchange()
				.expectStatus().isOk()
				.expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON.toString())
				.expectBodyList(Account.class).hasSize(2);
			     
               
	}	
	
	@Test
	public void listOneClient() {
		webTestClient.get().uri("/personalaccounts/{id}",1)
			.exchange()
	        .expectStatus().isOk()
	        .expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON.toString())
	        .expectBody()
	        .jsonPath("$.client.nameClient").isEqualTo("PEPE");      
	}
	
	@Test
	public void updateAccount() {
		Account ac=new Account();
		Client cl=new Client();
		cl.setId("1");
		cl.setNameClient("PEPE");
		cl.setNumDoc("12345678");
		cl.setTypeDoc("DNI");
		cl.setTypeClient("PERSONAL");
		Product pr=new Product();
		pr.setId("1");
		pr.setNameProduct("TARJETA MC");
		pr.setTypeProduct("CREDITO");
		ac.setId("1");
		ac.setClientId("1");
		ac.setProductId("1");
		ac.setDescripcion("pro todo los");
		LocalDateTime fechaDateTime= LocalDateTime.now();
		ac.setFecha_apertura(fechaDateTime);
		ac.setMonto(123.00);
		List<String> titulares= new ArrayList<String>();
		titulares.add("lll");
		titulares.add("ppp");
		ac.setFirmantes(titulares);		
		ac.setTitulares(titulares);
		accountService.deleteAll();
		
		webTestClient.put().uri("/personalaccounts")
		.accept(MediaType.APPLICATION_JSON)
		.body(Mono.just(ac),Account.class)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().valueEquals("Content-Type", MediaType.APPLICATION_JSON.toString())
		.expectBody()
		.jsonPath("$.client.nameClient", "PEPE");
	}
	
	@Test
	public void deleteOne() {
		webTestClient.delete()
        .uri("/personalaccounts/1")
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class);
	}
	
	@Test
	public void deleteAll() {
		webTestClient.delete()
        .uri("/personalaccounts")
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class);
	}
	

}
