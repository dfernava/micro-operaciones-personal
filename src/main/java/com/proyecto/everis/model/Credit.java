package com.proyecto.everis.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "credit_personal")
@Data
public class Credit {
	
	private String id;
	
	private Product product;
	
	private String fecha_apertura;
	
	private long total_credito;
	
	private long consumido;

}
