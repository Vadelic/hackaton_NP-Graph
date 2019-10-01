package sbrf.hackaton.cit.domain;

import java.util.LinkedList;
import java.util.Objects;
import java.util.StringJoiner;

public class Route implements Cloneable{
    private final LinkedList<Atm> currentPath = new LinkedList<>();
    private final LinkedList<Road> currentRoads = new LinkedList<>();


    int getRoadValue() {
        return currentRoads.stream()
                .map(Road::getDistance).mapToInt(Integer::intValue).sum();
    }


    int getAtmValue() {
        return currentPath.stream().distinct().map(Atm::getMoney).mapToInt(Integer::intValue).sum();
    }

    void removeLastDestination() {
        currentPath.removeLast();
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
        currentPath.addLast(atm);
    }

    int getCountPoint() {
        return currentPath.size();
    }

    boolean containsAtm(Atm targetAtm) {
        return currentPath.contains(targetAtm);
    }

    @Override
    protected Route clone() {

        Route route = new Route();
        route.currentPath.addAll(currentPath);
        route.currentRoads.addAll(currentRoads);
        return route;
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
        return currentPath.equals(route.currentPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPath);
    }

    @Override
    public String toString() {

        return new StringJoiner(", ", Route.class.getSimpleName() + "[", "]")
                .add("points=" + currentPath)
                .add("atm Value= " + getAtmValue())
                .add("road Value= " + getRoadValue())
                .add("k=" + getCost())
                .toString();
    }

}
