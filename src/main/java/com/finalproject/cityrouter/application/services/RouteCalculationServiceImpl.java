package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.City;
import com.finalproject.cityrouter.application.models.Price;
import com.finalproject.cityrouter.application.models.RouteInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link RouteCalculationService} that calculates route information between two cities.
 */
@Service
@AllArgsConstructor
@Slf4j
class RouteCalculationServiceImpl implements RouteCalculationService {

    private final SegmentsCalculationService segmentsCalculator;
    private final PriceCalculationService priceCalculator;

    @Override
    public RouteInfo calculateRoute(City departure, City arrival) {

        log.info("calculateRoute method is called. Details: {}, {}", departure, arrival);

        if (arrival == null) {
            log.error("Arrival city is null");
            throw new IllegalArgumentException("Arrival city cannot be null");
        }

        if (departure == null) {
            log.error("Departure city is null");
            throw new IllegalArgumentException("Departure city cannot be null");
        }

        Integer segments = segmentsCalculator.calculateSegments(departure, arrival);
        Price price = priceCalculator.calculatePrice(segments);
        log.info("Route is calculated. Details: {}, {}", segments, departure);
        return new RouteInfo(segments, price);
    }
}
