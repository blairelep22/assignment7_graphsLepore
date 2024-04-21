
import java.util.*;

public class everyPath {

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        List<Edge>[] adjacencyList;

        public Graph(int vertices) {
            adjacencyList = new ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencyList[source].add(edge);
        }

        public void printAllPaths(int u, int w) {
            List<List<Integer>> paths = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            path.add(u);
            dfs(u, w, 5, path, paths);
            System.out.println("Paths from " + u + " to " + w + " with length 5:");
            for (List<Integer> p : paths) {
                System.out.println(p);
            }
        }

        private void dfs(int u, int w, int length, List<Integer> path, List<List<Integer>> paths) {
            if (u == w && path.size() == length) {
                paths.add(new ArrayList<>(path));
                return;
            }
            if (path.size() >= length) {
                return;
            }
            for (Edge edge : adjacencyList[u]) {
                path.add(edge.destination);
                dfs(edge.destination, w, length, path, paths);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        Graph graph = new Graph(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (source, destination, weight):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(source, destination, weight);
        }

        System.out.print("Enter vertex u: ");
        int u = scanner.nextInt();

        System.out.print("Enter vertex w: ");
        int w = scanner.nextInt();

        graph.printAllPaths(u, w);
    }
}

