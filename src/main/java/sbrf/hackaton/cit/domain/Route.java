package sbrf.hackaton.cit.domain;

import sbrf.hackaton.cit.domain.road.Road;

import java.util.LinkedList;
import java.util.Objects;
import java.util.StringJoiner;

public class Route{
    final LinkedList<Atm> currentATMs = new LinkedList<>();
    final LinkedList<Road> currentRoads = new LinkedList<>();




    int getRoadValue() {
        return currentRoads.stream()
                .map(Road::getDistance).mapToInt(Integer::intValue).sum();
    }


    int getAtmValue() {
        return currentATMs.stream().distinct().filter(atm -> !atm.isVisited()).map(Atm::getMoney).mapToInt(Integer::intValue).sum();
    }

    void removeLastDestination() {
        currentATMs.removeLast();
        if (!currentRoads.isEmpty())
            currentRoads.removeLast();
    }

    void addDestination(Road road, Atm atm) {
        addRoad(road);
        addAtm(atm);
    }

    private void addRoad(Road road) {
        if (road != null)
            currentRoads.addLast(road);
    }

    private void addAtm(Atm atm) {
        currentATMs.addLast(atm);
    }

    int getCountPoint() {
        return currentATMs.size();
    }

    boolean containsAtm(Atm targetAtm) {
        return currentATMs.contains(targetAtm);
    }


    public double getCost() {
        int atmValue = getAtmValue();
        int roadValue = getRoadValue();
        return atmValue*1.0/roadValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return currentATMs.equals(route.currentATMs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentATMs);
    }

    @Override
    public String toString() {

        return new StringJoiner(", ", Route.class.getSimpleName() + "[", "]")
                .add("points=" + currentATMs)
                .add("atm Value= " + getAtmValue())
                .add("road Value= " + getRoadValue())
                .add("k=" + getCost())
                .toString();
    }

    public void visit() {
        for (Atm atm : currentATMs) {
            atm.visit();
        }
    }

    public Route fix() {
        Route route = new Route();
        route.currentATMs.addAll(currentATMs);
        route.currentRoads.addAll(currentRoads);
        return route;
    }
}
