package com.api.airportsystem.domain.mapper;

import com.api.airportsystem.domain.dto.FlightDTO;
import com.api.airportsystem.domain.entity.FlightEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "boardingGate"),
            @Mapping(target = "flightTakeOffDate"),
            @Mapping(target = "flightLandingDate"),
            @Mapping(target = "numberSeats"),
            @Mapping(target = "takeOffAirport"),
            @Mapping(target = "landingAirport")
    })
    FlightEntity toFlightEntityWithoutId(FlightDTO flightDTO);

    @Mappings({
            @Mapping(target = "id"),
            @Mapping(target = "boardingGate"),
            @Mapping(target = "flightTakeOffDate"),
            @Mapping(target = "flightLandingDate"),
            @Mapping(target = "numberSeats"),
            @Mapping(target = "takeOffAirport"),
            @Mapping(target = "landingAirport")
    })
    FlightEntity toFlightEntity(FlightDTO flightDTO);

    @Mappings({
            @Mapping(target = "id"),
            @Mapping(target = "boardingGate"),
            @Mapping(target = "flightTakeOffDate"),
            @Mapping(target = "flightLandingDate"),
            @Mapping(target = "numberSeats"),
            @Mapping(target = "takeOffAirport"),
            @Mapping(target = "landingAirport")
    })
    FlightDTO toFlightDTO(FlightEntity entity);
}
