package sbrf.hackaton.cit;

import org.junit.Test;

import java.util.Arrays;

public class MatrixGeneratorTest {


    @Test
    public void vertexValue() {
        MatrixGenerator generator = new MatrixGenerator(20);
        double[] doubles = generator.vertexValue(50);
        System.out.println(Arrays.toString(doubles));
    }
    @Test
    public void vertexValueRound() {
        MatrixGenerator generator = new MatrixGenerator(20);
        double[] doubles = generator.vertexValueRound(50);
        System.out.println(Arrays.toString(doubles));
    }

    @Test
    public void edgesValue() {
        MatrixGenerator generator = new MatrixGenerator(20);
        double[][] doubles = generator.edgesValue(50);
        System.out.println(Arrays.toString(doubles));
    }

    @Test
    public void edgesValueRound() {
        MatrixGenerator generator = new MatrixGenerator(20);
        double[][] doubles = generator.edgesValueRound(50);
        for (double[] aDouble : doubles) {
            System.out.println(Arrays.toString(aDouble));

        }
    }

}