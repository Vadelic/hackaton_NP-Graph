package sbrf.hackaton.cit.core;

import java.util.LinkedList;
import java.util.Objects;
import java.util.StringJoiner;

public class Route {
    public final LinkedList<Vertex> vertexes = new LinkedList<>();
    public final LinkedList<Edge> edges = new LinkedList<>();

    /**
     * Получить общий вес ребер на маршруте.
     * Первый шаг считаем по реальному трафику а остальные по максимальному
     */
    public double getEdgesValue() {
        double sum = 0;

        for (int i = 0; i < edges.size(); i++) {
            if (i == 0)
                sum += edges.get(i).getDistanceWithTraffic();
            else
                sum += edges.get(i).getDistanceWithHigherTraffic();

        }
        return sum;
    }

    public double getFinalEdgeValue() {
        try {
            return vertexes.getLast().getFinalRoute().getEdge().getDistanceWithHigherTraffic();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Получить общий вес вершин на маршруте
     */
    public double getVertexValue() {
        return vertexes.stream()
                .distinct()
//                .filter(vert -> !vert.isVisited())
                .mapToDouble(Vertex::getValue)
                .sum();
    }

    void addDestination(Edge road, Vertex vert) {
        if (road != null)
            edges.addLast(road);
        vertexes.addLast(vert);
    }

    void removeLastDestination() {
        vertexes.removeLast();
        if (!edges.isEmpty())
            edges.removeLast();
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

    /**
     * Стоимость данного маршрута с уч>том финального маршрута
     */
    public double getCost() {
        double vertValue = getVertexValue();
        double edgeValue = getEdgesValue() + getFinalEdgeValue();
        return vertValue / edgeValue;
    }


}
