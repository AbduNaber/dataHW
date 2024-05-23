import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        // arrays for visiualiziton
        ArrayList<Integer> xAxis; 
        ArrayList<Long> ADDyAxis = new ArrayList<>();
        ArrayList<Long> REMOVEyAxis = new ArrayList<>();
        ArrayList<Long> SEARCHyAxis = new ArrayList<>();
        ArrayList<Long> UPDATEyAxis = new ArrayList<>();

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

       

        for(int i = 1; i < 100; i++)
        {
            System.out.println(i);
            performPerformanceAnalysis(manager, i * 100, xAxis, ADDyAxis, REMOVEyAxis, SEARCHyAxis, UPDATEyAxis);
        }

        // Create GUIVisualizations for the performance analysis
        SwingUtilities.invokeLater(() -> {
            String plotType = "scatter"; // Change to "scatter" for scatter plot
            GUIVisualization frameADD = new GUIVisualization(plotType, xAxis, ADDyAxis, "Add"); // Create a new instance of GUIVisualization
            frameADD.setVisible(true); // Make the frame visible
        
            GUIVisualization frameREMOVE = new GUIVisualization(plotType, xAxis, REMOVEyAxis, "Remove"); // Create a new instance of GUIVisualization
            frameREMOVE.setVisible(true); // Make the frame visible
        
            GUIVisualization frameSEARCH = new GUIVisualization(plotType, xAxis, SEARCHyAxis, "Search"); // Create a new instance of GUIVisualization
            frameSEARCH.setVisible(true); // Make the frame visible
        
            GUIVisualization frameUPDATE = new GUIVisualization(plotType, xAxis, UPDATEyAxis, "Update "); // Create a new instance of GUIVisualization
            frameUPDATE.setVisible(true); // Make the frame visible
        
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
                manager.updateStock(tokens[1], Double.parseDouble(tokens[3]), Long.parseLong(tokens[4]), Long.parseLong(tokens[5]));
                break;
            default:
                throw new IOException("invalid command: " + command);
        }
    }

    private static void performPerformanceAnalysis(StockDataManager manager, int size, ArrayList<Integer> xAxis, ArrayList<Long> ADDyAxis, ArrayList<Long> REMOVEyAxis, ArrayList<Long> SEARCHyAxis, ArrayList<Long> UPDATEyAxis) {
        long startTime, endTime;
        // Measure time for ADD operation
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
           
            manager.addOrUpdateStock("SYM" + i, Math.random() * 100, (long) (Math.random() * 1000000), (long) (Math.random() * 1000000000));
            
        }
        endTime = System.nanoTime();
        System.out.println("Average ADD time: " + (endTime - startTime) / size + " ns");
        ADDyAxis.add((endTime - startTime) / size);

        // Measure time for SEARCH operation
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            manager.searchStock("SYM" + i);
        }
        endTime = System.nanoTime();
        System.out.println("Average SEARCH time: " + (endTime - startTime) / size + " ns");
        SEARCHyAxis.add((endTime - startTime) / size);

         // Measure time for UPDATE operation
         startTime = System.nanoTime();
         for (int i = 0; i < size; i++) {
             manager.updateStock("SYM" + i, Math.random() * 100, (long) (Math.random() * 1000000), (long) (Math.random() * 1000000000));
         }
         endTime = System.nanoTime();
         System.out.println("Average UPDATE time: " + (endTime - startTime) / size + " ns");
            UPDATEyAxis.add((endTime - startTime) / size);

        // Measure time for REMOVE operation
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            manager.removeStock("SYM" + i);
        }
        endTime = System.nanoTime();
        System.out.println("Average REMOVE time: " + (endTime - startTime) / size + " ns");
        REMOVEyAxis.add((endTime - startTime) / size);
       

    }
}
