package sbrf.hackaton.cit.graph;

import sbrf.hackaton.cit.api.Edge;
import sbrf.hackaton.cit.api.Vertex;
import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Road;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringJoiner;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public class Graph<E extends Edge, V extends Vertex> {
    Atm[] vertexes;
    Road[] edges;

    public Graph(int[] vertex, int[][] edges) {
        this.vertexes = getVertex(vertex);
        this.edges = getRoads(edges, vertexes);
    }

    private Road[] getRoads(int[][] mx, Atm[] vertex) {
        LinkedList<Road> roads = new LinkedList<>();
        int length = mx.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (mx[i][j] != 0) {
                    Road road = createRoad(mx[i][j], mx[j][i], vertex[i], vertex[j]);
                    roads.add(road);
                }
            }
        }
        return roads.toArray(new Road[0]);
    }

    private Road createRoad(int lenL, int lenR, Atm vertexA, Atm vertexB) {
        Road road = new Road(lenL);
        road.addVertex(vertexA, vertexB);
        return road;
    }

    private Atm[] getVertex(int[] vx) {
        ArrayList<Atm> vertexes = new ArrayList<>();
        for (int value : vx) {
            vertexes.add(new Atm(value));
        }
        return vertexes.toArray(new Atm[0]);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Graph.class.getSimpleName() + "[", "]")
                .add("\nvertexes=" + Arrays.toString(vertexes))
                .add("\nedges=" + Arrays.toString(edges))
                .toString();
    }

    public Atm getRootVertex(int i) {
        return vertexes[i];
    }
}
