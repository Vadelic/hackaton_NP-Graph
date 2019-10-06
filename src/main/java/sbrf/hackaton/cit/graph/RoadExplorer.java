package sbrf.hackaton.cit.graph;

import com.sun.istack.internal.Nullable;
import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Car;
import sbrf.hackaton.cit.domain.Route;
import sbrf.hackaton.cit.domain.road.Road;

import java.util.*;

/**
 * Created by Komyshenets on 28.09.2019.
 */
public class RoadExplorer {
    private final Atm destinationPoint;
    private final Car car;
    private final List<Route> fixedRoutes = new LinkedList<>();

    public RoadExplorer(Atm destinationPoint, Car car) {
        this.destinationPoint = destinationPoint;
        this.car = car;
    }

    public void routeSearch(Atm startPoint) {
        fixedRoutes.clear();
        routeSearch(null, startPoint);
    }

    private void routeSearch(@Nullable Road road, Atm atm) {
        car.goToPoint(road, atm);
        if (!car.justStarted() && atm.equals(destinationPoint)) {
            //We arrived at destination
            Route route = car.fixRoute();
            fixedRoutes.add(route);
        } else {
            Map<Road, Atm> possibleRoutes = atm.getPossibleRoutes();
            for (Map.Entry<Road, Atm> entry : possibleRoutes.entrySet()) {
                Atm targetAtm = entry.getValue();
                Road targetRoad = entry.getKey();
                if (car.availableRoot(targetRoad, targetAtm)) {
                    routeSearch(targetRoad, targetAtm);
                }
            }
        }
        car.removePointAndRoad();
    }
    public List<Route> getAllAvailableRouts() {
        return fixedRoutes;
    }

    public Optional<Route> getBestRouts() {
        return fixedRoutes.stream().max(Comparator.comparingDouble(Route::getCost));
    }
}
