import java.util.*;

/** The graph implementation which takes the map CSE222map to build a graph
 * Each graph has a starting, an ending vertex. The adjecency relation is 
 * stored in a hash map.
 */
public class CSE222Graph {
    // The start vertex
    private Vertex start;
    // The end vertex
    private Vertex end;
    // The underlying array holds the map
    private int[][] theMap;
    // List of vertices in the map.
    private List<Vertex> vertices;
    // The number of vertices in the list *vertices*
    private int numV;
    // The array of edges LinkedHashMap map. Each Map stores the
    // the edges that index is the index of source vertex in the list
    // *verticies* to easily find the edges which have same source vertex.
    private Map<Vertex, Edge>[] edges;


    @SuppressWarnings("unchecked")
    public CSE222Graph(CSE222Map map){
        start = map.getStartVertex();
        end = map.getEndVertex();
        theMap = map.getMap();


        vertices = new ArrayList<>();
        for (int i = 0; i < map.getRows(); i++){
            for (int j = 0; j < map.getCols(); j++){
                if (theMap[i][j] == 0){
                    vertices.add(new Vertex(i, j, 0));
                }
            }
        }
        
        // Set the numV
        this.numV = vertices.size();

        // Initialise the edges array.
        edges = new Map[numV];
        for (int i = 0; i < numV; i++){
            edges[i] = new LinkedHashMap<>();
        }

        // Find and put the edges.
        for (int i = 0; i < numV; i++){
            Vertex source = vertices.get(i);
            for (int j = 0; j < numV; j++){
                Vertex dest = vertices.get(j);
                int sourceX = source.getX();
                int sourceY = source.getY();
                int destX = dest.getX();
                int destY = dest.getY();
                if ((sourceY-1 == destY && sourceX == destX) ||
                    (sourceY+1 == destY && sourceX == destX) ||
                    (sourceY == destY && sourceX-1 == destX) ||
                    (sourceY == destY && sourceX+1 == destX))
                {
                    edges[i].put(dest, new Edge(source, dest, 1.0F));
                }

                else if ((sourceY-1 == destY && sourceX-1 == destX) ||
                    (sourceY-1 == destY && sourceX+1 == destX) ||
                    (sourceY+1 == destY && sourceX-1 == destX) ||
                    (sourceY+1 == destY && sourceX+1 == destX))
                {
                    edges[i].put(dest, new Edge(source, dest, Math.sqrt(2)));
                }
            }
        }
    }


    /**
     * Checks wheterher given source and destination vertices 
     * represent an edge or not.
     * @param source The source vertex
     * @param dest The destination vertex
     * @return true if this is an edge, otherwise false.
     */
    public boolean isEdge(Vertex source, Vertex dest){
        int index = vertices.indexOf(source);
        if (index == -1){
            return false;
        }
        Edge edge = edges[index].get(dest);
        if (edge == null){
            return false;
        }
        return edge.getDest().equals(dest);
    }

    // Getter methods
    /**
     * Getter method for edge, if such an edge exists in the map
     * @param source The source vertex
     * @param dest The destination vertex
     * @return If the edge exists return the edge. otherwise null.
     * 
     */
    public Edge getEdge(Vertex source, Vertex dest){
        int index = vertices.indexOf(source);
        if (index == -1){
            throw new IndexOutOfBoundsException(index);
        }
        return edges[index].get(dest);
    }

    /**
     * Getter method for start vertex
     * @return The start vertex
     */
    public Vertex getStart(){
        return start;
    }

    /**
     * Getter method for end vertex
     * @return The end vertex
     */
    public Vertex getEnd(){
        return end;
    }

    /**
     * Getter method for number of vertices.
     * @return The number of vertices.
     */
    public int getNumV(){
        return numV;
    }


    /**
     * Getter method for vertices list.
     * @return The list of vertices
     */
    public List<Vertex> getVertices(){
        return vertices;
    }


    /**
     * Getter method for array of edges Map
     * @return The edges.
     */
    public Map<Vertex, Edge>[] getEdges(){
        return edges;
    }



    public Iterator<Edge> edgeIterator(Vertex source) {
        int index = vertices.indexOf(source);
        if (index == -1){
            return null;
        }
        return edges[index].values().iterator();
    }
}
