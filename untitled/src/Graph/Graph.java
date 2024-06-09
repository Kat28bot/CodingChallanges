package Graph;

import java.util.*;

class Graph {
    private int vertices;
    private LinkedList<Edge>[] adjacencyList;

    class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int target, int weight) {
        adjacencyList[source].add(new Edge(target, weight));
        adjacencyList[target].add(new Edge(source, weight)); // For undirected graph
    }

    void dijkstra(int source) {
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(edge -> edge.weight));

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        pq.add(new Edge(source, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().target;
            if (visited[u]) continue;
            visited[u] = true;

            for (Edge edge : adjacencyList[u]) {
                int v = edge.target;
                int weight = edge.weight;

                if (!visited[v] && dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Edge(v, dist[v]));
                }
            }
        }

        printSolution(dist, source);
    }

    void printSolution(int[] dist, int source) {
        System.out.println("Vertex\t\tDistance from Source " + source);
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 10);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 4, 4);
        graph.addEdge(2, 4, 2);

        graph.dijkstra(0); // Source vertex is 0 (A)
    }
}

