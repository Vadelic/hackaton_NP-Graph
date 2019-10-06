package sbrf.hackaton.cit.domain;

import sbrf.hackaton.cit.domain.road.Road;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Komyshenets on 29.09.2019.
 */
public class Car {
    private final Route currentRoute = new Route();

    private final int maximumTime;
    private final int maximumMoney;
    private final List<Route> completeRoutes = new LinkedList<>();

    public Car(int time, int weight) {
        this.maximumTime = time;
        this.maximumMoney = weight;
    }

    public FixedRoute fixRoute() {
        //We arrived at destination
        return new FixedRoute(currentRoute);
    }

    public void goToPoint(Road road, Atm atm) {
        currentRoute.addDestination(road, atm);
    }


    public void removePointAndRoad() {
        currentRoute.removeLastDestination();
    }

    public boolean justStarted() {
        return currentRoute.getCountPoint() <= 1;
    }

    public boolean availableRoot(Road targetRoad, Atm targetAtm) {
        return availableRoad(targetRoad) && availablePoint(targetAtm);
    }

    private boolean availablePoint(Atm targetAtm) {
        int sum = currentRoute.getAtmValue();
        if (!currentRoute.containsAtm(targetAtm))
            sum += targetAtm.getMoney();
        return sum <= maximumMoney;
    }

    private boolean availableRoad(Road targetRoad) {
        int usedTime = completeRoutes.stream().mapToInt(Route::getRoadValue).sum();
        return currentRoute.getRoadValue() + targetRoad.getDistance() <= maximumTime - usedTime;
    }

    public void visitRoute(Route bestRoute) {
        bestRoute.visit();
        completeRoutes.add(bestRoute);
    }

    public List<Route> getCompleteRoutes() {
        return completeRoutes;
    }
}
