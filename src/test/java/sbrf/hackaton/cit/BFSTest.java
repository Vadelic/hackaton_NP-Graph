package sbrf.hackaton.cit;

import org.junit.jupiter.api.Test;
import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Road;

import java.util.TreeMap;

class BFSTest extends GraphTest {

    @Test
    void search() {
        Graph<Road, Atm> graph = getRoadAtmGraph();
        System.out.println(graph);

        Atm rootNode = graph.getVertexes().iterator().next();

        new BFS().search(rootNode);
    }

    @Test
    void searchWithMarkerTest() {
        Graph<Road, Atm> graph = getRoadAtmGraph();
        System.out.println(graph);

        Atm rootNode = graph.getVertexes().iterator().next();

        new BFS().weight(rootNode);
    }
}