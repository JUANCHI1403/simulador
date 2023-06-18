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
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seat_id;
	
	private String seat_column;
	
	private int seat_row;
	
	private int seat_type_id;
	
	private int airplane;

	public Seat(int seat_id, String seat_column, int seat_row, int seat_type_id, int airplane) {
		super();
		this.seat_id = seat_id;
		this.seat_column = seat_column;
		this.seat_row = seat_row;
		this.seat_type_id = seat_type_id;
		this.airplane = airplane;
	}
	
	
	

    
    
    
}
