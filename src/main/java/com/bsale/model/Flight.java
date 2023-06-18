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
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flight_id;
	
	private int takeoff_date_time;
	
	private int takeoff_airport;
	
	private int landing_date_time;
	
	private String airport;
	
	private int airplane_id;

	public Flight(int flight_id, int takeoff_date_time, int takeoff_airport, int landing_date_time, String airport,
			int airplane_id) {
		super();
		this.flight_id = flight_id;
		this.takeoff_date_time = takeoff_date_time;
		this.takeoff_airport = takeoff_airport;
		this.landing_date_time = landing_date_time;
		this.airport = airport;
		this.airplane_id = airplane_id;
	}
	
	
	
	
	
	
	
	
	

}
