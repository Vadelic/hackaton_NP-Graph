package sbrf.hackaton.cit.domain;


import sbrf.hackaton.cit.api.Vertex;
import sbrf.hackaton.cit.domain.road.Road;

import java.util.*;

public class Atm implements Vertex {
    private static int count = 0;
    private final int index;
    private Set<Road> roads = new HashSet<>();
    private boolean visit = false;
    private double value;

    public Atm(double value) {
        this.value = value;
        index = ++count;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return index + " (" + value + ")";
    }


    public void addRoad(Road road) {
        roads.add(road);
    }

    public Set<Road> getRoads() {
        return roads;
    }

    @Override
    public Map<Road, Atm> getPossibleRoutes() {
        HashMap<Road, Atm> vertexHashMap = new HashMap<>();
        for (Road road : roads) {
            Atm target = road.getTarget(this);
            if (Objects.nonNull(target)) {
                vertexHashMap.put(road, target);
            }
        }
        return vertexHashMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atm atm = (Atm) o;
        return index == atm.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }


    public void visit() {
        visit = true;
    }

    public boolean isVisited() {
        return visit;
    }


}
