package sbrf.hackaton.cit;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class MatrixFromFileTest {
    @Test
    public void constructor() throws IOException {
        File file = new File("/Users/admin/IdeaProjects/GraphAPI/navigator/src/test/java/sbrf/hackaton/cit/dataLo");
        GraphContext graphContext = new GraphContext(file);
        System.out.println(graphContext);
    }
}