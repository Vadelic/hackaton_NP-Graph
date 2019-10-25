package sbrf.hackaton.cit.service.impl;

import org.springframework.stereotype.Service;
import sbrf.hackaton.cit.GraphContext;
import sbrf.hackaton.cit.Navigator;
import sbrf.hackaton.cit.core.FixedRoute;
import sbrf.hackaton.cit.core.Vertex;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.explorer.DfsExplorer;
import sbrf.hackaton.cit.service.NavigatorService;
import sbrf.hackaton.cit.srv.data.MainResponseServer;
import sbrf.hackaton.cit.srv.data.PointsServer;
import sbrf.hackaton.cit.srv.data.RoutesServer;
import sbrf.hackaton.cit.srv.data.TrafficServer;

import java.util.*;

@Service
public class NavigatorServiceImpl implements NavigatorService {
    private static Navigator navigator = null;
    private MainResponseServer main = null;
    private PointsServer points = null;
    private RoutesServer routes = null;
    private Map<String, Car> cars = new HashMap<>();

    @Override
    public void createNavigator(MainResponseServer main) {
        this.main = main;
    }

    @Override
    public void createVertex(PointsServer points) {
        this.points = points;
        buildNavigator();
        carsBuilder();
    }

    @Override
    public void createRoads(RoutesServer routesServer) {
        this.routes = routesServer;
        buildNavigator();
        carsBuilder();
    }

    @Override
    public synchronized List<String> updateTraffic(TrafficServer traffic) {
        ArrayList<String> strings = new ArrayList<>();
        navigator.updateTraffic(traffic.getArray());
        if (Objects.isNull(traffic.car) || traffic.car.isEmpty()) {
            for (Car car : cars.values()) {
                strings.add(getFixedRouteJSON(car));
            }
        } else {
            Car car = cars.get(traffic.car);
            strings.add(getFixedRouteJSON(car));
        }
        return strings;
    }

    private String getFixedRouteJSON(Car car) {
        FixedRoute fixedRoute = navigator.buildRoutes(car);
        Vertex vertex = fixedRoute.getFirstDestination().getVertex();
        return String.format("{\"goto\": %s, \"car\": \"%s\"}", vertex.getName(), car.name);
    }

    private void buildNavigator() {
        if (Objects.isNull(navigator) && Objects.nonNull(points) && Objects.nonNull(routes)) {
            GraphContext graphContext = new GraphContext(points.getArray(), routes.getArray());
            graphContext.setOutPoint(1);
            navigator = new Navigator(graphContext);
        }

    }

    private void carsBuilder() {
        if (Objects.nonNull(navigator) && Objects.nonNull(main)) {
            cars.clear();
            for (String carName : main.cars) {
                Car car = navigator.getCar(carName, 480, 1000000, 0, c -> new DfsExplorer(c, 3));
                cars.put(carName, car);
            }
        }
    }

    public boolean checkAvailable() {
        return this.main != null && !this.cars.isEmpty() && this.points != null && this.routes != null;

    }

}
