/** The abstraction for edges between vertices.
 */
public class Edge {
    // The source vertex
    private Vertex source;
    // The destination vertex
    private Vertex dest;
    // The weight
    private double weight;


    public Edge(Vertex source, Vertex dest){
        this.source = source;
        this.dest = dest;
        this.weight = 1.0F;
    }

    public Edge(Vertex source, Vertex dest, double weight){
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }


    // The getter methods
    /**
     * Getter method for source vertex
     * @return The source vertex
     */
    public Vertex getSource(){
        return source;
    }

    /**
     * Getter method for destination vertex
     * @return The destination vertex.
     */
    public Vertex getDest(){
        return dest;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double w){
        weight = w;
    }


    public String toString(){
        return "Source: " + source.toString() + ", destination: " + dest.toString(); 
    }

    public boolean equals(Object o){
        if (!(o instanceof Edge)){
            return false;
        }
        Edge e = (Edge) o;
        return source.equals(e.getSource()) && dest.equals(e.getDest());
    }


}
