package com.bsale.repository;

import com.bsale.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

	List<Passenger> findByFlightId(int flightId);

 

}