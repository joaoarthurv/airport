package com.api.airportsystem.domain.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.api.airportsystem.domain.entity.FlightEntity;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FlightRepositoryImpl implements FlightRepository {
    private final DynamoDBMapper dynamoDBMapper;

    public FlightRepositoryImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public FlightEntity findFlightById(String id) {
        return dynamoDBMapper.load(FlightEntity.class, id);
    }

    @Override
    public List<FlightEntity> getAllFlights() {
        return dynamoDBMapper.scan(FlightEntity.class, new DynamoDBScanExpression());
    }

    @Override
    public void createFlight(FlightEntity flightEntity) {
        dynamoDBMapper.save(flightEntity);
    }

    @Override
    public void deleteFlight(FlightEntity flightEntity) {
        dynamoDBMapper.delete(flightEntity);
    }

    @Override
    public void updateFlight(FlightEntity flightEntity) {
        dynamoDBMapper.save(flightEntity);
    }
}
