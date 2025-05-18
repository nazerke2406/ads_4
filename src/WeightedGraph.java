import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private final Set<Vertex<V>> vertices = new HashSet<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V value) {
        if (hasVertex(value)) return;
        vertices.add(new Vertex<>(value));
    }

    public void addEdge(V source, V dest, double weight) {
        Vertex<V> v1 = getVertex(source);
        Vertex<V> v2 = getVertex(dest);

        if (v1 == null) {
            v1 = new Vertex<>(source);
            vertices.add(v1);
        }

        if (v2 == null) {
            v2 = new Vertex<>(dest);
            vertices.add(v2);
        }

        if (v1.equals(v2)) return;

        v1.addAdjacentVertex(v2, weight);

        if (undirected) {
            v2.addAdjacentVertex(v1, weight);
        }
    }

    public boolean hasVertex(V value) {
        return getVertex(value) != null;
    }

    public Vertex<V> getVertex(V value) {
        for (Vertex<V> v : vertices) {
            if (v.getData().equals(value)) return v;
        }
        return null;
    }

    public Map<Vertex<V>, Double> adjacencyList(V value) {
        Vertex<V> vertex = getVertex(value);
        if (vertex == null) return null;
        return vertex.getAdjacents();
    }

    public Set<Vertex<V>> getAllVertices() {
        return vertices;
    }
}
