package sbrf.hackaton.cit;

import java.util.Random;
import java.util.function.Function;

public class MatrixGenerator {

    private final int count;
    private Random random = new Random();

    public MatrixGenerator(int count) {
        this.count = count;
    }

    public double[] vertexValue(int maxVal) {
        return vertex(maxVal, integer -> random.nextDouble() * integer);
    }

    public double[] vertexValueRound(int maxVal) {
        return vertex(maxVal, integer -> (double) Math.round(random.nextDouble() * integer));
    }

    private double[] vertex(int maxVal, Function<Integer, Double> random) {
        double[] vertexes = new double[count];
        for (int i = 0; i < count; i++) {
            vertexes[i] = random.apply(maxVal);
        }

        return vertexes;
    }

    public double[][] edgesValue(int maxVal) {
        return edges(maxVal, integer -> random.nextDouble() * integer);
    }

    public double[][] edgesValueRound(int maxVal) {
        return edges(maxVal, integer -> (double) Math.round(random.nextDouble() * integer));
    }

    private double[][] edges(int maxVal, Function<Integer, Double> random) {
        double[][] edges = new double[count][count];

        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                double v = random.apply(maxVal);
                edges[i][j] = v;
                edges[j][i] = v;
            }
        }

        return edges;
    }
}
