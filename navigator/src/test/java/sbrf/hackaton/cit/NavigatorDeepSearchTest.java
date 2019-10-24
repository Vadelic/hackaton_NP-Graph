package sbrf.hackaton.cit;

import org.junit.Before;
import org.junit.Test;
import sbrf.hackaton.cit.core.FixedRoute;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.explorer.DfsExplorer;

import java.io.File;
import java.io.IOException;

public class NavigatorDeepSearchTest {

    Navigator navigator;
    GraphContext graphContext;

    @Before
    public void init() throws IOException {
        File file = new File("/Users/admin/IdeaProjects/GraphAPI/navigator/src/test/java/sbrf/hackaton/cit/dataLO");

        graphContext = new GraphContext(file);
        graphContext.setOutPoint(4);
        navigator = new Navigator(graphContext);
        System.out.println(graphContext);
    }

    @Test
    public void getRoads() {

        Car car = navigator.getCar(480, 5000, 0, c -> new DfsExplorer(c));

        System.out.println("CAR0 " + car);
        do {
            FixedRoute fixedRoute = doStep(car);
        } while (!car.atFinish());


    }

    private FixedRoute doStep(Car car) {
        FixedRoute fixedRoute = navigator.buildRoutes(car);
        System.out.println("\n---------------------");
        System.out.println(fixedRoute);
        System.out.println("CAR1 " + car);
        System.out.println("---------------------");
        return fixedRoute;
    }
}