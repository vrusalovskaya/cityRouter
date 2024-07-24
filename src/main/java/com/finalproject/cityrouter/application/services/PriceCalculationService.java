package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.Price;

/**
 * Service interface for calculating the price based on the number of segments.
 */
interface PriceCalculationService {
    /**
     * Calculates the price based on the quantity of segments.
     * <p>
     * The pricing rules are as follows:
     * <ul>
     *     <li>3 segments: £10</li>
     *     <li>2 segments: £7</li>
     *     <li>1 segment: £5</li>
     * </ul>
     * The price is calculated by first applying the rate for three segments as many times as possible,
     * then applying the rate for two segments if needed, and finally the rate for one segment if any segments remain.
     * </p>
     *
     * @param segmentsQuantity the number of segments to calculate the price for
     * @return the calculated price, including the currency
     */
    Price calculatePrice(Integer segmentsQuantity);
}
