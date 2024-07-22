package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.City;
import com.finalproject.cityrouter.application.models.RouteInfo;

/**
 * Service interface for calculating route information between two cities.
 */
public interface RouteCalculationService {
    /**
     * Calculates the route information between the specified departure and arrival cities.
     *
     * @param departure the city from which the route starts
     * @param arrival the city where the route ends
     * @return the route information including the number of segments and the total price
     * @throws IllegalArgumentException if either the departure or arrival city is null
     */
    RouteInfo calculateRoute(City departure, City arrival);
}
