package sbrf.hackaton.cit.core;

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

    @Override
    public String toString() {
        return new StringJoiner(", ", "[", "]")
                .add("edge=" + edge)
                .toString();
    }
}
