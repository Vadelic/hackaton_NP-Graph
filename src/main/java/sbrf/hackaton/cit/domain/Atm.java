package sbrf.hackaton.cit.domain;

import java.util.*;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public class Atm {
    private static int count =0;
    private final int index;
    private Set<Road> roads = new HashSet<>();
    private int value;


    public Atm(int value) {
        this.value = value;
        index=++count;
    }

    int getMoney() {
        return value;
    }


    void addRoad(Road road) {
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
    public String toString() {
        return index +" ("+ value +")";
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
}
