package sbrf.hackaton.cit.domain.atm;

import sbrf.hackaton.cit.domain.road.Road;

import java.util.*;

public abstract class Atm {
    private static int count = 0;
    final int index;
    private Set<Road> roads = new HashSet<>();
    private boolean visit = false;

    public Atm() {
        index = ++count;
    }

    public void addRoad(Road road) {
        roads.add(road);
    }

    public Set<Road> getRoads() {
        return roads;
    }

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

    public abstract double getMoney();


}
