package sbrf.hackaton.cit.graph;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import sbrf.hackaton.cit.api.Route;
import sbrf.hackaton.cit.api.explorer.GraphRecursionExplorer;
import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.domain.road.Road;
import sbrf.hackaton.cit.service.GraphBuilder;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Komyshenets on 28.09.2019.
 */
class GraphTest extends TestGraph {

    @Test
    void Constructor() {
        GraphBuilder graph = new GraphBuilder(vertexes, edges);
        System.out.println(graph);

        Atm rootVertex = graph.getRootVertex(0);
        System.out.println(rootVertex);
        Set<Road> edges = rootVertex.getRoads();
        System.out.println(edges);
    }

    @Test
    void looking() {
        Atm destinationPoint = new GraphBuilder(vertexes, edges).getRootVertex(0);
        Car car = new Car(15, 10);
        GraphRecursionExplorer roadExplorer = new GraphRecursionExplorer(destinationPoint, car);


        roadExplorer.routeSearch(destinationPoint);
        Collection<Route> allAvailableRouts = roadExplorer.getAllAvailableRouts();

        Assert.assertEquals(7, allAvailableRouts.size());

        for (Route rout : allAvailableRouts) {
            System.out.println(rout);
        }

    }

    @Test
    void lookingTwoWayGraph() {
        Atm destinationPoint = new GraphBuilder(vertexes, directionEdges).getRootVertex(0);
        Car car = new Car(15, 10);
        GraphRecursionExplorer roadExplorer = new GraphRecursionExplorer(destinationPoint, car);


        roadExplorer.routeSearch(destinationPoint);
        Collection<Route> allAvailableRouts = roadExplorer.getAllAvailableRouts();

        Assert.assertEquals(4, allAvailableRouts.size());

        for (Route rout : allAvailableRouts) {
            System.out.println(rout);
        }

    }


}