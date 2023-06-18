package com.bsale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsale.model.Flight;
import com.bsale.model.FlightSimulation;
import com.bsale.model.Passenger;
import com.bsale.model.ResponseWrapper;
import com.bsale.service.FlightService;

@RestController
	@RequestMapping("/flights")
	public class FlightController {

	    private final FlightService flightService;

	    @Autowired
	    public FlightController(FlightService flightService) {
	        this.flightService = flightService;
	    }

	    @GetMapping("/{flightId}")
		public FlightSimulation getFlightSimulation(@PathVariable int flightId) {
			return flightService.getFlightSimulation(flightId);
		}  

	

	

}
