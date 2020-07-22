package com.proyecto.everis.resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.everis.model.Account;
import com.proyecto.everis.model.Client;
import com.proyecto.everis.service.IAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personalaccounts")
public class AccountController {
	
	@Autowired
	private IAccountService service;
	
	@PostMapping
	Mono<Account> create(@Valid @RequestBody Account client){
		return service.create(client);
	}
	
	@GetMapping(produces = "application/json")
	Flux<Account> listAll(){
		return service.listAll();
	}
	
	@GetMapping(produces = "application/json",value="/{id}")
	Mono<Account> listById(@PathVariable String id){
		return service.finId(id);
	}
	
	@GetMapping("/clientone")
	public Client listOneClient() {
		Client cl=new Client();
		try {

            URL url = new URL("http://localhost:8080/clients/1");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            StringBuffer response=new StringBuffer();
            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            ObjectMapper objectMapper=new ObjectMapper();            
            cl=objectMapper.readValue(response.toString(), Client.class);
            System.out.println(response);
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
		return cl;
	}
	
	@GetMapping("/client")
	public List<Client> listAllClient() {
		List<Client> cl=new ArrayList<Client>();
		try {

            URL url = new URL("http://localhost:8080/clients");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            StringBuffer response=new StringBuffer();
            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            ObjectMapper objectMapper=new ObjectMapper();            
            cl=Arrays.asList( objectMapper.readValue(response.toString(), Client[].class));
            System.out.println(response);
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
		return cl;
	}
	
	@PutMapping
	Mono<Account> update(@Valid @RequestBody Account client){
		return service.update(client);
	}
	
	@DeleteMapping(value="/{id}")
	Mono<Void> deleteById(@PathVariable String id) {
		return service.delete(id);
	}

}