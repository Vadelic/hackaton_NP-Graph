package sbrf.hackaton.cit;

import org.junit.Before;
import org.junit.Test;
import sbrf.hackaton.cit.core.FixedRoute;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.explorer.BfsExplorer;
import sbrf.hackaton.cit.service.GraphTest;

public class NavigatorGenTest extends GraphTest {

    Navigator navigator;
    GraphContext graphContext;

    //    @Before
    public void init() {
        MatrixGenerator generator = new MatrixGenerator(100);
        graphContext = new GraphContext(generator.vertexValueRound(20), generator.edgesValueRound(15));
        graphContext.setOutPoint(5);
        navigator = new Navigator(graphContext);
        System.out.println(graphContext);
    }

    @Before
    public void initSimpleGraph() {
        graphContext = new GraphContext(vertexes, fullEdges);
        graphContext.setOutPoint(5);
        navigator = new Navigator(graphContext);
        System.out.println(graphContext);
    }

    @Test
    public void getRoads() {

        Car car = graphContext.getCar(10, 15, 0, BfsExplorer::new);
        FixedRoute fixedRoute = navigator.buildRoutes(car);
//        FixedRoute fixedRoute = doStep(car);
//        System.out.println("CAR1" + car);
//        System.out.println("CAR1" + car);
//        fixedRoute = doStep(car);
//        System.out.println("CAR2" + car);
//        fixedRoute = doStep(car);
//        System.out.println("CAR3" + car);

    }

    private FixedRoute doStep(Car car) {
        FixedRoute fixedRoute = navigator.buildRoutes(car);
        System.out.println(fixedRoute);
        System.out.println("---------------------");
        return fixedRoute;
    }
}