import java.util.*;
import java.io.File;


/** The CSE222MAP is a class to store 2D map in an underlying array.
 * The CSE222Map retrieves the map from a source file which file name 
 * is given with full path. The source file starts with two lines that
 * contains coordinates of points. And the rest of the source file
 * contains the map which represented by 0s and 1s where 0 represents valid
 * vertex and 1s represents obstacles. -1 is treated as 1, represents 
 * an obstacle.
 */
public class CSE222Map {
    // The number of rows and columns in the map
    private int rows, cols;

    // The underlying map array.
    private int[][] theMap;


    // The starting vertex in the map.
    private Vertex start;
    // The ending vertex in the map.
    private Vertex end;

    public CSE222Map(String filename){
        rows = findRows(filename);
        cols = findCols(filename);
        theMap = new int[rows][cols];
        try {
            Scanner scanner = new Scanner(new File(filename));

            // Get the start and end coordinates and store them
            String line = scanner.nextLine();
            String[] coordinatesStart = line.split(",");
            line = scanner.nextLine();
            String[] coordinatesEnd = line.split(",");

            // Fill theMap with values given in file.
            for (int i = 0; i < rows; i++){
                line = scanner.nextLine();
                String[] splittedLine = line.split(",");
                for (int j = 0; j < cols; j++){
                    theMap[i][j] = Integer.valueOf(splittedLine[j]);
                }
            }
            scanner.close();


            // Get the start and end vertices first
            int startX, startY, endX, endY, startVal, endVal;
            startX = Integer.valueOf(coordinatesStart[0]);
            startY = Integer.valueOf(coordinatesStart[1]);
            startVal = theMap[startX][startY];
            endX = Integer.valueOf(coordinatesEnd[0]);
            endY = Integer.valueOf(coordinatesEnd[1]);
            endVal = theMap[endX][endY];

            if (startVal != 0 || endVal != 0){
                throw new UnsupportedOperationException("The starting or ending point is not a vertex!!!");
            }

            start = new Vertex(startX, startY, startVal);
            end = new Vertex(endX, endY, endVal);

        } catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    // The getter methods
    /**
     * Getter method for number of rows in the map
     * @return The number of rows in the map.
     */
    public int getRows(){
        return rows;
    }

    /**
     * Getter method for number of columns in the map
     * @return The number of columns in the map.
     */
    public int getCols(){
        return cols;
    }


    /**
     * Getter method of the map itself.
     * @return The map.
     */
    public int[][] getMap(){
        return theMap;
    }


    /**
     * Getter method for the start vertex.
     * @return The start vertex
     */
    public Vertex getStartVertex(){
        return start;
    }

    /**
     * Getter method for the end vertex.
     * @return The end vertex.
     */
    public Vertex getEndVertex(){
        return end;
    }


    // Finds the number of rows given file consists of.
    private int findRows(String filename){
        int rows = 0;
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                rows++;
                scanner.nextLine();
            }
            // Remove the first two rows.
            rows -= 2;
            scanner.close();
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        return rows;
    }


    // Finds the number of columns given file has in a row.
    private int findCols(String filename){
        int cols = 0;
        try {
            Scanner scanner = new Scanner(new File(filename));
            // Pass the first two rows.
            scanner.nextLine();
            scanner.nextLine();
            String line = scanner.nextLine();
            scanner.close();
            String[] splittedLine = line.split(",");
            cols = splittedLine.length;
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        return cols;
    }





}