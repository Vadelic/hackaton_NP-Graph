package sbrf.hackaton.cit.domain.route;

import sbrf.hackaton.cit.api.Edge;
import sbrf.hackaton.cit.api.Route;
import sbrf.hackaton.cit.api.Vertex;

import java.util.LinkedList;
import java.util.Objects;
import java.util.StringJoiner;

public class DynamicRoute implements Route {
    final LinkedList<Vertex> currentATMs = new LinkedList<>();
    final LinkedList<Edge> currentRoads = new LinkedList<>();


    public double getRoadValue() {
        return currentRoads.stream()
                .map(Edge::getDistance).mapToDouble(Double::intValue).sum();
    }


    public double getAtmValue() {
        return currentATMs.stream().distinct().filter(atm -> !atm.isVisited()).map(Vertex::getValue).mapToDouble(Double::intValue).sum();
    }

    public void removeLastDestination() {
        currentATMs.removeLast();
        if (!currentRoads.isEmpty())
            currentRoads.removeLast();
    }

    public void addDestination(Edge road, Vertex atm) {
        addRoad(road);
        addAtm(atm);
    }

    private void addRoad(Edge road) {
        if (road != null)
            currentRoads.addLast(road);
    }

    private void addAtm(Vertex atm) {
        currentATMs.addLast(atm);
    }

    public int getCountPoint() {
        return currentATMs.size();
    }

    public boolean containsAtm(Vertex targetAtm) {
        return currentATMs.contains(targetAtm);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicRoute route = (DynamicRoute) o;
        return currentATMs.equals(route.currentATMs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentATMs);
    }

    @Override
    public String toString() {

        return new StringJoiner(", ", DynamicRoute.class.getSimpleName() + "[", "]")
                .add("points=" + currentATMs)
                .add("atm Value= " + getAtmValue())
                .add("road Value= " + getRoadValue())
                .add("k=" + getCost())
                .toString();
    }

    public void visit() {
        for (Vertex atm : currentATMs) {
            atm.visit();
        }
    }
}
