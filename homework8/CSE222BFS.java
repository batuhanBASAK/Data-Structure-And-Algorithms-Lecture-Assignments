import java.util.*;


/** Implements breadth-first search algorithm to find a feasible path from
* starting to ending vertex. It takes the graph CSE222Graph to construct.
 * And finds the path with method called findPath(). The method findPath
 * returns path as list of vertices.
 */
public class CSE222BFS {
    private CSE222Graph graph;

    public CSE222BFS(CSE222Graph graph) {
        this.graph = graph;
    }

    public List<Vertex> findPath() {
        Vertex start = graph.getStart();
        Vertex end = graph.getEnd();

        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        Map<Vertex, Vertex> parentMap = new HashMap<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            // Check if the current vertex is the end vertex
            if (currentVertex.equals(end)) {
                // Build the path by traversing the parent map
                return buildPath(parentMap, start, end);
            }

            // Get the edges of the current vertex
            Iterator<Edge> edgeIterator = graph.edgeIterator(currentVertex);
            while (edgeIterator.hasNext()) {
                Edge edge = edgeIterator.next();
                Vertex neighbor = edge.getDest();

                if (!visited.contains(neighbor)) {
                    // Add the neighbor to the queue and mark it as visited
                    queue.offer(neighbor);
                    visited.add(neighbor);
                    // Set the current vertex as the parent of the neighbor
                    parentMap.put(neighbor, currentVertex);
                }
            }
        }

        // Return empty list for the case that there is no path
        // find from start to end
        return new ArrayList<>();
    }

    private List<Vertex> buildPath(Map<Vertex, Vertex> parentMap, Vertex start, Vertex end) {
        List<Vertex> path = new LinkedList<>();
        Vertex currentVertex = end;

        while (currentVertex != null) {
            path.add(0, currentVertex);
            currentVertex = parentMap.get(currentVertex);
        }

        return path;
    }


}
