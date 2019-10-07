package sbrf.hackaton.cit.graph;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.domain.atm.Atm;
import sbrf.hackaton.cit.domain.road.Road;
import sbrf.hackaton.cit.domain.route.Route;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Komyshenets on 28.09.2019.
 */
class GraphTest extends TestGraph {

    @Test
    void Constructor() {
        GraphBuilder graph = new GraphBuilder(vx, ex);
        System.out.println(graph);

        Atm rootVertex = graph.getRootVertex(0);
        System.out.println(rootVertex);
        Set<Road> edges = rootVertex.getRoads();
        System.out.println(edges);
    }

    @Test
    void looking() {
        Atm destinationPoint = new GraphBuilder(vx, ex).getRootVertex(0);
        Car car = new Car(15, 10);
        RoadExplorer roadExplorer = new RoadExplorer(destinationPoint, car);


        roadExplorer.routeSearch(destinationPoint);
        Collection<Route> allAvailableRouts = roadExplorer.getAllAvailableRouts();

        Assert.assertEquals(7, allAvailableRouts.size());

        for (Route rout : allAvailableRouts) {
            System.out.println(rout);
        }

        Route bestRoute = roadExplorer.getBestRouts().orElse(null);
        System.out.println("best: " + bestRoute);
        if (bestRoute != null) {
            car.visitRoute(bestRoute);
            roadExplorer.routeSearch(destinationPoint);
            allAvailableRouts = roadExplorer.getAllAvailableRouts();


            for (Route rout : allAvailableRouts) {
                System.out.println(rout);
            }

            bestRoute = roadExplorer.getBestRouts().orElse(null);
            System.out.println("best: " + bestRoute);
        }

    }

    @Test
    void lookingTwoWayGraph() {
        Atm destinationPoint = new GraphBuilder(vx, exD).getRootVertex(0);
        Car car = new Car(15, 10);
        RoadExplorer roadExplorer = new RoadExplorer(destinationPoint, car);


        roadExplorer.routeSearch(destinationPoint);
        Collection<Route> allAvailableRouts = roadExplorer.getAllAvailableRouts();

        Assert.assertEquals(4, allAvailableRouts.size());

        for (Route rout : allAvailableRouts) {
            System.out.println(rout);
        }

        Route bestRoute = roadExplorer.getBestRouts().orElse(null);
        System.out.println("best: " + bestRoute);


    }

}