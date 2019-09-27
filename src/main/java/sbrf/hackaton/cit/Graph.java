package sbrf.hackaton.cit;

import sbrf.hackaton.cit.api.Edge;
import sbrf.hackaton.cit.api.Vertex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public class Graph<E extends Edge,V extends Vertex> {
    final private Map<Object, V> vertexes;
    final private ArrayList<E> edges = new ArrayList<>();

    public Graph(Map<Object, V> vertexes) {
        this.vertexes = vertexes;
    }


    public Graph addEdge(Object leftId, E edge, Object rightId) {
        edges.add(edge);

        toLinkVertexEdges(leftId, edge, rightId);
        return this;
    }

    private void toLinkVertexEdges(Object leftId, E edge, Object rightId) {
        V left = vertex(leftId);
        V right = vertex(rightId);
        edge.addVertex(left, right);
    }

    private V vertex(Object id) {
        return vertexes.get(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Graph.class.getSimpleName() + "[", "]")
                .add("\nvertexes=" + vertexes)
                .add("\nedges=" + edges)
                .toString();
    }

    public Collection<V> getVertexes() {
        return vertexes.values();
    }

    public ArrayList<E> getEdges() {
        return edges;
    }
}
