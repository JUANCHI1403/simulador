package com.bsale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsale.model.BoardingPass;

public abstract class BoardingPassRepository implements JpaRepository{

	protected abstract List<BoardingPass> findByFlightId(int flightId);

}
