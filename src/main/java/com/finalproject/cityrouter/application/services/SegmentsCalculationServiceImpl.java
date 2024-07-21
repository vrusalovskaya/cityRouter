package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.City;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
class SegmentsCalculationServiceImpl implements SegmentsCalculationService {

    private final DefaultUndirectedWeightedGraph<City, DefaultWeightedEdge> graph;

    public SegmentsCalculationServiceImpl() {
        graph = new DefaultUndirectedWeightedGraph<>(DefaultWeightedEdge.class);

        Arrays.stream(City.values()).forEach(graph::addVertex);

        graph.setEdgeWeight(graph.addEdge(City.BIRMINGHAM, City.COVENTRY), 1);
        graph.setEdgeWeight(graph.addEdge(City.BIRMINGHAM, City.SWINDON), 4);
        graph.setEdgeWeight(graph.addEdge(City.BIRMINGHAM, City.BRISTOL), 3);
        graph.setEdgeWeight(graph.addEdge(City.BRISTOL, City.SWINDON), 2);
        graph.setEdgeWeight(graph.addEdge(City.SWINDON, City.READING), 4);
        graph.setEdgeWeight(graph.addEdge(City.READING, City.LONDON), 1);
        graph.setEdgeWeight(graph.addEdge(City.LONDON, City.NORTHAMPTON), 2);
        graph.setEdgeWeight(graph.addEdge(City.NORTHAMPTON, City.COVENTRY), 2);
    }

    @Override
    public Integer calculateSegments(City departure, City arrival) {
        DijkstraShortestPath<City, DefaultWeightedEdge> dijkstraAlg = new DijkstraShortestPath<>(graph);
        GraphPath<City, DefaultWeightedEdge> path = dijkstraAlg.getPath(departure, arrival);
        return (int) path.getWeight();
    }
}
