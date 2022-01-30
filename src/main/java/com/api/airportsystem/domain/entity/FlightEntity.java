package com.api.airportsystem.domain.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "flight_information")
public class FlightEntity {

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBGeneratedUuid(value = DynamoDBAutoGenerateStrategy.CREATE)
    @DynamoDBAttribute
    private String id;

    @DynamoDBAttribute(attributeName = "boarding_gate")
    private String boardingGate;

    @DynamoDBAttribute
    private Date flightTakeOffDate;

    @DynamoDBAttribute
    private Date flightLandingDate;

    @DynamoDBAttribute
    private Long numberSeats;

    @DynamoDBAttribute
    private String takeOffAirport;

    @DynamoDBAttribute
    private String landingAirport;

    public FlightEntity(String boardingGate, Date flightTakeOffDate, Date flightLandingDate, Long numberSeats, String takeOffAirport, String landingAirport) {
        this.boardingGate = boardingGate;
        this.flightTakeOffDate = flightTakeOffDate;
        this.flightLandingDate = flightLandingDate;
        this.numberSeats = numberSeats;
        this.takeOffAirport = takeOffAirport;
        this.landingAirport = landingAirport;
    }
}
