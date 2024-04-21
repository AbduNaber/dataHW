import java.io.File;
import java.util.Scanner;


/**
 * This class is used to read the file and create the objects of the classes.
 * that classes are Order, Costumer, Operator.
 * also checks the validity of the lines in the file.
 */
public class readFile {
    
    private String fileName; // Name of the file
    private File file;

    
    private Order [] orders ; // Orders read from file
    private int orderCount = 0;

    private Costumer [] costumers; // Costumers read from file
    private int costumerCount = 0;

    private Operator [] operators; // Operatorsread from file
    private int operatorCount = 0;

    public readFile(String fileName){

        orders = new Order[100]; 
        costumers = new Costumer[100];
        operators = new Operator[100];


        this.fileName = fileName;
        

        file = new File(this.fileName);
        
        try {
            Scanner fileScanner = new Scanner(file); // file input to read line by line
            
            while(fileScanner.hasNextLine()){  
                
                String fileLine = fileScanner.nextLine();
                
                String [] parsedLine = fileLine.split(";",-1); // splits according to ";" , -1 for splits all pieces.
                
                
                if( isValidLine(parsedLine) == 1) { // if parsed line is valid 
                   
                   if(IDChecker(Integer.parseInt(parsedLine[5])) == 1){
                        //System.out.println("ID is already used.");
                        continue;

                     }
                    // if that line is order's line
                    if(parsedLine[0].equals("order")){
                        
                        Order o = new Order(parsedLine[1], Integer.parseInt(parsedLine[2]), Integer.parseInt(parsedLine[3]), Integer.parseInt(parsedLine[4]), Integer.parseInt(parsedLine[5]));
                        
                        orders[orderCount] = o;
                        orderCount++;
                       
                    }

                    // if that line is retail_customer's line
                    else if(parsedLine[0].equals("retail_customer") ){
                        Retail_Customer r = new Retail_Customer(parsedLine[1], parsedLine[2], parsedLine[3], parsedLine[4], Integer.parseInt(parsedLine[5]), Integer.parseInt(parsedLine[6]));
                        costumers[costumerCount] = r;
                        costumerCount++;
                        
                    }

                    //if that line is corporate_customer's line
                    else if(parsedLine[0].equals("corporate_customer")){
                        Corparate_Customer c = new Corparate_Customer(parsedLine[1], parsedLine[2], parsedLine[3], parsedLine[4], Integer.parseInt(parsedLine[5]), Integer.parseInt(parsedLine[6]), parsedLine[7]);
                        costumers[costumerCount] = c;
                        costumerCount++;
                       
                    }

                    // if that line is operator's class
                    else if(parsedLine[0].equals("operator")){
                        Operator op = new Operator(parsedLine[1], parsedLine[2], parsedLine[3], parsedLine[4], Integer.parseInt(parsedLine[5]), Integer.parseInt(parsedLine[6]));
                        operators[operatorCount] = op;
                        operatorCount++;
                        
                    }   
            }
            
            
            
            }
            fileScanner.close(); // close file input
        }
        catch (Exception e){
            System.out.println(e);
        }
    

    }

   public File getFile() {
        return file;
    }

    public String getFileName() {
        return fileName;
    }

    public Order[] getOrders() {
        return orders;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public Costumer[] getCostumers() {
        return costumers;
    }

    public int getCostumerCount() {
        return costumerCount;
    }

    public Operator[] getOperators() {
        return operators;
    }

    public int getOperatorCount() {
        return operatorCount;
    }


    /**
     * checks validity of lines
     */
    private int isValidLine(String [] parsedLine){
        
        if(parsedLine[0].equals("order")){
            
            
            if(parsedLine.length != 6){
                //System.out.println("The line is not valid.(LENGTH PROBLEM)");
                return 0;
                
            }
            if(parsedLine[1].isEmpty()){
                //System.out.println("The line is not valid.(INVALID ORDER NAME)");
                return 0;
            }

            try{
                int count = Integer.parseInt(parsedLine[2]);
                int total_price = Integer.parseInt(parsedLine[3]);
                int status = Integer.parseInt(parsedLine[4]);
                int costumer_id = Integer.parseInt(parsedLine[5]);

                if( count <= 0 || total_price <= 0 || status < 0 || costumer_id <= 0 || status > 3){
                    //System.out.println("The line is not valid.(NON INTEGER VALUE)");
                    return 0;
                }
                
            }
            catch (Exception e) {
                //System.out.println("The line is not valid.(INVALID INTEGER)");
                return 0;
            }
            return 1;
            
        }

        else if(parsedLine[0].equals("retail_customer")){

            if( parsedLine.length != 7){
               // System.out.println("The line is not valid.(LENGTH PROBLEM)");
                return 0;
            }
            if(parsedLine[1].isEmpty() || parsedLine[2].isEmpty() || parsedLine[3].isEmpty() || parsedLine[4].isEmpty()){
               // System.out.println("The line is not valid.(EMPTY STRING)");
                return 0;
            }

            try {
                int ID = Integer.parseInt(parsedLine[5]);
                int op_ID = Integer.parseInt(parsedLine[6]);
                if( ID <= 0 || op_ID <= 0 || ID == op_ID){
                   // System.out.println("The line is not valid.(NON INTEGER VALUE)");
                    return 0;
                }

            }
            catch (Exception e) {
              //  System.out.println("The line is not valid.(INVALID INTEGER)");
                return 0;
            }
            return 1;
        }
        else if (parsedLine[0].equals("corporate_customer")){
            if( parsedLine.length != 8){
               // System.out.println("The line is not valid.(LENGTH PROBLEM)");
                return 0;
            }
            if(parsedLine[1].isEmpty() || parsedLine[2].isEmpty() || parsedLine[3].isEmpty() || parsedLine[4].isEmpty() || parsedLine[7].isEmpty()){
              //  System.out.println("The line is not valid.(EMPTY STRING)");
                return 0;
            }
            try {
                int ID = Integer.parseInt(parsedLine[5]);
                int op_ID = Integer.parseInt(parsedLine[6]);
                if( ID <= 0 || op_ID <= 0 || ID == op_ID){
                  //  System.out.println("The line is not valid.(NON INTEGER VALUE)");
                    return 0;
                }

            }
            catch (Exception e) {
               // System.out.println("The line is not valid.(INVALID INTEGER)");
                return 0;
            }
            return 1;
        }
        else if ( parsedLine[0].equals("operator")){
            if( parsedLine.length != 7){
              //  System.out.println("The line is not valid.(LENGTH PROBLEM)");
                return 0;
            }
            if(parsedLine[1].isEmpty() || parsedLine[2].isEmpty() || parsedLine[3].isEmpty() || parsedLine[4].isEmpty()){
              //  System.out.println("The line is not valid.(EMPTY STRING)");
                return 0;
            } 
            try {
                int ID = Integer.parseInt(parsedLine[5]);
                int wage = Integer.parseInt(parsedLine[6]);
                if( ID <= 0 || wage <= 0){
                //    System.out.println("The line is not valid.(NON INTEGER VALUE)");
                    return 0;
                }

            }
            catch (Exception e) {
              //  System.out.println("The line is not valid.(INVALID INTEGER)");
                return 0;
            }
            return 1;
        }

        else {
           // System.out.println("Unkown IDENTIFIER");
            return 0;
        }
    }
    private int IDChecker(int ID){
        for (int i = 0; i < costumerCount; i++){
            if (costumers[i].getID() == ID){
                return 1;
            }
        }
        for (int i = 0; i < operatorCount; i++){
            if (operators[i].getID() == ID){
                return 1;
            }
        }
        return 0;
    }
    
    
}
