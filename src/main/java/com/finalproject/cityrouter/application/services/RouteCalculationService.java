package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.City;
import com.finalproject.cityrouter.application.models.RouteInfo;

public interface RouteCalculationService {
    RouteInfo calculateRoute(City departure, City arrival);
}
