package com.bsale.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class FlightSimulation {
	
	 private int flightId;
	    private long takeoffDateTime;
	    private String takeoffAirport;
	    private long landingDateTime;
	    private String landingAirport;
	    private int airplaneId;
	    
	    private List<Passenger> passengers;
		public int getFlightId() {
			return flightId;
		}
		
		public void setFlightId(int flightId) {
			this.flightId = flightId;
		}
		public long getTakeoffDateTime() {
			return takeoffDateTime;
		}
		public void setTakeoffDateTime(long takeoffDateTime) {
			this.takeoffDateTime = takeoffDateTime;
		}
		public String getTakeoffAirport() {
			return takeoffAirport;
		}
		public void setTakeoffAirport(int i) {
			this.takeoffAirport = i;
		}
		public long getLandingDateTime() {
			return landingDateTime;
		}
		public void setLandingDateTime(long landingDateTime) {
			this.landingDateTime = landingDateTime;
		}
		public String getLandingAirport() {
			return landingAirport;
		}
		public void setLandingAirport(String landingAirport) {
			this.landingAirport = landingAirport;
		}
		public int getAirplaneId() {
			return airplaneId;
		}
		public void setAirplaneId(int airplaneId) {
			this.airplaneId = airplaneId;
		}
		public static List<Passenger> getPassengers() {
			return getPassengers();
		}
		public void setPassengers(List<Passenger> passengers) {
			this.passengers = passengers;
		}
		public FlightSimulation(int flightId, long takeoffDateTime, String takeoffAirport, long landingDateTime,
				String landingAirport, int airplaneId, List<Passenger> passengers) {
			super();
			this.flightId = flightId;
			this.takeoffDateTime = takeoffDateTime;
			this.takeoffAirport = takeoffAirport;
			this.landingDateTime = landingDateTime;
			this.landingAirport = landingAirport;
			this.airplaneId = airplaneId;
			this.passengers = passengers;
		}
		public FlightSimulation() {
			super();
			
		}
	    
	    

}
