package com.bsale.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsale.model.BoardingPass;
import com.bsale.model.Flight;
import com.bsale.model.FlightSimulation;
import com.bsale.model.Passenger;
import com.bsale.model.ResponseWrapper;
import com.bsale.model.Seat;
import com.bsale.repository.BoardingPassRepository;
import com.bsale.repository.FlightRepository;
import com.bsale.repository.PassengerRepository;
import com.bsale.repository.PurchaseRepository;
import com.bsale.repository.SeatRepository;

@Service
public class FlightService {

    private final BoardingPassRepository boardingPassRepository;
    private final SeatRepository seatRepository;
    private final PassengerRepository passengerRepository;
    private final PurchaseRepository purchaseRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(BoardingPassRepository boardingPassRepository, SeatRepository seatRepository,
                         PassengerRepository passengerRepository, PurchaseRepository purchaseRepository,
                         FlightRepository flightRepository) {
        this.boardingPassRepository = boardingPassRepository;
        this.seatRepository = seatRepository;
        this.passengerRepository = passengerRepository;
        this.purchaseRepository = purchaseRepository;
        this.flightRepository = flightRepository;
    }

    public FlightSimulation getFlightSimulation(int flightId) {
      
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found with ID: " + flightId));

        List<BoardingPass> boardingPasses = boardingPassRepository.findByFlightId(flightId);

        // Obtener la lista de pasajeros y asientos disponibles
        List<Passenger> passengers = passengerRepository.findByPurchaseIdIn(boardingPasses.stream()
                .map(BoardingPass::getPurchaseId)
                .collect(Collectors.toList()));

        List<Seat> availableSeats = seatRepository.findByAirplaneId(flight.getAirplane_id());

        // Asignar asientos a las tarjetas de embarque
        assignSeats(boardingPasses, passengers, availableSeats);

        // Crear la simulación del vuelo
        FlightSimulation flightSimulation = new FlightSimulation();
        flightSimulation.setFlightId(flight.getFlight_id());
        flightSimulation.setTakeoffDateTime(flight.getTakeoff_date_time());
        flightSimulation.setTakeoffAirport(flight.getTakeoff_airport());
        flightSimulation.setLandingDateTime(flight.getLanding_date_time());
        flightSimulation.setLandingAirport(flight.getAirport());
        flightSimulation.setAirplaneId(flight.getAirplane_id());
        flightSimulation.setPassengers(passengers);

        return flightSimulation;
    }

    private void assignSeats(List<BoardingPass> boardingPasses, List<Passenger> passengers, List<Seat> availableSeats) {
       
        List<Passenger> minorPassengers = passengers.stream()
                .filter(passenger -> passenger.getAge() < 18)
                .collect(Collectors.toList());

    
        Map<Integer, List<Passenger>> adultPassengersByPurchaseId = passengers.stream()
                .filter(passenger -> passenger.getAge() >= 18)
                .collect(Collectors.groupingBy(Passenger::getPurchaseId));

     
        for (List<Passenger> adultPassengers : adultPassengersByPurchaseId.values()) {
            List<Seat> assignedSeats = new ArrayList<>();

            for (Passenger adultPassenger : adultPassengers) {
                Seat assignedSeat = findSeatForPassenger(adultPassenger, assignedSeats, availableSeats);
                assignedSeats.add(assignedSeat);

             
                for (Passenger minorPassenger : minorPassengers) {
                    if (areAdjacentSeats(assignedSeat, minorPassenger, assignedSeats)) {
                        Seat minorAssignedSeat = findSeatForPassenger(minorPassenger, assignedSeats, availableSeats);
                        assignedSeats.add(minorAssignedSeat);
                    }
                }
            }
        }
    }

    private Seat findSeatForPassenger(Passenger passenger, List<Seat> assignedSeats, List<Seat> availableSeats) {
      
        for (Seat availableSeat : availableSeats) {
            if (!isSeatAssigned(availableSeat, assignedSeats) && !isSeatAdjacentToPassenger(availableSeat, passenger, assignedSeats)) {
                return availableSeat;
            }
        }
        return null;  
    }

    private boolean isSeatAssigned(Seat seat, List<Seat> assignedSeats) {
        return assignedSeats.contains(seat);
    }

    private boolean isSeatAdjacentToPassenger(Seat seat, Passenger passenger, List<Seat> assignedSeats) {
        for (Seat assignedSeat : assignedSeats) {
            if (areAdjacentSeats(seat, assignedSeat)) {
                return true;
            }
        }
        return false;
    }

    private boolean areAdjacentSeats(Seat seat1, Seat seat2) {
        int seat1Row = seat1.getSeat_row();
        int seat1Number = seat1.getSeat_id();
        int seat2Row = seat2.getSeat_row();
        int seat2Number = seat2.getSeat_id();

        return seat1Row == seat2Row && Math.abs(seat1Number - seat2Number) == 1;
    }
}
