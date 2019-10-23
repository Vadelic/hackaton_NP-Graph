package sbrf.hackaton.cit;

import java.util.Random;
import java.util.function.Function;

public class MatrixGenerator {

    private final int size;
    private Random random = new Random();

    public MatrixGenerator(int size) {
        this.size = size;
    }

    public double[] vertexValue(int maxVal) {
        return vertex(maxVal, integer -> 1 + random.nextDouble() * integer);
    }

    public double[] vertexValueRound(int maxVal) {
        return vertex(maxVal, integer -> (double) 1 + Math.round(random.nextDouble() * integer));
    }

    public double[][] edgesValue(int maxVal) {
        return edges(maxVal, integer -> 1 + random.nextDouble() * integer);
    }

    public double[][] edgesValueRound(int maxVal) {
        return edges(maxVal, integer -> 1 + (double) Math.round(random.nextDouble() * integer));
    }

    private double[] vertex(int maxVal, Function<Integer, Double> random) {
        double[] vertexes = new double[size];
        for (int i = 0; i < size; i++) {
            vertexes[i] = random.apply(maxVal);
        }

        return vertexes;
    }

    private double[][] edges(int maxVal, Function<Integer, Double> random) {
        double[][] edges = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                double v = random.apply(maxVal);
                edges[i][j] = v;
                edges[j][i] = v;
            }
        }

        return edges;
    }
}
