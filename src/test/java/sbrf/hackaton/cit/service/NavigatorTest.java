package sbrf.hackaton.cit.service;

import org.junit.jupiter.api.Test;
import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.domain.Route;
import sbrf.hackaton.cit.graph.GraphBuilder;
import sbrf.hackaton.cit.graph.TestGraph;

import java.util.List;

class NavigatorTest extends TestGraph {
    @Test
    public void roadBuilderTest() {

        Atm point = new GraphBuilder(vx, ex).getRootVertex(0);
        Car car = new Car(15, 10);
        Navigator navigator = new Navigator();
        List<Route> routes = navigator.buildRoutes(point, point, car);
        for (Route route : routes) {
            System.out.println(route);
        }
    }
}