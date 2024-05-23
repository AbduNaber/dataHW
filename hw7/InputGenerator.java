
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InputGenerator {
    String filename;
    ArrayList<String> symbols;
    ArrayList<String> commandsLines;
    String [] commands = {"ADD", "REMOVE", "SEARCH", "UPDATE"};

    public InputGenerator(String filename) {
        this.filename = filename;
        this.symbols = new ArrayList<>();
        this.commandsLines = new ArrayList<>();
    }

   private void createADD() {

        char [] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String symbol = alphabet[(int) (Math.random() * alphabet.length)] + "" + alphabet[(int) (Math.random() * alphabet.length)] + "" + alphabet[(int) (Math.random() * alphabet.length)];
        symbols.add(symbol);
        String line = "ADD " + symbol + " " + Math.random() * 100 + " " + (long) (Math.random() * 1000000) + " " + (long) (Math.random() * 1000000000);
        commandsLines.add(line);



        
    }

    private void createREMOVE() {

        if (symbols.size() > 0) {
            int index = (int) (Math.random() * symbols.size());
            String line = "REMOVE " + symbols.get(index);
            symbols.remove(index);
            commandsLines.add(line);
        } 
    }

    private void createSEARCH() {
        
        if (symbols.size() > 0) {
            int index = (int) (Math.random() * symbols.size());
            String line = "SEARCH " + symbols.get(index);
            commandsLines.add(line);
        }
    }

    private void createUPDATE() {
            char [] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            if (symbols.size() > 0) {
                int index = (int) (Math.random() * symbols.size());
                String symbol = alphabet[(int) (Math.random() * alphabet.length)] + "" + alphabet[(int) (Math.random() * alphabet.length)] + "" + alphabet[(int) (Math.random() * alphabet.length)];
                String line = "UPDATE " + symbols.get(index) + " " + symbol +" " + Math.random() * 100 + " " + (long) (Math.random() * 1000000) + " " + (long) (Math.random() * 1000000000);
                commandsLines.add(line);
            }
    }

    public void createInput(String cmd1, int size1,String cmd2 , int size2, String cmd3, int size3, String cmd4, int size4) {
        int [] arr = {size1, size2, size3, size4};
        int j = 0;
        for (int i = 0; i < size1 + size2 + size3 + size4; i++) {
            String command = commands[j];
            switch (command) {
                case "ADD":
                    createADD();
                    break;
                case "REMOVE":
                    createREMOVE();
                    break;
                case "SEARCH":
                    createSEARCH();
                    break;
                case "UPDATE":
                    createUPDATE();
                    break;
            }
            arr[j]--;
            if(arr[j] == 0){
                j++;
            }
        }
        
    }

    public void writeInput() {
        try {
            BufferedWriter writer = new BufferedWriter (new FileWriter(filename));
            for (String line : commandsLines) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            System.out.println("Input file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        InputGenerator inputGenerator = new InputGenerator("input.txt");
        inputGenerator.createInput(args[0], Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]), args[4], Integer.parseInt(args[5]), args[6], Integer.parseInt(args[7]));
        inputGenerator.writeInput();

    }


}
