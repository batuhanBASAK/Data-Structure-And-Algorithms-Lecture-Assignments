import java.util.List;

/**
 * The driver class to test each map
 */
public class Main {
    public static void main(String[] args) {
        try {
            long startTime, endTime, elapsedTime;

            // map01
            // --------------------------------------------------------------
            CSE222Map map01 = new CSE222Map("./input-maps/map01.txt");
            CSE222Graph graph01 = new CSE222Graph(map01);
            
            startTime = System.currentTimeMillis();
            // // Implement BFS and write file to png and txt files.
            CSE222BFS BFS01 = new CSE222BFS(graph01);
            List<Vertex> path01;
            path01 = BFS01.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("BFS algorithm running time for map01: " + elapsedTime);
            MapFileWriter.writePathToPNG(map01, path01, "map01_BFS.png");
            MapFileWriter.writePathToTxt(path01, "map01_BFS.txt");
            
            path01 = null;
            startTime = System.currentTimeMillis();
            // Implement Dijkstra's algorithm and write file 
            // to png and txt files.
            CSE222Dijkstra dijkstra01 = new CSE222Dijkstra(graph01);
            path01 = dijkstra01.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Dijkstra's algorithm running time for map01: " + elapsedTime);
            MapFileWriter.writePathToPNG(map01, path01, "map01_Dijkstra.png");
            MapFileWriter.writePathToTxt(path01, "map01_Dijkstra.txt");
            // --------------------------------------------------------------



            // map02
            // --------------------------------------------------------------
            CSE222Map map02 = new CSE222Map("./input-maps/map02.txt");
            CSE222Graph graph02 = new CSE222Graph(map02);
            
            startTime = System.currentTimeMillis();
            // Implement BFS and write file to png and txt files.
            CSE222BFS BFS02 = new CSE222BFS(graph02);
            List<Vertex> path02;
            path02 = BFS02.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("BFS algorithm running time for map02: " + elapsedTime);
            MapFileWriter.writePathToPNG(map02, path02, "map02_BFS.png");
            MapFileWriter.writePathToTxt(path02, "map02_BFS.txt");
            
            
            path02 = null;
            startTime = System.currentTimeMillis();
            // Implement Dijkstra's algorithm and write file 
            // to png and txt files.
            CSE222Dijkstra dijkstra02 = new CSE222Dijkstra(graph02);
            path02 = dijkstra02.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Dijkstra's algorithm running time for map02: " + elapsedTime);

            MapFileWriter.writePathToPNG(map02, path02, "map02_Dijkstra.png");
            MapFileWriter.writePathToTxt(path02, "map02_Dijkstra.txt");
            // --------------------------------------------------------------




            // map03
            // --------------------------------------------------------------
            CSE222Map map03 = new CSE222Map("./input-maps/map03.txt");
            CSE222Graph graph03 = new CSE222Graph(map03);
            
            startTime = System.currentTimeMillis();
            // Implement BFS and write file to png and txt files.
            CSE222BFS BFS03 = new CSE222BFS(graph03);
            List<Vertex> path03;
            path03 = BFS03.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("BFS algorithm running time for map03: " + elapsedTime);

            MapFileWriter.writePathToPNG(map03, path03, "map03_BFS.png");
            MapFileWriter.writePathToTxt(path03, "map03_BFS.txt");
            
            path03 = null;
            startTime = System.currentTimeMillis();
            // Implement Dijkstra's algorithm and write file 
            // to png and txt files.
            CSE222Dijkstra dijkstra03 = new CSE222Dijkstra(graph03);
            path03 = dijkstra03.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Dijkstra's algorithm running time for map03: " + elapsedTime);

            MapFileWriter.writePathToPNG(map03, path03, "map03_Dijkstra.png");
            MapFileWriter.writePathToTxt(path03, "map03_Dijkstra.txt");
            // --------------------------------------------------------------



            // map04
            // --------------------------------------------------------------
            CSE222Map map04 = new CSE222Map("./input-maps/map04.txt");
            CSE222Graph graph04 = new CSE222Graph(map04);
            
            startTime = System.currentTimeMillis();
            // Implement BFS and write file to png and txt files.
            CSE222BFS BFS04 = new CSE222BFS(graph04);
            List<Vertex> path04;
            path04 = BFS04.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("BFS algorithm running time for map04: " + elapsedTime);
            MapFileWriter.writePathToPNG(map04, path04, "map04_BFS.png");
            MapFileWriter.writePathToTxt(path04, "map04_BFS.txt");
            
            
            path04 = null;
            startTime = System.currentTimeMillis();
            // Implement Dijkstra's algorithm and write file 
            // to png and txt files.
            CSE222Dijkstra dijkstra04 = new CSE222Dijkstra(graph04);
            path04 = dijkstra04.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Dijkstra's algorithm running time for map04: " + elapsedTime);

            MapFileWriter.writePathToPNG(map04, path04, "map04_Dijkstra.png");
            MapFileWriter.writePathToTxt(path04, "map04_Dijkstra.txt");
            // --------------------------------------------------------------





            // map05
            // --------------------------------------------------------------
            CSE222Map map05 = new CSE222Map("./input-maps/map05.txt");
            CSE222Graph graph05 = new CSE222Graph(map05);
            
            startTime = System.currentTimeMillis();
            // Implement BFS and write file to png and txt files.
            CSE222BFS BFS05 = new CSE222BFS(graph05);
            List<Vertex> path05;
            path05 = BFS05.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("BFS algorithm running time for map05: " + elapsedTime);
            MapFileWriter.writePathToPNG(map05, path05, "map05_BFS.png");
            MapFileWriter.writePathToTxt(path05, "map05_BFS.txt");
            
            
            path05 = null;
            startTime = System.currentTimeMillis();
            // Implement Dijkstra's algorithm and write file 
            // to png and txt files.
            CSE222Dijkstra dijkstra05 = new CSE222Dijkstra(graph05);
            path05 = dijkstra05.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Dijkstra's algorithm running time for map05: " + elapsedTime);
            MapFileWriter.writePathToPNG(map05, path05, "map05_Dijkstra.png");
            MapFileWriter.writePathToTxt(path05, "map05_Dijkstra.txt");
            // --------------------------------------------------------------


            // map06
            // --------------------------------------------------------------
            CSE222Map map06 = new CSE222Map("./input-maps/map06.txt");
            CSE222Graph graph06 = new CSE222Graph(map06);
            
            startTime = System.currentTimeMillis();
            // Implement BFS and write file to png and txt files.
            CSE222BFS BFS06 = new CSE222BFS(graph06);
            List<Vertex> path06;
            path06 = BFS06.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("BFS algorithm running time for map06: " + elapsedTime);
            MapFileWriter.writePathToPNG(map06, path06, "map06_BFS.png");
            MapFileWriter.writePathToTxt(path06, "map06_BFS.txt");
            
            
            path06 = null;
            startTime = System.currentTimeMillis();
            // Implement Dijkstra's algorithm and write file 
            // to png and txt files.
            CSE222Dijkstra dijkstra06 = new CSE222Dijkstra(graph06);
            path06 = dijkstra06.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Dijkstra's algorithm running time for map06: " + elapsedTime);
            MapFileWriter.writePathToPNG(map06, path06, "map06_Dijkstra.png");
            MapFileWriter.writePathToTxt(path06, "map06_Dijkstra.txt");
            // --------------------------------------------------------------



            // map07
            // --------------------------------------------------------------
            CSE222Map map07 = new CSE222Map("./input-maps/map07.txt");
            CSE222Graph graph07 = new CSE222Graph(map07);
            
            startTime = System.currentTimeMillis();
            // Implement BFS and write file to png and txt files.
            CSE222BFS BFS07 = new CSE222BFS(graph07);
            List<Vertex> path07;
            path07 = BFS07.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("BFS algorithm running time for map07: " + elapsedTime);
            MapFileWriter.writePathToPNG(map07, path07, "map07_BFS.png");
            MapFileWriter.writePathToTxt(path07, "map07_BFS.txt");
            
            
            path07 = null;
            startTime = System.currentTimeMillis();
            // Implement Dijkstra's algorithm and write file 
            // to png and txt files.
            CSE222Dijkstra dijkstra07 = new CSE222Dijkstra(graph07);
            path07 = dijkstra07.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Dijkstra's algorithm running time for map07: " + elapsedTime);
            MapFileWriter.writePathToPNG(map07, path07, "map07_Dijkstra.png");
            MapFileWriter.writePathToTxt(path07, "map07_Dijkstra.txt");
            // --------------------------------------------------------------





            // map08
            // --------------------------------------------------------------
            CSE222Map map08 = new CSE222Map("./input-maps/map08.txt");
            CSE222Graph graph08 = new CSE222Graph(map08);
            
            startTime = System.currentTimeMillis();
            // Implement BFS and write file to png and txt files.
            CSE222BFS BFS08 = new CSE222BFS(graph08);
            List<Vertex> path08;
            path08 = BFS08.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("BFS algorithm running time for map08: " + elapsedTime);
            MapFileWriter.writePathToPNG(map08, path08, "map08_BFS.png");
            MapFileWriter.writePathToTxt(path08, "map08_BFS.txt");
            
            
            path08 = null;
            startTime = System.currentTimeMillis();
            // Implement Dijkstra's algorithm and write file 
            // to png and txt files.
            CSE222Dijkstra dijkstra08 = new CSE222Dijkstra(graph08);
            path08 = dijkstra08.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Dijkstra's algorithm running time for map08: " + elapsedTime);
            MapFileWriter.writePathToPNG(map08, path08, "map08_Dijkstra.png");
            MapFileWriter.writePathToTxt(path08, "map08_Dijkstra.txt");
            // --------------------------------------------------------------







            // map09
            // --------------------------------------------------------------
            CSE222Map map09 = new CSE222Map("./input-maps/map09.txt");
            CSE222Graph graph09 = new CSE222Graph(map09);
            
            startTime = System.currentTimeMillis();
            // Implement BFS and write file to png and txt files.
            CSE222BFS BFS09 = new CSE222BFS(graph09);
            List<Vertex> path09;
            path09 = BFS09.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("BFS algorithm running time for map09: " + elapsedTime);
            MapFileWriter.writePathToPNG(map09, path09, "map09_BFS.png");
            MapFileWriter.writePathToTxt(path09, "map09_BFS.txt");
            
            
            path09 = null;
            startTime = System.currentTimeMillis();
            // Implement Dijkstra's algorithm and write file 
            // to png and txt files.
            CSE222Dijkstra dijkstra09 = new CSE222Dijkstra(graph09);
            path09 = dijkstra09.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Dijkstra's algorithm running time for map09: " + elapsedTime);
            MapFileWriter.writePathToPNG(map09, path09, "map09_Dijkstra.png");
            MapFileWriter.writePathToTxt(path09, "map09_Dijkstra.txt");
            // --------------------------------------------------------------







            // map10
            // --------------------------------------------------------------
            CSE222Map map10 = new CSE222Map("./input-maps/map10.txt");
            CSE222Graph graph10 = new CSE222Graph(map10);
            
            startTime = System.currentTimeMillis();
            // Implement BFS and write file to png and txt files.
            CSE222BFS BFS10 = new CSE222BFS(graph10);
            List<Vertex> path10;
            path10 = BFS10.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("BFS algorithm running time for map10: " + elapsedTime);
            MapFileWriter.writePathToPNG(map10, path10, "map10_BFS.png");
            MapFileWriter.writePathToTxt(path10, "map10_BFS.txt");
            
            
            path10 = null;
            startTime = System.currentTimeMillis();
            // Implement Dijkstra's algorithm and write file 
            // to png and txt files.
            CSE222Dijkstra dijkstra10 = new CSE222Dijkstra(graph10);
            path10 = dijkstra10.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Dijkstra's algorithm running time for map10: " + elapsedTime);
            MapFileWriter.writePathToPNG(map10, path10, "map10_Dijkstra.png");
            MapFileWriter.writePathToTxt(path10, "map10_Dijkstra.txt");
            // --------------------------------------------------------------




            
            // pisa
            // --------------------------------------------------------------
            CSE222Map mapPisa = new CSE222Map("./input-maps/pisa.txt");
            CSE222Graph graphPisa = new CSE222Graph(mapPisa);
            
            startTime = System.currentTimeMillis();
            // Implement BFS and write file to png and txt files.
            CSE222BFS BFSPisa = new CSE222BFS(graphPisa);
            List<Vertex> pathPisa;
            pathPisa = BFSPisa.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("BFS algorithm running time for pisa: " + elapsedTime);
            MapFileWriter.writePathToPNG(mapPisa, pathPisa, "pisa_BFS.png");
            MapFileWriter.writePathToTxt(pathPisa, "pisa_BFS.txt");
            
            
            pathPisa = null;
            startTime = System.currentTimeMillis();
            // Implement Dijkstra's algorithm and write file 
            // to png and txt files.
            CSE222Dijkstra dijkstraPisa = new CSE222Dijkstra(graphPisa);
            pathPisa = dijkstraPisa.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Dijkstra's algorithm running time for pisa: " + elapsedTime);
            MapFileWriter.writePathToPNG(mapPisa, pathPisa, "pisa_Dijkstra.png");
            MapFileWriter.writePathToTxt(pathPisa, "pisa_Dijkstra.txt");
            // --------------------------------------------------------------








            // tokyo
            // --------------------------------------------------------------
            CSE222Map mapTokyo = new CSE222Map("./input-maps/tokyo.txt");
            CSE222Graph graphTokyo = new CSE222Graph(mapTokyo);
            
            startTime = System.currentTimeMillis();
            // Implement BFS and write file to png and txt files.
            CSE222BFS BFSTokyo = new CSE222BFS(graphTokyo);
            List<Vertex> pathTokyo;
            pathTokyo = BFSTokyo.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("BFS algorithm running time for tokyo: " + elapsedTime);
            MapFileWriter.writePathToPNG(mapTokyo, pathTokyo, "tokyo_BFS.png");
            MapFileWriter.writePathToTxt(pathTokyo, "tokyo_BFS.txt");
            
            
            pathTokyo = null;
            startTime = System.currentTimeMillis();
            // Implement Dijkstra's algorithm and write file 
            // to png and txt files.
            CSE222Dijkstra dijkstraTokyo = new CSE222Dijkstra(graphTokyo);
            pathTokyo = dijkstraTokyo.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Dijkstra's algorithm running time for tokyo: " + elapsedTime);
            MapFileWriter.writePathToPNG(mapTokyo, pathTokyo, "tokyo_Dijkstra.png");
            MapFileWriter.writePathToTxt(pathTokyo, "tokyo_Dijkstra.txt");
            // --------------------------------------------------------------
        
        





            // triumph
            // --------------------------------------------------------------
            CSE222Map mapTriumph = new CSE222Map("./input-maps/triumph.txt");
            CSE222Graph graphTriumph = new CSE222Graph(mapTriumph);
            
            startTime = System.currentTimeMillis();
            // Implement BFS and write file to png and txt files.
            CSE222BFS BFSTriumph = new CSE222BFS(graphTriumph);
            List<Vertex> pathTriumph;
            pathTriumph = BFSTriumph.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("BFS algorithm running time for triumph: " + elapsedTime);
            MapFileWriter.writePathToPNG(mapTriumph, pathTriumph, "triumph_BFS.png");
            MapFileWriter.writePathToTxt(pathTriumph, "triumph_BFS.txt");
            
            
            pathTriumph = null;
            startTime = System.currentTimeMillis();
            // Implement Dijkstra's algorithm and write file 
            // to png and txt files.
            CSE222Dijkstra dijkstraTriumph = new CSE222Dijkstra(graphTriumph);
            pathTriumph = dijkstraTriumph.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Dijkstra's algorithm running time for triumph: " + elapsedTime);
            MapFileWriter.writePathToPNG(mapTriumph, pathTriumph, "triumph_Dijkstra.png");
            MapFileWriter.writePathToTxt(pathTriumph, "triumph_Dijkstra.txt");
            // --------------------------------------------------------------



            // vatican
            // --------------------------------------------------------------
            CSE222Map mapVatican = new CSE222Map("./input-maps/vatican.txt");
            CSE222Graph graphVatican = new CSE222Graph(mapVatican);
            
            startTime = System.currentTimeMillis();
            // Implement BFS and write file to png and txt files.
            CSE222BFS BFSVatican = new CSE222BFS(graphVatican);
            List<Vertex> pathVatican;
            pathVatican = BFSVatican.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("BFS algorithm running time for vatican: " + elapsedTime);
            MapFileWriter.writePathToPNG(mapVatican, pathVatican, "vatican_BFS.png");
            MapFileWriter.writePathToTxt(pathVatican, "vatican_BFS.txt");
            
            
            pathVatican = null;
            startTime = System.currentTimeMillis();
            // Implement Dijkstra's algorithm and write file 
            // to png and txt files.
            CSE222Dijkstra dijkstraVatican = new CSE222Dijkstra(graphVatican);
            pathVatican = dijkstraVatican.findPath();
            endTime = System.currentTimeMillis();
            elapsedTime = (endTime - startTime) / 1000;
            System.out.println("Dijkstra's algorithm running time for vatican: " + elapsedTime);
            MapFileWriter.writePathToPNG(mapVatican, pathVatican, "vatican_Dijkstra.png");
            MapFileWriter.writePathToTxt(pathVatican, "vatican_Dijkstra.txt");
            // --------------------------------------------------------------



        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
