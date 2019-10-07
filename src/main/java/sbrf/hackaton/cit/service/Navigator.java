package sbrf.hackaton.cit.service;

import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.domain.atm.Atm;
import sbrf.hackaton.cit.domain.route.Route;
import sbrf.hackaton.cit.graph.RoadExplorer;

import java.util.List;

public class Navigator {

    public List<Route> buildRoutes(Atm start, Atm destination, Car car) {
        RoadExplorer roadExplorer = new RoadExplorer(destination, car);
        Route route;
        do {
            roadExplorer.routeSearch(start);
            route = roadExplorer.getBestRouts().orElse(null);
            if (route != null) {
                car.visitRoute(route);
            }

        } while (route != null);
        return car.getCompleteRoutes();
    }
}
