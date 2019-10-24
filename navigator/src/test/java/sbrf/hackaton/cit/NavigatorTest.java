package sbrf.hackaton.cit;

import org.junit.Before;
import org.junit.Test;
import sbrf.hackaton.cit.core.FixedRoute;
import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.explorer.DfsExplorer;
import sbrf.hackaton.cit.service.GraphTest;

public class NavigatorTest extends GraphTest {
    Navigator navigator;
    GraphContext graphContext;

    @Before
    public void init() {
        graphContext = new GraphContext(vertexes, fullEdges);
        graphContext.setOutPoint(5);
        navigator = new Navigator(graphContext);
    }

    @Test
    public void buildRoutes() {

        Atm atm = graphContext.getVertex(0);
        Car car = new Car("", 15, 10, atm, c -> new DfsExplorer(c, 3));
        System.out.println("CAR0 " + car);

        FixedRoute fixedRoute = doStep(car);
        System.out.println("CAR1 " + car);
        fixedRoute = doStep(car);
        System.out.println("CAR2 " + car);
        fixedRoute = doStep(car);
        System.out.println("CAR3 " + car);

    }

    private FixedRoute doStep(Car car) {
        FixedRoute fixedRoute = navigator.buildRoutes(car);
        System.out.println("\n---------------------");
        System.out.println(fixedRoute);
        System.out.println("---------------------");
        return fixedRoute;
    }
}