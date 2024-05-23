import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {


        ArrayList<Integer> xAxis; 
        Map<String,ArrayList<Long>> yAxis = new HashMap<>();

        String inputFile = args[0];
        StockDataManager manager = new StockDataManager();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                processCommand(line, manager);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error read input file: " + inputFile);
        }   
        //manager.getAvlTree().postOrderTraversal();
        
        
        xAxis = new ArrayList<>();
        for(int i = 1; i < 100; i++)
        {
            xAxis.add(i * 100);
        }

        yAxis.put("ADD", new ArrayList<>());
        yAxis.put("REMOVE", new ArrayList<>());
        yAxis.put("SEARCH", new ArrayList<>());
        yAxis.put("UPDATE", new ArrayList<>());

        for(int i = 1; i < 100; i++)
        {
            System.out.println(i);
            performPerformanceAnalysis(manager, i * 100, xAxis, yAxis);
        }

        // Create GUIVisualizations for the performance analysis
        SwingUtilities.invokeLater(() -> {
            String plotType = "scatter"; // Change to "scatter" for scatter plot
            GUIVisualization frame = new GUIVisualization(plotType, xAxis, yAxis.get("ADD"), "Add"); // Create a new instance of GUIVisualization
            frame.setVisible(true); // Make the frame visible
        
            GUIVisualization frame2 = new GUIVisualization(plotType, xAxis, yAxis.get("REMOVE"), "Remove"); // Create a new instance of GUIVisualization
            frame2.setVisible(true); // Make the frame visible
        
            GUIVisualization frame3 = new GUIVisualization(plotType, xAxis, yAxis.get("SEARCH"), "Search"); // Create a new instance of GUIVisualization
            frame3.setVisible(true); // Make the frame visible
        
            GUIVisualization frame4 = new GUIVisualization(plotType, xAxis, yAxis.get("UPDATE"), "Update "); // Create a new instance of GUIVisualization
            frame4.setVisible(true); // Make the frame visible
        
        });

    }

    private static void processCommand(String line, StockDataManager manager) throws IOException {
       
        String[] tokens = line.split(" ");
        String command = tokens[0];

        switch (command) {
            case "ADD":
                manager.addOrUpdateStock(tokens[1], Double.parseDouble(tokens[2]), Long.parseLong(tokens[3]), Long.parseLong(tokens[4]));
                break;
            case "REMOVE":
                manager.removeStock(tokens[1]);
                break;
            case "SEARCH":
                Stock stock = manager.searchStock(tokens[1]);
                if (stock != null) {
                    System.out.println(stock);
                } else {
                    System.out.println("Stock not found: " + tokens[1]);
                }
                break;
            case "UPDATE":
                manager.updateStock(tokens[1],tokens[2], Double.parseDouble(tokens[3]), Long.parseLong(tokens[4]), Long.parseLong(tokens[5]));
                break;
            default:
                throw new IOException("invalid command: " + command);
        }
    }

    private static void performPerformanceAnalysis(StockDataManager manager, int size, ArrayList<Integer> xAxis, Map<String,ArrayList<Long>> yAxis) {
        long startTime, endTime;
        // Measure time for ADD operation
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            manager.addOrUpdateStock("SYM" + i, Math.random() * 100, (long) (Math.random() * 1000000), (long) (Math.random() * 1000000000));
        }
        endTime = System.nanoTime();
        System.out.println("Average ADD time: " + (endTime - startTime) / size + " ns");
        yAxis.get("ADD").add((endTime - startTime) / size);

        // Measure time for SEARCH operation
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            manager.searchStock("SYM" + i);
        }
        endTime = System.nanoTime();
        System.out.println("Average SEARCH time: " + (endTime - startTime) / size + " ns");
        yAxis.get("SEARCH").add((endTime - startTime) / size);

         // Measure time for UPDATE operation
         startTime = System.nanoTime();
         for (int i = 0; i < size; i++) {
             manager.updateStock("SYM" + i, "SYM" + i, Math.random() * 100, (long) (Math.random() * 1000000), (long) (Math.random() * 1000000000));
         }
         endTime = System.nanoTime();
         System.out.println("Average UPDATE time: " + (endTime - startTime) / size + " ns");
         yAxis.get("UPDATE").add((endTime - startTime) / size);


        // Measure time for REMOVE operation
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            manager.removeStock("SYM" + i);
        }
        endTime = System.nanoTime();
        System.out.println("Average REMOVE time: " + (endTime - startTime) / size + " ns");
        yAxis.get("REMOVE").add((endTime - startTime) / size);

       

    }
}
