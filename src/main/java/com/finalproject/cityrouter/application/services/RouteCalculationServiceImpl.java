package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.City;
import com.finalproject.cityrouter.application.models.Price;
import com.finalproject.cityrouter.application.models.RouteInfo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link RouteCalculationService} that calculates route information between two cities.
 */
@Service
@AllArgsConstructor
class RouteCalculationServiceImpl implements RouteCalculationService {

    private static final Logger logger = LoggerFactory.getLogger(RouteCalculationServiceImpl.class);

    private final SegmentsCalculationService segmentsCalculator;
    private final PriceCalculationService priceCalculator;

    @Override
    public RouteInfo calculateRoute(City departure, City arrival) {

        logger.info("calculateRoute method is called. Details: {}, {}", departure, arrival);

        if (arrival == null) {
            logger.error("Arrival city is null");
            throw new IllegalArgumentException("Arrival city cannot be null");
        }

        if (departure == null) {
            logger.error("Departure city is null");
            throw new IllegalArgumentException("Departure city cannot be null");
        }

        Integer segments = segmentsCalculator.calculateSegments(arrival, departure);
        Price price = priceCalculator.calculatePrice(segments);
        logger.info("Route is calculated. Details: {}, {}", segments, departure);
        return new RouteInfo(segments, price);
    }
}
