package com.bsale.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passenger_Id;
	
	private String dni;
	
	private String name;
	
	private int age;
	
	private String country;

	public Passenger(int passenger_Id, String dni, String name, int age, String country) {
		super();
		this.passenger_Id = passenger_Id;
		this.dni = dni;
		this.name = name;
		this.age = age;
		this.country = country;
	}
	

	

}
