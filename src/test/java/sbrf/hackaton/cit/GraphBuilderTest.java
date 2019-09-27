package sbrf.hackaton.cit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Road;

import java.util.TreeMap;

/**
 * Created by Komyshenets on 25.09.2019.
 */
class GraphBuilderTest extends GraphTest {

    @Test
    void addEdgeTest() {
        TreeMap<Object, Atm> atmTreeMap = getVertex();
        Graph<Road, Atm> graph = getGraph(atmTreeMap);

        System.out.println(graph);

        for (Road edge : graph.getEdges()) {
            Assert.assertNotNull(edge.getLeft());
            Assert.assertNotNull(edge.getRight());
        }

    }

}