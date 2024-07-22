package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.Currency;
import com.finalproject.cityrouter.application.models.Price;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Implementation of the {@link PriceCalculationService} that calculates the price based on the number of segments.
 */
@Service
class PriceCalculationServiceImpl implements PriceCalculationService {

    private static final BigDecimal PRICE_FOR_ONE_SEGMENT = BigDecimal.valueOf(5);
    private static final BigDecimal PRICE_FOR_TWO_SEGMENTS = BigDecimal.valueOf(7);
    private static final BigDecimal PRICE_FOR_THREE_SEGMENTS = BigDecimal.valueOf(10);
    private static final Integer SEGMENTS_FOR_THREE_SEGMENT_PRICE = 3;
    private static final Integer SEGMENTS_FOR_TWO_SEGMENT_PRICE = 2;
    private static final Integer SEGMENTS_FOR_ONE_SEGMENT_PRICE = 1;

    @Override
    public Price calculatePrice(Integer segmentsQuantity) {
        int threeSegmentBundles = segmentsQuantity / SEGMENTS_FOR_THREE_SEGMENT_PRICE;
        int remainingSegments = segmentsQuantity % SEGMENTS_FOR_THREE_SEGMENT_PRICE;

        BigDecimal price = PRICE_FOR_THREE_SEGMENTS.multiply(BigDecimal.valueOf(threeSegmentBundles));

        if (remainingSegments == SEGMENTS_FOR_TWO_SEGMENT_PRICE) {
            price = price.add(PRICE_FOR_TWO_SEGMENTS);
        } else if (remainingSegments == SEGMENTS_FOR_ONE_SEGMENT_PRICE) {
            price = price.add(PRICE_FOR_ONE_SEGMENT);
        }

        return new Price(price, Currency.GBP);
    }
}
