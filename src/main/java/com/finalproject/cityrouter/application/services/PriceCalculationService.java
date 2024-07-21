package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.Price;

interface PriceCalculationService {
    Price calculatePrice(Integer segmentsQuantity);
}
