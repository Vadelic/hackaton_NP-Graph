package sbrf.hackaton.cit.service.impl;

import org.springframework.stereotype.Service;
import sbrf.hackaton.cit.GraphContext;
import sbrf.hackaton.cit.Navigator;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.explorer.DfsExplorer;
import sbrf.hackaton.cit.service.NavigatorService;
import sbrf.hackaton.cit.srv.data.MainResponseServer;
import sbrf.hackaton.cit.srv.data.PointsServer;
import sbrf.hackaton.cit.srv.data.RoutesServer;
import sbrf.hackaton.cit.srv.data.TrafficServer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    public String updateTraffic(TrafficServer traffic) {
        navigator.updateTraffic(traffic.getArray());
        if (Objects.isNull(traffic.car) || traffic.car.isEmpty()) {

        } else {
            Car car = cars.get(traffic.car);
            navigator.buildRoutes(car);
        }
        return null;
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
}
