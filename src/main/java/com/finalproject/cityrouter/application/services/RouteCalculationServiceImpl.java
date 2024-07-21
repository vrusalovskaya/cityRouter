package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.City;
import com.finalproject.cityrouter.application.models.Price;
import com.finalproject.cityrouter.application.models.RouteInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class RouteCalculationServiceImpl implements RouteCalculationService {

    private final SegmentsCalculationService segmentsCalculator;
    private final PriceCalculationService priceCalculator;

    @Override
    public RouteInfo calculateRoute(City departure, City arrival) {

        if (arrival == null) {
            throw new IllegalArgumentException("Arrival city cannot be null");
        }

        if (departure == null) {
            throw new IllegalArgumentException("Departure city cannot be null");
        }

        Integer segments = segmentsCalculator.calculateSegments(arrival, departure);
        Price price = priceCalculator.calculatePrice(segments);
        return new RouteInfo(segments, price);
    }
}
