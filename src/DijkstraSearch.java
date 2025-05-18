import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Set<V> unsettledNodes = new HashSet<>();
    private final Map<V, Double> distances = new HashMap<>();
    private final WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        this.graph = graph;
        dijkstra();
    }

    private void dijkstra() {
        distances.put(source, 0.0);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            V current = getMinDistanceVertex(unsettledNodes);
            unsettledNodes.remove(current);
            marked.add(current);

            Map<Vertex<V>, Double> neighbors = graph.adjacencyList(current);
            if (neighbors == null) continue;

            for (Map.Entry<Vertex<V>, Double> entry : neighbors.entrySet()) {
                V neighbor = entry.getKey().getData();
                double weight = entry.getValue();
                double newDist = getDistance(current) + weight;

                if (newDist < getDistance(neighbor)) {
                    distances.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    private V getMinDistanceVertex(Set<V> vertices) {
        V minVertex = null;
        double minDistance = Double.MAX_VALUE;

        for (V v : vertices) {
            double dist = getDistance(v);
            if (dist < minDistance) {
                minDistance = dist;
                minVertex = v;
            }
        }

        return minVertex;
    }

    private double getDistance(V v) {
        return distances.getOrDefault(v, Double.MAX_VALUE);
    }
}
