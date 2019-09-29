package sbrf.hackaton.cit.domain;

import java.util.*;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public class Atm {
    Set<Road> roads = new HashSet<>();
    public boolean visited = false;
    private int value;


    public Atm(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public int getMoney() {
        return value;
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
}
