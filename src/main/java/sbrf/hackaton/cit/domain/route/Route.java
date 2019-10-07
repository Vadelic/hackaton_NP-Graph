package sbrf.hackaton.cit.domain.route;

import sbrf.hackaton.cit.domain.atm.Atm;
import sbrf.hackaton.cit.domain.road.Road;

import java.util.LinkedList;
import java.util.Objects;
import java.util.StringJoiner;

public class Route {
    final LinkedList<Atm> currentATMs = new LinkedList<>();
    final LinkedList<Road> currentRoads = new LinkedList<>();


    public double getRoadValue() {
        return currentRoads.stream()
                .map(Road::getDistance).mapToDouble(Double::intValue).sum();
    }


    public double getAtmValue() {
        return currentATMs.stream().distinct().filter(atm -> !atm.isVisited()).map(Atm::getMoney).mapToDouble(Double::intValue).sum();
    }

    public void removeLastDestination() {
        currentATMs.removeLast();
        if (!currentRoads.isEmpty())
            currentRoads.removeLast();
    }

    public void addDestination(Road road, Atm atm) {
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

    public int getCountPoint() {
        return currentATMs.size();
    }

    public boolean containsAtm(Atm targetAtm) {
        return currentATMs.contains(targetAtm);
    }


    public double getCost() {
        double atmValue = getAtmValue();
        double roadValue = getRoadValue();
        return atmValue / roadValue;
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
}
