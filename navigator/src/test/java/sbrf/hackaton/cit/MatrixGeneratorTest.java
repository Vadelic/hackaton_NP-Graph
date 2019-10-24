package sbrf.hackaton.cit;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        MatrixGenerator generator = new MatrixGenerator(600);
        double[] doubles = generator.vertexValueRound(20);
        System.out.println(Arrays.toString(doubles));
    }

    @Test
    public void edgesValue() {
        MatrixGenerator generator = new MatrixGenerator(20);
        double[][] doubles = generator.edgesValue(50);
        System.out.println(Arrays.toString(doubles));
    }

    @Test
    public void edgesValueRound() throws IOException {
        File file = new File("/Users/admin/IdeaProjects/GraphAPI/navigator/src/test/java/sbrf/hackaton/cit/data");
        FileWriter fileWriter = new FileWriter(file);

        MatrixGenerator generator = new MatrixGenerator(600);
        double[][] doubles = generator.edgesValueRound(15);
        for (double[] aDouble : doubles) {
            fileWriter.write(Arrays.toString(aDouble));
            fileWriter.write("\n");
            System.out.println(Arrays.toString(aDouble));

        }
        fileWriter.flush();
    }

}