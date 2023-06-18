package com.bsale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Airplane {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airplaneId;

    private String name;

	public Airplane(int airplaneId, String name) {
		super();
		this.airplaneId = airplaneId;
		this.name = name;
	}
    
    

}
