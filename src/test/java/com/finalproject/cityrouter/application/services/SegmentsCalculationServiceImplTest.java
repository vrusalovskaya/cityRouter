package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SegmentsCalculationServiceImplTest {

    private SegmentsCalculationServiceImpl service;

    @BeforeEach
    void setUp() {
       service = new SegmentsCalculationServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void calculateSegments_FromDepartureToArrival_ReturnExpected(City departure, City arrival, Integer expected) {
        int segmentsQuantity = service.calculateSegments(arrival, departure);
        assertEquals(expected, segmentsQuantity);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(City.LONDON, City.BRISTOL, 7),
                Arguments.of(City.COVENTRY, City.READING, 5),
                Arguments.of(City.LONDON, City.LONDON, 0)
        );
    }
}