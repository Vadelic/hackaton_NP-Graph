package sbrf.hackaton.cit.np;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class GraphNp {
    private int count;
    private int[][] matrix;
    private boolean[] marks;

    private GraphNp(int count) {
        this.count = count;
        matrix = new int[count][count];
        marks = new boolean[count];
    }

    private void setEdge(int a, int b, int weight) {
        matrix[a][b] = weight;
        matrix[b][a] = weight;
    }

    int getEdge(int a, int b) {
        return matrix[a][b];
    }

    boolean hasEdge(int a, int b) {
        return matrix[a][b] != 0;
    }

    private static GraphNp load(File file) throws IOException {
        Scanner sc = new Scanner(file);

        GraphNp graph = new GraphNp(sc.nextInt());

        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int weight = sc.nextInt();

            graph.setEdge(a, b, weight);
        }

        return graph;
    }

    static GraphNp load(String filename) throws IOException {
        return load(new File(filename));
    }

    boolean enter(int pos) {
        if (marks[pos]) {
            return false;
        } else {
            marks[pos] = true;
            return true;
        }
    }

    void leave(int pos) {
        marks[pos] = false;
    }

    int getCount() {
        return count;
    }

    boolean allVisited() {
        for (boolean mark : marks) {
            if (!mark)
                return false;
        }
        return true;
    }
}