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
public class SeatType {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seat_type_Id;
    private String name;
	public SeatType(int seat_type_Id, String name) {
		super();
		this.seat_type_Id = seat_type_Id;
		this.name = name;
	}
   
    
    
}
