import java.util.Scanner;


public class directionCheck {

    public static boolean isDirectedGraph(int[][] matrix) {
        int n = matrix.length; // Function to check if the given matrix represents a directed graph


        for (int i = 0; i < n; i++) { // checks matrix symmetry
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return true; // Not symmetric --> directed graph
                }
            }
        }

        return false; // Symmetric --> undirected graph
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the matrix (n):");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter the matrix elements (row-wise):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        if (isDirectedGraph(matrix)) {
            System.out.println("The given matrix represents a directed graph.");
        } else {
            System.out.println("The given matrix does not represent a directed graph.");
        }
    }

}
