public class TrackingProgram {
    public static void main(String[] args) {


        // arrays for file outputs
        Order [] orders = new Order[100];
        Costumer [] costumers = new Costumer[100];
        Operator [] operators = new Operator[100];
    	

        readFile file = new readFile("content.txt"); // file that read

	
        orders = file.getOrders(); // orders arr from file
        costumers = file.getCostumers(); // costumers arr from file
        operators = file.getOperators(); // operator arr from file
        

        Order [] tempOrders ;
        Costumer [] tempCostumers ;
        
        int t;
        // fill Costumer's order with orders from file
        for (int i = 0; i < file.getCostumerCount(); i++){   
            
            tempOrders = new Order[100];
            t = 0;
            for (int j = 0; j < file.getOrderCount() ; j++){
                if (orders[j].getCostumerID() == costumers[i].getID()){
                    tempOrders[t] = orders[j];
                    t++;
                }
            }
            costumers[i].define_orders(tempOrders);
        }

        // fill operator's costumer with costumer from file
        for (int i = 0; i < file.getOperatorCount() ; i++){
            tempCostumers = new Costumer[100];
            t=0;
            for (int j = 0; j <file.getCostumerCount() ; j++){
                
                if (costumers[j].getOperatorID() == operators[i].getID()){
                    
                    tempCostumers[t] = costumers[j];
                    t++;
                }
            }
            operators[i].define_costumers(tempCostumers);
        }


        int choiceID; // to read from console
        String tmp = "" ;// to read from console
        int flag; // to check if there is a person with this ID
 
      
            System.out.println("Please enter your ID...");
            try{
                tmp = System.console().readLine();
                choiceID = Integer.parseInt(tmp);
            }
            catch (Exception e){
                System.out.println("No operator/customer was found with ID 1503. Please try again.");
                return ;
            }
            
            flag = 0;
            for (int i = 0; i < file.getOperatorCount(); i++){
                if (choiceID == operators[i].getID()){
                    System.out.println("*** Operator Screen ***");
                    System.out.println("----------------------------");
                    operators[i].print_Operator();
                    System.out.println("----------------------------");
                    flag = 1;
                }
            }
            if(flag == 0){
                for (int i = 0; i < file.getCostumerCount(); i++){
                    if (choiceID == costumers[i].getID()){
                        System.out.println("*** Costumer Screen ***");
                        System.out.println("----------------------------");
                        costumers[i].print_costumer();
                        System.out.println("----------------------------");
                        flag = 1;
                    }
                }
            }
            if(flag == 0){
                System.out.println("THERE IS NO PERSON WTIH THIS ID!");
                System.out.println("----------------------------");
                return ;
            }



        }




    }




