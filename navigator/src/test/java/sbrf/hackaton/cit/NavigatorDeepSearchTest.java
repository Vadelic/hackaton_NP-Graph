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
        MatrixGenerator generator = new MatrixGenerator(600);
        File file = new File("/Users/admin/IdeaProjects/GraphAPI/navigator/src/test/java/sbrf/hackaton/cit/data");

        graphContext = new GraphContext(file);
        graphContext.setOutPoint(599);
        navigator = new Navigator(graphContext);
//        System.out.println(graphContext);
    }

    @Test
    public void getRoads() {

        Car car = navigator.getCar("car1", 500, 100, 0, c -> new DfsExplorer(c, 3));
        Car car2 = navigator.getCar("car2", 500, 100, 0, c -> new DfsExplorer(c, 3));
        Car car3 = navigator.getCar("car3", 500, 100, 0, c -> new DfsExplorer(c, 3));

        do {
            if (!car.atFinish()) doStep(car);
            if (!car2.atFinish()) doStep(car2);
            if (!car3.atFinish()) doStep(car3);
        } while (!car.atFinish() && !car2.atFinish() && !car3.atFinish());

    }

    private FixedRoute doStep(Car car) {
        FixedRoute fixedRoute = navigator.buildRoutes(car);
//        System.out.println(fixedRoute);
        System.out.println("CAR1 " + car);
        System.out.println("---------------------");
        return fixedRoute;
    }
}