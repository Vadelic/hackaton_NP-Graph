package sbrf.hackaton.cit;

import org.junit.Before;
import org.junit.Test;
import sbrf.hackaton.cit.core.FixedRoute;
import sbrf.hackaton.cit.core.RouteBlock;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.explorer.DfsExplorer;

import java.io.File;
import java.io.IOException;

public class NavigatorDeepSearchTest {

    Navigator navigator;

    @Before
    public void init() throws IOException {
        GraphContext graphContext = new GraphContext(new File("/Users/admin/IdeaProjects/GraphAPI/navigator/src/test/java/sbrf/hackaton/cit/data"));
        graphContext.setOutPoint(599);
        navigator = new Navigator(graphContext);
//        System.out.println(graphContext);
    }

    @Test

    public void getRoads() {

        Car car = navigator.getCar("car1", 500, 100, 0, c -> new DfsExplorer(c, 3));
        Car car2 = navigator.getCar("car2", 500, 100, 0, c -> new DfsExplorer(c, 3));
        Car car3 = navigator.getCar("car3", 500, 100, 0, c -> new DfsExplorer(c, 3));
        Object vertex;
        do {
            vertex = doStep(car);
        } while (vertex != null);

    }

    private RouteBlock doStep(Car car) {

        FixedRoute fixedRoute = navigator.buildRoutes(car);
//        System.out.println(fixedRoute);
        System.out.println("CAR1 " + car);
        System.out.println("---------------------");
        return fixedRoute == null ? null : fixedRoute.getFirstDestination();
    }
}