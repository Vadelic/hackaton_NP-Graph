package sbrf.hackaton.cit.api;

import java.util.LinkedList;
import java.util.Objects;
import java.util.StringJoiner;

public class Route {
    public final LinkedList<Vertex> vertexes = new LinkedList<>();
    public final LinkedList<Edge> edges = new LinkedList<>();

    /**
     * Получить общий вес ребер на маршруте
     */
    public double getEdgesValue() {
        return edges.stream()
                .map(Edge::getDistance).mapToDouble(Double::intValue).sum();
    }

    /**
     * Получить общий вес вершин на маршруте
     */
    public double getVertexValue() {
        return vertexes.stream().distinct().filter(atm -> !atm.isVisited()).map(Vertex::getValue).mapToDouble(Double::intValue).sum();
    }

    void removeLastDestination() {
        vertexes.removeLast();
        if (!edges.isEmpty())
            edges.removeLast();
    }

    void addDestination(Edge road, Vertex atm) {
        if (road != null)
            edges.addLast(road);

        vertexes.addLast(atm);
    }


    int getCountPoint() {
        return vertexes.size();
    }

    boolean containsAtm(Vertex targetAtm) {
        return vertexes.contains(targetAtm);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return vertexes.equals(route.vertexes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexes);
    }

    @Override
    public String toString() {

        return new StringJoiner(", ", Route.class.getSimpleName() + "[", "]")
                .add("points=" + vertexes)
                .add("vertex:" + getVertexValue())
                .add("edge:" + getEdgesValue())
                .add("cost:" + getCost())
                .toString();
    }

    void visit() {
        for (Vertex atm : vertexes) {
            atm.visit();
        }
    }

    /**
     * Стоимость данного маршрута
     */
    public double getCost() {
        double atmValue = getVertexValue();
        double roadValue = getEdgesValue();
        return atmValue / roadValue;
    }

}
