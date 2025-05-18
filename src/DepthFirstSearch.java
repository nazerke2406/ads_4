public class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(UnweightedGraph<V> graph, V source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(UnweightedGraph<V> graph, V current) {
        marked.add(current);

        for (V neighbor : graph.adjacencyList(current)) {
            if (!marked.contains(neighbor)) {
                edgeTo.put(neighbor, current);
                dfs(graph, neighbor);
            }
        }
    }
}
