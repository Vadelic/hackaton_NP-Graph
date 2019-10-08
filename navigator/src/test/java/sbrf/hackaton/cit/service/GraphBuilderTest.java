package sbrf.hackaton.cit.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import sbrf.hackaton.cit.ExplorerFactory;
import sbrf.hackaton.cit.api.Route;
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
        GraphBuilder graph = new GraphBuilder(vertexes, directionEdges);
        System.out.println(graph);

        Atm rootVertex = graph.getRootVertex(0);
        System.out.println(rootVertex);
        Assert.assertEquals(graph.getRootVertex(0).getPossibleRoutes().size(), 3);
        Assert.assertEquals(graph.getRootVertex(1).getPossibleRoutes().size(), 2);

        Set<Road> edges = rootVertex.getRoads();
        for (Road edge : edges) {
            System.out.println(edge);
        }
    }

    @Test
    void looking() {
        Atm destinationPoint = new GraphBuilder(vertexes, edges).getRootVertex(0);
        Car car = new Car(15, 10);
        Explorer roadExplorer = ExplorerFactory.getRecursionExplorer(destinationPoint, car);


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
        Explorer roadExplorer = ExplorerFactory.getRecursionExplorer(destinationPoint, car);


        roadExplorer.routeSearch(destinationPoint);
        Collection<Route> allAvailableRouts = roadExplorer.getAllAvailableRouts();

        Assert.assertEquals(4, allAvailableRouts.size());

        for (Route rout : allAvailableRouts) {
            System.out.println(rout);
        }

    }


}