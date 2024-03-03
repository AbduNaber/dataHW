import java.io.File;
import java.util.Scanner;


public class readFile {
    
    private String fileName;
    private File file;

    private Order [] orders;
    private int orderCount = 0;

    private Costumer [] costumers;
    private int costumerCount = 0;

    private Operator [] operators;
    private int operatorCount = 0;


    public readFile(String fileName){
        this.fileName = fileName;
        file = new File(fileName);
        try {


            Scanner fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()){
                String fileLine = fileScanner.nextLine();
                
            }


            fileScanner.close();
        }

        catch (Exception e){
            System.out.println("File not found");
        }
        

    }


   public File getFile() {
        return file;
    }

    public String getFileName() {
        return fileName;
    }


    private boolean isValidLine(String [] parsedLine){
        if(parsedLine[0].isEmpty()){
            return false;
        }

        String [] typeList = {"order","retail_customer","corporate_customer","operator"};

        if(parsedLine[0] == "order"){

            if(parsedLine.length != 6){
                return false;
            }
            
        }



    }
    
}