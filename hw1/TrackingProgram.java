public class TrackingProgram {
    public static void main(String[] args) {


        // arrays for file outputs
        Order [] orders = new Order[100];
        Costumer [] costumers = new Costumer[100];
        Operator [] operators = new Operator[100];
    

        readFile file = new readFile("content"); // file that read


        orders = file.getOrders(); // orders arr from file
        costumers = file.getCostumers(); // costumers arr from file
        operators = file.getOperators(); // operator arr from file

        // fill Costumer's order with orders from file
        for (int i = 0; i < file.getOrderCount(); i++){   
            for (int j = 0; j < file.getCostumerCount(); j++){
                if (orders[i].getCostumerID() == costumers[j].getID()){
                    costumers[j].add_order(orders[i]);
                }
            }
        }

        // fill operator's costumer with costumer from file
        for (int i = 0; i < file.getCostumerCount(); i++){
            for (int j = 0; j < file.getOperatorCount(); j++){
                if (costumers[i].getOperatorID() == operators[j].getID()){
                    operators[j].add_costumer(costumers[i]);
                }
            }
        }


        // MENU (-1 for exit)
        int choiceID = 0;
        String tmp = "" ;
        int flag;
        while( choiceID != -1){
            System.out.println("Please enter your ID...");
            try{
                tmp = System.console().readLine();
                choiceID = Integer.parseInt(tmp);
            }
            catch (Exception e){
                System.out.println("Please enter a valid ID");
            }
            if (choiceID == -1){
                System.out.println("Goodbye!");
                break;
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
            }



        }




    }


}

