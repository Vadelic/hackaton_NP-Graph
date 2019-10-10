package sbrf.hackaton.cit.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import sbrf.hackaton.cit.ExplorerFactory;
import sbrf.hackaton.cit.GraphContext;
import sbrf.hackaton.cit.core.Route;
import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.domain.Road;
import sbrf.hackaton.cit.explorer.Explorer;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Komyshenets on 28.09.2019.
 */
class GraphBuilderTest extends TestGraph {

    @Test
    void Constructor() {
        GraphContext graph = new GraphContext(vertexes, directionEdges);
        System.out.println(graph);

        Atm rootVertex = graph.getRootVertex(0);
        System.out.println(rootVertex);
        Assert.assertEquals(graph.getRootVertex(0).getPossibleRoutes().size(), 3);
        Assert.assertEquals(graph.getRootVertex(1).getPossibleRoutes().size(), 2);

        Set<Road> edges = rootVertex.getRoads();
        edges.forEach(System.out::println);
        Assert.assertEquals(8, edges.stream().mapToDouble(Road::getDistance).sum(), 0.01);
    }



    @Test
    void lookingSimpleTwoWay() {
        Atm destinationPoint = new GraphContext(vertexes, edges).getRootVertex(0);
        Car car = new Car(15, 10);
        Explorer roadExplorer = ExplorerFactory.getExplorer(destinationPoint, car);
        roadExplorer.routeSearch(destinationPoint);

        Collection<Route> allAvailableRouts = roadExplorer.routeSearch(destinationPoint);
        Assert.assertEquals(7, allAvailableRouts.size());

        for (Route rout : allAvailableRouts) {
            System.out.println(rout);
        }
        Assert.assertEquals(66, allAvailableRouts.stream().mapToDouble(Route::getEdgesValue).sum(), 0.01);
        Assert.assertEquals(41, allAvailableRouts.stream().mapToDouble(Route::getVertexValue).sum(), 0.01);
    }


    @Test
    void lookingOneWayGraph() {
        Atm destinationPoint = new GraphContext(vertexes, directionEdges).getRootVertex(0);
        Car car = new Car(15, 10);
        Explorer roadExplorer = ExplorerFactory.getExplorer(destinationPoint, car);
        roadExplorer.routeSearch(destinationPoint);

        Collection<Route> allAvailableRouts = roadExplorer.routeSearch(destinationPoint);
        Assert.assertEquals(4, allAvailableRouts.size());

        for (Route rout : allAvailableRouts) {
            System.out.println(rout);
        }
        Assert.assertEquals(33, allAvailableRouts.stream().mapToDouble(Route::getEdgesValue).sum(), 0.01);
        Assert.assertEquals(23, allAvailableRouts.stream().mapToDouble(Route::getVertexValue).sum(), 0.01);
    }
}