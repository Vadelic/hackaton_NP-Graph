package sbrf.hackaton.cit;

import org.junit.Before;
import org.junit.Test;
import sbrf.hackaton.cit.core.FixedRoute;
import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.explorer.DfsExplorer;

public class NavigatorGenTest {

    Navigator navigator;
    GraphContext graphContext;

    @Before
    public void init() {
        MatrixGenerator generator = new MatrixGenerator(100);
        graphContext = new GraphContext(generator.vertexValueRound(20), generator.edgesValueRound(15));
        graphContext.setOutPoint(5);
        navigator = new Navigator(graphContext);
        System.out.println(graphContext);
    }

    @Test
    public void getRoads() {

        Atm atm = graphContext.getVertex(0);
        Car car = new Car(480, 5000, atm, DfsExplorer::new);

        FixedRoute fixedRoute = doStep(car);
        System.out.println("CAR1" + car);
        fixedRoute = doStep(car);
        System.out.println("CAR2" + car);
        fixedRoute = doStep(car);
        System.out.println("CAR3" + car);

    }

    private FixedRoute doStep(Car car) {
        FixedRoute fixedRoute = navigator.buildRoutes(car);
        System.out.println(fixedRoute);
        System.out.println("---------------------");
        return fixedRoute;
    }
}