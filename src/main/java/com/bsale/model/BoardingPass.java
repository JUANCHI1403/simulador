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
public class BoardingPass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boording_pass;
	
	private int purchase_id;
	
	private int passenger_id;
	
	private int seat_type_id;
	
	private int seat_id;
	
	private int flight_id;

	public BoardingPass(int boording_pass, int purchase_id, int passenger_id, int seat_type_id, int seat_id,
			int flight_id) {
		super();
		this.boording_pass = boording_pass;
		this.purchase_id = purchase_id;
		this.passenger_id = passenger_id;
		this.seat_type_id = seat_type_id;
		this.seat_id = seat_id;
		this.flight_id = flight_id;
	}
	
	
	
	

}
