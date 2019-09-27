package sbrf.hackaton.cit.api;

import java.util.*;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public abstract class Vertex {
    private boolean visit = false;
    Set<Edge> edges = new HashSet<>();
//
//    public Vertex(Object value) {
//        this.value = value;
//    }
//
//    final Object value;

    public void addEdge(Edge edge) {
        edges.add(edge);
    }


    public Set<Edge> getEdges() {
        return edges;
    }

    public void visit() {
        visit = true;
    }

    public boolean isVisited() {
        return visit;
    }

    public Map<Vertex, Object> getTargetNodes() {
        HashMap<Vertex, Object> vertexHashMap = new HashMap<>();
        for (Edge edge : edges) {
            Vertex target = edge.getTarget(this);
            if (Objects.nonNull(target)) {
                vertexHashMap.put(target, edge.getValue());
            }
        }
        return vertexHashMap;
    }

    public abstract Object marker();
}
