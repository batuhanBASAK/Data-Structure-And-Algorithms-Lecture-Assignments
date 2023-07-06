import java.util.*;


/** Implements Dijkstra's algorithm to find shortest path from
 * starting to ending vertex. It takes the graph CSE222Graph to construct.
 * And finds the path with method called findPath(). The method findPath
 * returns path as list of vertices.
 */
public class CSE222Dijkstra {
    private CSE222Graph graph;

    public CSE222Dijkstra(CSE222Graph graph) {
        this.graph = graph;
    }

    public List<Vertex> findPath() {
        Map<Vertex, Double> distanceMap = new HashMap<>();
        Map<Vertex, Vertex> predecessorMap = new HashMap<>();
        Set<Vertex> visited = new HashSet<>();

        // Initialize the distance map with infinity values for all vertices 
        // except the start vertex
        for (Vertex vertex : graph.getVertices()) {
            if (vertex.equals(graph.getStart())) {
                distanceMap.put(vertex, 0.0);
            } else {
                distanceMap.put(vertex, Double.POSITIVE_INFINITY);
            }
        }

        // Use a priority queue to select the vertex with the minimum distance
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distanceMap::get));
        priorityQueue.add(graph.getStart());

        while (!priorityQueue.isEmpty()) {
            Vertex current = priorityQueue.poll();
            visited.add(current);

            if (current.equals(graph.getEnd())) {
                // Reached the end vertex, stop the algorithm
                break;
            }

            Iterator<Edge> edgeIterator = graph.edgeIterator(current);
            while (edgeIterator.hasNext()) {
                Edge edge = edgeIterator.next();
                Vertex neighbor = edge.getDest();

                if (!visited.contains(neighbor)) {
                    double newDistance = distanceMap.get(current) + edge.getWeight();

                    if (newDistance < distanceMap.get(neighbor)) {
                        distanceMap.put(neighbor, newDistance);
                        predecessorMap.put(neighbor, current);
                        priorityQueue.remove(neighbor);
                        priorityQueue.add(neighbor);
                    }
                }
            }
        }

        // Build the shortest path from the predecessor map
        List<Vertex> shortestPath = new ArrayList<>();
        Vertex current = graph.getEnd();
        while (current != null) {
            shortestPath.add(0, current);
            current = predecessorMap.get(current);
        }

        return shortestPath;
    }
}
