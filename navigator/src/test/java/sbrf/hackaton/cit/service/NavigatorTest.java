package sbrf.hackaton.cit.service;

import org.junit.Assert;
import org.junit.Test;
import sbrf.hackaton.cit.GraphContext;
import sbrf.hackaton.cit.Navigator;
import sbrf.hackaton.cit.core.Route;
import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Car;

import java.util.List;

class NavigatorTest extends TestGraph {
    @Test
    public void roadBuilderTest() {
        Navigator navigator = new Navigator();

        Atm point = new GraphContext(vertexes, directionEdges).getVertex(0);
        Car car = new Car(15, 10);

        List<Route> routes = navigator.buildRoutes(point, point, car);
        for (Route route : routes) {
            System.out.println(route);
        }
        double sumAtm = routes.stream().filter(route -> route.getCost() != 0.0).mapToDouble(Route::getVertexValue).sum();
        double sumRoad = routes.stream().filter(route -> route.getCost() != 0.0).mapToDouble(Route::getEdgesValue).sum();
        Assert.assertEquals(8, sumAtm, 0.01);
        Assert.assertEquals(8, sumRoad, 0.01);
    }
}