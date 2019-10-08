package sbrf.hackaton.cit.domain;

import sbrf.hackaton.cit.api.Cursor;
import sbrf.hackaton.cit.api.Edge;
import sbrf.hackaton.cit.api.Vertex;
import sbrf.hackaton.cit.domain.route.DynamicRoute;
import sbrf.hackaton.cit.domain.route.FixedRoute;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Komyshenets on 29.09.2019.
 */
public class Car implements Cursor {
    private final DynamicRoute currentRoute = new DynamicRoute();

    private final int maximumTime;
    private final int maximumMoney;
    private final List<DynamicRoute> completeRoutes = new LinkedList<>();

    public Car(int time, int weight) {
        this.maximumTime = time;
        this.maximumMoney = weight;
    }

    @Override
    public FixedRoute fixRoute() {
        return new FixedRoute(currentRoute);
    }

    @Override
    public void goToPoint(Edge road, Vertex atm) {
        currentRoute.addDestination(road, atm);

    }


    @Override
    public void removePointAndRoad() {
        currentRoute.removeLastDestination();
    }

    @Override
    public boolean justStarted() {
        return currentRoute.getCountPoint() <= 1;
    }


    @Override

    public boolean availableRoot(Edge targetRoad, Vertex targetAtm) {
        return availableRoad(targetRoad) && availablePoint(targetAtm);
    }

    private boolean availablePoint(Vertex targetAtm) {
        double sum = currentRoute.getAtmValue();
        if (!currentRoute.containsAtm(targetAtm))
            sum += targetAtm.getValue();
        return sum <= maximumMoney;
    }

    private boolean availableRoad(Edge targetRoad) {
        double usedTime = completeRoutes.stream().mapToDouble(DynamicRoute::getRoadValue).sum();
        return currentRoute.getRoadValue() + targetRoad.getDistance() <= maximumTime - usedTime;
    }

    public void visitRoute(DynamicRoute bestRoute) {

        bestRoute.visit();
        completeRoutes.add(bestRoute);
    }

    public List<DynamicRoute> getCompleteRoutes() {
        return completeRoutes;
    }
}
