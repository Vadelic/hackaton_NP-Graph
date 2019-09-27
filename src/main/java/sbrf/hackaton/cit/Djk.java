package sbrf.hackaton.cit;

public class Djk {

    public static void main(String[] args) {

        int n = 5;
        int[][] MatrixVeight = {
                {25, 10, 25, 25, 25},
                {25, 25, 12, 25, 8},
                {25, 25, 25, 8, 25},
                {25, 6, 8, 25, 3},
                {25, 25, 25, 3, 25}
        };
        int[][] MatrixHistory = {
                {0, 2, 0, 0, 0},
                {0, 0, 3, 0, 5},
                {0, 0, 0, 4, 0},
                {0, 2, 3, 0, 5},
                {0, 0, 0, 4, 0}
        };

        printMatrix(MatrixVeight);
        System.out.println();
        System.out.println();
        printMatrix(MatrixHistory);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (MatrixVeight[i][j] > -1) {
                    for (int w = 0; w < n; w++) {
                        if (MatrixVeight[i][w] > MatrixVeight[i][j] + MatrixVeight[j][w]) {
                            MatrixVeight[i][w] = MatrixVeight[i][j] + MatrixVeight[j][w];
                            MatrixHistory[i][w] = MatrixHistory[i][j];
                        }
                    }
                }
            }
        }
        System.out.println();
        System.out.println();

        printMatrix(MatrixVeight);
        System.out.println();
        printMatrix(MatrixHistory);


    }

    private static void printMatrix(int[][] matrixVeight) {
        int length = matrixVeight.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.printf("%3d", matrixVeight[i][j]);
            }
            System.out.println();
        }
    }
}