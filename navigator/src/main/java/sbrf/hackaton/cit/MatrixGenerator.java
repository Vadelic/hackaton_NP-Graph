package sbrf.hackaton.cit;

import java.util.Random;

public class MatrixGenerator {

    private Random random = new Random();
    private final int count;

    public MatrixGenerator(int count) {
        this.count = count;
    }

    public double[] vertexValue(int maxVal) {
        double[] vertexes = new double[count];

        for (int i = 0; i < count; i++) {
            vertexes[i] = random.nextDouble() * maxVal;
        }

        return vertexes;
    }

    public double[][] edgesValue(int maxVal) {
        double[][] edges = new double[count][count];

        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                double v = random.nextDouble() * maxVal;
                edges[i][j] = v;
                edges[j][i] = v;
            }
        }

        return edges;
    }
}
