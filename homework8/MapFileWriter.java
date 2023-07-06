import java.util.List;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * MapFileWriter is a class to write CSE222Map to a file with given file name
 * This class supports two file format to write on which are txt and 
 * PNG formats.
 * 
 */
public class MapFileWriter {

    /**
     * Write CSE222Map to PNG file with given file name. And draws the 
     * path with different color. 
     * @param cse222Map The map to write
     * @param path The path to draw on the map
     * @param filename The file name to write it.
     */
    public static void writePathToPNG(CSE222Map cse222Map, List<Vertex> path, String filename){
        int rows = cse222Map.getRows();
        int cols = cse222Map.getCols();
        final int[][] map = cse222Map.getMap(); 
        int[][] mapWithPath = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                mapWithPath[i][j] = map[i][j];
            }
        }

        for (Vertex v : path){
            mapWithPath[v.getX()][v.getY()] = 2;
        }


        try {
            BufferedImage bufferedImage = new BufferedImage(cols, rows, BufferedImage.TYPE_INT_RGB);
        
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++) {
                    switch(mapWithPath[i][j]){
                        case 0:
                            // Color it white
                            bufferedImage.setRGB(j, i, new Color(255, 255, 255).getRGB());
                            break;
                        case -1:
                        case 1:
                            bufferedImage.setRGB(j, i, new Color(96, 96, 96).getRGB());
                            break;  
                        case 2:
                            bufferedImage.setRGB(j, i, new Color(255, 0, 0).getRGB());
                            break;
                        default:
                            break;
                    }
                }
            }

            Files.createDirectories(Paths.get("./outputs"));
            File outputFile = new File("./outputs/" + filename);
            ImageIO.write(bufferedImage, "png", outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    /**
     * Write each vertex in path to a text file with given file name.
     * @param path The path contains list of vertices
     * @param filename The file name of file will be written.
     */
    public static void writePathToTxt(List<Vertex> path, String filename){
        try {
            Files.createDirectories(Paths.get("./outputs"));
            FileWriter outputFileWriter = new FileWriter("./outputs/" + filename);
            for (Vertex vertex : path){
                int x = vertex.getX();
                int y = vertex.getY();
                outputFileWriter.write(x + ", " + y + "\n");
            }
            outputFileWriter.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
