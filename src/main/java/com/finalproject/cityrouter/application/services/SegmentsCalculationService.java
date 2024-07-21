package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.City;

interface SegmentsCalculationService {
    Integer calculateSegments(City departure, City arrival);
}
