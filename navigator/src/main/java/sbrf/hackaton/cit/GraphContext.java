package sbrf.hackaton.cit;


import sbrf.hackaton.cit.domain.Atm;
import sbrf.hackaton.cit.domain.Road;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Created by Komyshenets on 25.09.2019.
 */
public class GraphContext {
    private Atm[] vertexes;
    private Road[][] edges;


    /**
     * Создает граф из матриц
     *
     * @param vertex Массив с весами вершин
     * @param edges  Массив с весами ребер
     */
    public GraphContext(double[] vertex, double[][] edges) {
        this.vertexes = createVertex(vertex);
        this.edges = new Road[vertexes.length][vertexes.length];
        binderVertexes(edges, vertexes);

    }

    public void setOutPoint(int finishPoint) {
        vertexes[finishPoint].setOut(true);
    }

    /**
     * Обновляет значения ребер
     *
     * @param edges Массив с весами ребер
     */
    public void updateTraffic(double[][] edges) {
        int length = edges.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                this.edges[i][j].setTraffic(edges[i][j]);
            }
        }
    }

    /**
     * Взять вершину по порядковому номеру
     */
    public Atm getVertex(int i) {
        return vertexes[i];
    }

    private Atm[] createVertex(double[] vx) {
        ArrayList<Atm> vertexes = new ArrayList<>();
        for (double value : vx) {
            vertexes.add(new Atm(value));
        }
        return vertexes.toArray(new Atm[0]);
    }

    private void binderVertexes(double[][] mx, Atm[] vertex) {
        int length = mx.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {


                double max = Math.max(mx[i][j], mx[j][i]);
                if (max != 0) {
                    if (edges[i][j] == null) {
                        edges[i][j] = createRoad(mx[i][j], mx[j][i], vertex[i], vertex[j]);
                    } else
                        edges[i][j].setDistance(max);
                } else {
                    if (edges[i][j] != null) {
                        vertex[i].getRoads().remove(edges[i][j]);
                        vertex[j].getRoads().remove(edges[i][j]);
                        edges[i][j] = null;
                    }
                }

            }
        }

    }

    private Road createRoad(double lenR, double lenL, Atm vertexA, Atm vertexB) {
        Road road;
        if (lenL == 0 && lenR == 0) return null;
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
        return new StringJoiner(", ", GraphContext.class.getSimpleName() + "[", "]")
                .add("\nvertexes=" + Arrays.toString(vertexes))
//                .add("\nedges=" + Arrays.toString(edges))
                .toString();
    }


}
