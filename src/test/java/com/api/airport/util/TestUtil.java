package com.api.airport.util;

import com.api.airport.domain.entity.FlightEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestUtil {

    public static final String USER_ID = "5c64b08c-060e-4d33-ab41-aa134d444c19";

    public static final String FLIGHT_ID_FIRST = "6f5fd5d3-558d-4c3b-85fb-837a7d541118";

    public static final String FLIGHT_ID_SECOND = "068139e8-aabc-4e3c-ba80-2770de61d6fa";

    public static final Date FLIGHT_TAKE_OFF_DATE = new Date(1643559009656L);

    public static final Date FLIGHT_LANDING_DATE = new Date(1643645409656L);

    public static final Long NUMBER_SEATS = 120L;

    public static FlightEntity getFlight(String flightId, String boardingGate, String takeOffAirport, String landingAirport) {
        return new FlightEntity(flightId, boardingGate, FLIGHT_TAKE_OFF_DATE, FLIGHT_LANDING_DATE,
                NUMBER_SEATS, takeOffAirport, landingAirport);
    }

    public static List<FlightEntity> getListFlight(FlightEntity flightEntityFirst, FlightEntity flightEntitySecond) {
        List<FlightEntity> flightEntityList = new ArrayList<>();

        flightEntityList.add(flightEntityFirst);
        flightEntityList.add(flightEntitySecond);

        return flightEntityList;
    }
}
