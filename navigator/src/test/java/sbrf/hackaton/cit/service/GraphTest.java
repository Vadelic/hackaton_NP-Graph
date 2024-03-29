package sbrf.hackaton.cit.service;

public abstract class GraphTest {
    public static double[] vertexes = {1, 2, 3, 4, 5, 0, 7, 8, 9, 10};
    public static double[][] edges = {
            {0, 4, 3, 1, 0, 0, 0, 0, 0, 0},
            {4, 0, 0, 6, 3, 0, 0, 0, 0, 0},
            {3, 0, 0, 0, 10, 0, 0, 0, 0, 0},
            {1, 6, 0, 0, 0, 8, 14, 0, 0, 0},
            {0, 3, 10, 0, 0, 0, 0, 11, 0, 0},
            {0, 0, 0, 8, 0, 0, 2, 4, 0, 0},
            {0, 0, 0, 14, 0, 2, 0, 0, 1, 0},
            {0, 0, 0, 0, 11, 4, 0, 0, 6, 3},
            {0, 0, 0, 0, 0, 0, 1, 6, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 3, 0, 0}
    };
    public static double[][] directionEdges = {
            {0, 4, 3, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 6, 3, 0, 0, 0, 0, 0},
            {3, 0, 0, 0, 10, 0, 0, 0, 0, 0},
            {1, 6, 0, 0, 0, 8, 14, 0, 0, 0},
            {0, 3, 10, 0, 0, 0, 0, 11, 0, 0},
            {0, 0, 0, 8, 0, 0, 2, 4, 0, 0},
            {0, 0, 0, 14, 0, 2, 0, 0, 1, 0},
            {0, 0, 0, 0, 11, 4, 0, 0, 6, 3},
            {0, 0, 0, 0, 0, 0, 1, 6, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 3, 0, 0}
    };

    public static double[][] fullEdges = {
            {0, 4, 3, 1, 4, 5, 6, 3, 4, 2},
            {4, 0, 6, 6, 3, 1, 2, 3, 5, 10},
            {3, 6, 0, 5, 10, 7, 9, 2, 1, 6},
            {1, 6, 5, 0, 4, 8, 14, 4, 5, 6},
            {4, 3, 10, 4, 0, 4, 2, 11, 8, 6},
            {5, 1, 7, 8, 4, 0, 2, 4, 6, 5},
            {6, 2, 9, 14, 2, 2, 0, 10, 1, 4},
            {3, 3, 2, 4, 11, 4, 10, 0, 6, 3},
            {4, 5, 1, 5, 8, 6, 1, 6, 0, 11},
            {2, 10, 6, 6, 6, 5, 4, 3, 11, 0}
    };
    //    MatrixGenerator generator=  new MatrixGenerator();
}
