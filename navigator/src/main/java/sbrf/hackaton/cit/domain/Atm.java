package sbrf.hackaton.cit.domain;


import sbrf.hackaton.cit.core.RouteBlock;
import sbrf.hackaton.cit.core.Vertex;

import java.util.*;

public class Atm implements Vertex {
    private static int count = 0;
    private final int index;
    private Set<Road> roads = new HashSet<>();
    private boolean visit = false;
    private double value;
    private boolean out = false;
    public AtmStatus status = AtmStatus.FREE;


    public Atm(double value) {
        this.value = value;
        index = ++count;
    }

    public boolean isOut() {
        return out;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    @Override
    public double getValue() {
        return out ? 0 : value;
    }

    @Override
    public String toString() {
        return "#" + index + "(" + getValue() + ")";
    }


    public void addRoad(Road road) {
        roads.add(road);
    }

    public Set<Road> getRoads() {
        return roads;
    }

    /**
     * @return Маршруты до других ВСП
     */
    @Override
    public List<RouteBlock> getPossibleRoutes() {
        List<RouteBlock> vertexHashMap = new ArrayList<>();
        for (Road road : roads) {
            Atm target = road.getTarget(this);
            if (Objects.nonNull(target) && !target.isOut()) {
                vertexHashMap.add(new RouteBlock<>(road, target));
            }
        }
        return vertexHashMap;
    }

    /**
     * @return маршрут до точки выгрузки
     */
    @Override
    public RouteBlock<Road, Atm> getFinalBlock() {
        for (Road road : roads) {
            Atm target = road.getTarget(this);
            if (Objects.nonNull(target) && target.isOut()) {
                return new RouteBlock<>(road, target);
            }
        }
        return null;
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


    public void setStatus(AtmStatus status) {
// TODO: 21/10/2019
        this.status = status;
    }

    public boolean isAvailable() {
        return this.status == AtmStatus.FREE;
    }
}
