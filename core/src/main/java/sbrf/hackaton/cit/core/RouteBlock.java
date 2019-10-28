package sbrf.hackaton.cit.core;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class RouteBlock<E extends Edge, V extends Vertex> {
    private final E edge;
    private final V vertex;

    public RouteBlock(E edge, V vertex) {
        this.edge = edge;
        this.vertex = vertex;
    }

    public E getEdge() {
        return edge;
    }

    public V getVertex() {
        return vertex;
    }

    public List<RouteBlock> getPossibleDirections() {
        return vertex.getPossibleRoutes();
    }

    public RouteBlock<E, V> getFinalBlock() {
        return vertex.getFinalBlock();
    }

    public double getDistanceWithTraffic() {
        return edge == null ? 0 : edge.getDistanceWithTraffic();
    }

    public double getDistanceWithHigherTraffic() {
        return edge == null ? 0 : edge.getDistanceWithHigherTraffic();
    }

    public Double getCost() {
        double distanceWithHigherTraffic = getDistanceWithHigherTraffic();
        if (distanceWithHigherTraffic == 0)
            return 0.0;
        else
            return vertex.getValue() / distanceWithHigherTraffic;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "Block[", "]")
                .add("edge=" + edge)
                .add("vert=" + vertex)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteBlock<?, ?> that = (RouteBlock<?, ?>) o;
        return Objects.equals(edge, that.edge) &&
                Objects.equals(vertex, that.vertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(edge, vertex);
    }

    public double priority() {
        return vertex.priority();
    }
}
