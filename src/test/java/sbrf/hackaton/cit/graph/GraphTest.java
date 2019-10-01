package sbrf.hackaton.cit.graph;

import org.junit.jupiter.api.Test;
import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.domain.Road;
import sbrf.hackaton.cit.domain.Route;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Komyshenets on 28.09.2019.
 */
class GraphTest {
    private static int[] vx = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int[][] ex = {
            {0, 4, 3, 1, 0, 0, 0, 0, 0, 0},
            {4, 0, 0, 6, 3, 0, 0, 0, 0, 0},
            {3, 0, 0, 0, 10, 0, 0, 0, 0, 0},
            {1, 6, 0, 0, 0, 8, 14, 0, 0, 0},
            {0, 3, 10, 0, 0, 0, 0, 11, 0, 0},
            {0, 0, 0, 8, 0, 0, 2, 4, 0, 0},
            {0, 0, 0, 14, 0, 2, 0, 0, 1, 0},
            {0, 0, 0, 0, 11, 4, 0, 0, 6, 3},
            {0, 0, 0, 0, 0, 0, 1, 6, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 3, 0, 0}
    };

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

        for (Route rout : allAvailableRouts) {
            System.out.println(rout);
        }

        Route bestRouts = roadExplorer.getBestRouts().orElse(null
        );
        System.out.println("best: " + bestRouts);
    }
}