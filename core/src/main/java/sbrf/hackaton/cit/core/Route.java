package sbrf.hackaton.cit.core;

import java.util.LinkedList;
import java.util.Objects;
import java.util.StringJoiner;

public class Route implements Cloneable {
    //    public final LinkedList<Vertex> vertexes = new LinkedList<>();
//    public final LinkedList<Edge> edges = new LinkedList<>();
    public final LinkedList<RouteBlock<Edge, Vertex>> blocks = new LinkedList<>();

    /**
     * Получить общий вес ребер на маршруте.
     * Первый шаг считаем по реальному трафику а остальные по максимальному
     */
    public double getEdgesValue() {
        double sum = 0;

        for (int i = 0; i < blocks.size(); i++) {
            if (i == 1)
                sum += blocks.get(i).getDistanceWithTraffic();
            else
                sum += blocks.get(i).getDistanceWithHigherTraffic();

        }
        return sum;
    }

    public double getFinalEdgeValue() {
        try {
            return blocks.getLast().getFinalBlock().getEdge().getDistanceWithHigherTraffic();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Получить общий вес вершин на маршруте
     */
    public double getVertexValue() {
        return blocks.stream()
                .distinct()
                .map(RouteBlock::getVertex)
                .mapToDouble(Vertex::getValue)
                .sum();
    }

    public void addDestination(RouteBlock block) {
        blocks.addLast(block);
    }

    void removeLastDestination() {
        if (!blocks.isEmpty())
            blocks.removeLast();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return blocks.equals(route.blocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blocks);
    }

    @Override
    public String toString() {

        return new StringJoiner(", ", Route.class.getSimpleName() + "[", "]")
                .add("points=" + blocks)
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


    public double usedVolume() {
        // TODO: 24/10/2019 как это считать?
        return blocks.stream().map(RouteBlock::getVertex).distinct().mapToDouble(Vertex::getValue).skip(1).sum();
    }
}
