package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCalculationServiceImplTest {

    private PriceCalculationServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new PriceCalculationServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void calculatePrice_ForInput_ReturnExpected(Integer input, BigDecimal expected) {
        Price price = service.calculatePrice(input);
        assertEquals(expected, price.getValue());
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(0, BigDecimal.ZERO),
                Arguments.of(1, BigDecimal.valueOf(5)),
                Arguments.of(2, BigDecimal.valueOf(7)),
                Arguments.of(3, BigDecimal.valueOf(10)),
                Arguments.of(4, BigDecimal.valueOf(15)),
                Arguments.of(5, BigDecimal.valueOf(17)),
                Arguments.of(6, BigDecimal.valueOf(20)),
                Arguments.of(7, BigDecimal.valueOf(25))
        );
    }
}