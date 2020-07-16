package com.proyecto.everis.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;

@Document(collection = "account_personal")
@Data
public class Account{
	
	private String id;
	
	private String descripcion;
	
	private long monto;
	
	private Product product;
	
	@JsonSerialize(using = ToStringSerializer.class) 
	private LocalDateTime fecha_apertura;
	
	private List<String> firmantes;
	
	private List<String> titulares;

}
