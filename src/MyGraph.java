import java.util.*;

public class MyGraph<V> {
    private final WeightedGraph<V> graph;

    public MyGraph() {
        this(true);
    }

    public MyGraph(boolean undirected) {
        graph = new WeightedGraph<>(undirected);
    }

    public void addVertex(V v) {
        if (graph.hasVertex(v)) return;
        graph.addVertex(v);
    }

    public void addEdge(V source, V dest) {
        graph.addEdge(source, dest, 1.0); // default weight = 1
    }

    public void addEdge(V source, V dest, double weight) {
        graph.addEdge(source, dest, weight);
    }

    public boolean hasVertex(V v) {
        return graph.hasVertex(v);
    }

    public Map<Vertex<V>, Double> adjacencyList(V v) {
        return graph.adjacencyList(v);
    }

    public Set<Vertex<V>> getAllVertices() {
        return graph.getAllVertices();
    }
}
