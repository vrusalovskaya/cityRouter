package com.finalproject.cityrouter.presentation.controllers;

import com.finalproject.cityrouter.application.models.City;
import com.finalproject.cityrouter.application.models.RouteInfo;
import com.finalproject.cityrouter.application.services.RouteCalculationService;
import com.finalproject.cityrouter.presentation.Mapper;
import com.finalproject.cityrouter.presentation.dtos.RouteInfoDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.finalproject.cityrouter.presentation.Validator.isValidCity;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class RouteController {

    private static final Logger logger = LoggerFactory.getLogger(RouteController.class);

    private final RouteCalculationService routeCalculationService;

    @GetMapping("/route")
    public ResponseEntity<RouteInfoDto> calculateRouteInfo(
            @RequestParam String departure,
            @RequestParam String arrival) {

        if (!isValidCity(departure) || !isValidCity(arrival)) {
            return ResponseEntity.badRequest().body(new RouteInfoDto("Invalid arguments"));
        }

        RouteInfo routeInfo = routeCalculationService.calculateRoute(
                City.valueOf(departure.toUpperCase()),
                City.valueOf(arrival.toUpperCase()));

        logger.info("Route was successfully constructed");
        return ResponseEntity.ok(Mapper.toDto(routeInfo));
    }
}
