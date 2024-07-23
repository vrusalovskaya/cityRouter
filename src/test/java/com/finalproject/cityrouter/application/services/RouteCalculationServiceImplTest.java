package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.City;
import com.finalproject.cityrouter.application.models.Currency;
import com.finalproject.cityrouter.application.models.Price;
import com.finalproject.cityrouter.application.models.RouteInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RouteCalculationServiceImplTest {

    @Mock
    private SegmentsCalculationService segmentsCalculator;

    @Mock
    private PriceCalculationService priceCalculator;

    @InjectMocks
    private RouteCalculationServiceImpl service;

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(City.LONDON, City.BRISTOL,
                        new RouteInfo(7, new Price(BigDecimal.valueOf(25), Currency.GBP))),
                Arguments.of(City.COVENTRY, City.READING,
                        new RouteInfo(5, new Price(BigDecimal.valueOf(17), Currency.GBP)))
        );
    }

    private static Stream<Arguments> provideTestDataForCausingExceptions() {
        return Stream.of(
                Arguments.of(null, City.BRISTOL),
                Arguments.of(City.COVENTRY, null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void calculateRoute_FromDepartureToArrival_ReturnExpected(City departure, City arrival, RouteInfo expected) {

        when(segmentsCalculator.calculateSegments(departure, arrival)).thenReturn(expected.getSegmentsQuantity());
        when(priceCalculator.calculatePrice(expected.getSegmentsQuantity())).thenReturn(expected.getPrice());

        RouteInfo routeInfo = service.calculateRoute(departure, arrival);

        assertNotNull(routeInfo);
        assertEquals(expected.getSegmentsQuantity(), routeInfo.getSegmentsQuantity());
        assertEquals(expected.getPrice(), routeInfo.getPrice());
        verify(segmentsCalculator).calculateSegments(departure, arrival);
        verify(priceCalculator).calculatePrice(expected.getSegmentsQuantity());
    }

    @ParameterizedTest
    @MethodSource("provideTestDataForCausingExceptions")
    void calculateRoute_nullAsCityParameter_throwsIllegalArgumentException(City departure, City arrival) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.calculateRoute(departure, arrival);
        });

        if (departure == null) {
            assertEquals("Departure city cannot be null", exception.getMessage());
        }

        if (arrival == null) {
            assertEquals("Arrival city cannot be null", exception.getMessage());
        }
    }
}