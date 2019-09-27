package sbrf.hackaton.cit;

import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Road;

import java.util.TreeMap;

public class GraphTest {
    TreeMap<Object, Atm> getVertex() {
        TreeMap<Object, Atm> vertexes = new TreeMap<>();
        for (int i = 1; i <= 10; i++) {
            vertexes.put(i, new Atm(i));
        }
        return vertexes;
    }

    protected Graph<Road, Atm> getGraph(TreeMap<Object, Atm> atmTreeMap) {
        Graph<Road, Atm> graph = new Graph<>(atmTreeMap);

        graph.addEdge(1, new Road(3), 3);
        graph.addEdge(1, new Road(1), 4);
        graph.addEdge(1, new Road(4), 2);
        graph.addEdge(2, new Road(3), 5);
        graph.addEdge(2, new Road(6), 4);
        graph.addEdge(4, new Road(14), 7);
        graph.addEdge(5, new Road(11), 8);
        graph.addEdge(8, new Road(4), 6);
        graph.addEdge(6, new Road(2), 9);
        graph.addEdge(7, new Road(1), 9);
        graph.addEdge(4, new Road(8), 6);
        graph.addEdge(7, new Road(2), 6);
        graph.addEdge(8, new Road(3), 10);
        graph.addEdge(8, new Road(6), 9);
        return graph;
    }

    Graph<Road, Atm> getRoadAtmGraph() {
        TreeMap<Object, Atm> vertex = getVertex();
        return getGraph(vertex);
    }
}
