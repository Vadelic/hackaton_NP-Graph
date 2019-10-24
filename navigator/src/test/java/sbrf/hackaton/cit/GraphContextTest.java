package sbrf.hackaton.cit;

import org.junit.Assert;
import org.junit.Test;
import sbrf.hackaton.cit.core.Route;
import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.domain.Road;
import sbrf.hackaton.cit.explorer.DfsExplorer;
import sbrf.hackaton.cit.service.GraphTest;

import java.util.Set;

public class GraphContextTest extends GraphTest {

    @Test
    public void getVertex() {
    }

    @Test
    void Constructor() {
        GraphContext graph = new GraphContext(vertexes, directionEdges);
        System.out.println(graph);

        Atm rootVertex = graph.getVertex(0);
        System.out.println(rootVertex);
        Assert.assertEquals(graph.getVertex(0).getPossibleRoutes().size(), 3);
        Assert.assertEquals(graph.getVertex(1).getPossibleRoutes().size(), 2);

        Set<Road> edges = rootVertex.getRoads();
        edges.forEach(System.out::println);
        Assert.assertEquals(8, edges.stream().mapToDouble(Road::getDistance).sum(), 0.01);
    }


    @Test
    void lookingSimpleTwoWay() {
        Atm point = new GraphContext(vertexes, edges).getVertex(0);
        Car car = new Car("carrr", 15, 10, point, DfsExplorer::new);
        DfsExplorer dfsExplorer = new DfsExplorer(car);
        Route route = dfsExplorer.routeSearch(point);
        System.out.println(route);

//        Explorer roadExplorer = ExplorerFactory.getExplorer(point, car);

//        Route allAvailableRouts = roadExplorer.routeSearch(point);
//        System.out.println(allAvailableRouts);
//        Assert.assertEquals(7, allAvailableRouts.size());
//        for (Route rout : allAvailableRouts) {
//            System.out.println(rout);
//        }
//        Assert.assertEquals(66, allAvailableRouts.stream().mapToDouble(Route::getEdgesValue).sum(), 0.01);
//        Assert.assertEquals(41, allAvailableRouts.stream().mapToDouble(Route::getVertexValue).sum(), 0.01);
    }


    @Test
    void lookingOneWayGraph() {
        Atm point = new GraphContext(vertexes, directionEdges).getVertex(0);
        Car car = new Car("", 15, 10, point, DfsExplorer::new);
        DfsExplorer dfsExplorer = new DfsExplorer(car);
        Route route = dfsExplorer.routeSearch(point);
        System.out.println(route);

//        Explorer roadExplorer = ExplorerFactory.getExplorer(point, car);
//        roadExplorer.routeSearch(point);
//
//        Route allAvailableRouts = roadExplorer.routeSearch(point);
//        System.out.println(allAvailableRouts);
//        Assert.assertEquals(4, allAvailableRouts.size());
//
//        for (Route rout : allAvailableRouts) {
//            System.out.println(rout);
//        }
//        Assert.assertEquals(33, allAvailableRouts.stream().mapToDouble(Route::getEdgesValue).sum(), 0.01);
//        Assert.assertEquals(23, allAvailableRouts.stream().mapToDouble(Route::getVertexValue).sum(), 0.01);
    }
}