package sbrf.hackaton.cit.service;


import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Road;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringJoiner;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public class GraphBuilder {
    private Atm[] vertexes;
    private Road[] edges;

    /**
     * Создает граф из матриц
     *
     * @param vertex Массив с весами вершин
     * @param edges  Массив с весами ребер
     */
    public GraphBuilder(double[] vertex, double[][] edges) {
        this.vertexes = createVertex(vertex);
        this.edges = binderVertexes(edges, vertexes);
    }

    /**
     * Обновляет значения ребер
     *
     * @param edges Массив с весами ребер
     */
    public void updateEdges(double[][] edges) {
        for (Atm vertex : vertexes) {
            vertex.cleanRoads();
        }
        this.edges = binderVertexes(edges, vertexes);
    }


    /**
     * Взять вершину по порядковому номеру
     */
    public Atm getRootVertex(int i) {
        return vertexes[i];
    }

    private Atm[] createVertex(double[] vx) {
        ArrayList<Atm> vertexes = new ArrayList<>();
        for (double value : vx) {
            vertexes.add(new Atm(value));
        }
        return vertexes.toArray(new Atm[0]);
    }

    private Road[] binderVertexes(double[][] mx, Atm[] vertex) {
        LinkedList<Road> roads = new LinkedList<>();
        int length = mx.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (mx[i][j] != 0 || mx[j][i] != 0) {
                    Road road = createRoad(mx[i][j], mx[j][i], vertex[i], vertex[j]);
                    roads.add(road);

                }
            }
        }
        return roads.toArray(new Road[0]);
    }

    private Road createRoad(double lenR, double lenL, Atm vertexA, Atm vertexB) {
        Road road;
        if (lenL == lenR) {
            road = new Road(vertexA, vertexB, lenL);
            vertexA.addRoad(road);
            vertexB.addRoad(road);
        } else if (lenL == 0) {
            road = new Road(vertexA, vertexB, lenR);
            vertexA.addRoad(road);
        } else {
            road = new Road(vertexA, vertexB, lenL);
            vertexB.addRoad(road);
        }
        return road;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GraphBuilder.class.getSimpleName() + "[", "]")
                .add("\nvertexes=" + Arrays.toString(vertexes))
                .add("\nedges=" + Arrays.toString(edges))
                .toString();
    }


}
