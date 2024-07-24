package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.City;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Implementation of the {@link SegmentsCalculationService} that calculates the number of segments
 * between two cities using a weighted graph and Dijkstra's algorithm.
 */
@Service
class SegmentsCalculationServiceImpl implements SegmentsCalculationService {

    private final DefaultUndirectedWeightedGraph<City, DefaultWeightedEdge> graph;

    /**
     * Constructs a new {@code SegmentsCalculationServiceImpl} and initializes the graph with vertices and edges.
     * <p>
     * The graph is initialized with the following edges and weights:
     * <ul>
     *     <li>Birmingham to Coventry: 1</li>
     *     <li>Birmingham to Swindon: 4</li>
     *     <li>Birmingham to Bristol: 3</li>
     *     <li>Bristol to Swindon: 2</li>
     *     <li>Swindon to Reading: 4</li>
     *     <li>Reading to London: 1</li>
     *     <li>London to Northampton: 2</li>
     *     <li>Northampton to Coventry: 2</li>
     * </ul>
     * </p>
     */
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

    /**
     * <p>
     * This method uses Dijkstra's algorithm to find the shortest path between the cities, which represents
     * the minimum number of segments required. The weight of the path is returned as the number of segments.
     * </p>
     */
    @Override
    public Integer calculateSegments(City departure, City arrival) {
        DijkstraShortestPath<City, DefaultWeightedEdge> dijkstraAlg = new DijkstraShortestPath<>(graph);
        GraphPath<City, DefaultWeightedEdge> path = dijkstraAlg.getPath(departure, arrival);
        return (int) path.getWeight();
    }
}
