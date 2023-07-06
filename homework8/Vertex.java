/** The Vertex class is abstraction a Vertex in 2D space. */
public class Vertex {
    // The x and y coordinates of vertex.
    private int x, y;

    // The value of vertex.
    private int value;

    public Vertex(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }

    // Getter methods
    /**
     * The getter method for x.
     * @return The x coordinate
     */
    public int getX(){
        return x;
    }

    /**
     * The getter method for y.
     * @return The y coordinate
     */
    public int getY(){
        return y;
    }

    /**
     * Getter method for value
     * @return The value of vertex
     */
    public int getValue(){
        return value;
    }




    // Overriden methods
    public int hashCode(){
        return 31*x + y;
    }

    public String toString(){
        return "(" + x + ", " + y + "), value: " + value;
    }

    public boolean equals(Object o){
        if (!(o instanceof Vertex)){
            return false;
        }
        Vertex v = (Vertex) o;
        return x == v.getX() && y == v.getY() && value == v.getValue();
    }
}
