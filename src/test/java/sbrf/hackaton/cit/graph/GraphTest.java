package sbrf.hackaton.cit.graph;

import org.junit.jupiter.api.Test;
import sbrf.hackaton.cit.api.Edge;
import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Road;

import java.util.Set;

/**
 * Created by Komyshenets on 28.09.2019.
 */
class GraphTest {
    private static int[] vx = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int[][] ex = {
            {0, 4, 3, 1, 0, 0, 0, 0, 0, 0},
            {4, 0, 0, 6, 3, 0, 0, 0, 0, 0},
            {3, 0, 0, 0, 10, 0, 0, 0, 0, 0},
            {1, 6, 0, 0, 0, 8, 14, 0, 0, 0},
            {0, 3, 10, 0, 0, 0, 0, 11, 0, 0},
            {0, 0, 0, 8, 0, 0, 2, 4, 0, 0},
            {0, 0, 0, 14, 0, 2, 0, 0, 1, 0},
            {0, 0, 0, 0, 11, 4, 0, 0, 6, 3},
            {0, 0, 0, 0, 0, 0, 1, 6, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 3, 0, 0}
    };

    @Test
    void Constructor() {
        Graph<Road, Atm> roadAtmGraph = new Graph<>(vx, ex);
        System.out.println(roadAtmGraph);

        Atm rootVertex = roadAtmGraph.getRootVertex(0);
        System.out.println(rootVertex);
        Set<Edge> edges = rootVertex.getEdges();
        System.out.println(edges);
    }
}