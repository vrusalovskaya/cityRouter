package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.City;

/**
 * Service interface for calculating the number of segments between two cities.
 */
interface SegmentsCalculationService {
    /**
     * Calculates the number of segments required to travel between the specified departure and arrival cities.
     *
     * @param departure the city from which the route starts
     * @param arrival the city where the route ends
     * @return the number of segments required for the route
     * @throws IllegalArgumentException if either the departure or arrival city is not in the graph
     */
    Integer calculateSegments(City departure, City arrival);
}
