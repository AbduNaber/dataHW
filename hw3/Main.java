public class Main{
    /**
     * Main method for the program
     * complexity: analyzed based on the dominant operations within the loop. So we can not say spesific complexity.
     * @param args
     */
    public static void main(String[] args){
        
        Inventory inventory = new Inventory(); // create a new inventory object

        //variables for user input
        int option = -1;
        String category= "";
        String name = "";
        double price = 0.0;
        int quantity =0 ;
        eDevice tmp = null;
        //main loop
        System.out.println("Welcome to the Electronics Inventory Management System!");
        while(option != 0){

                
                System.out.println();
                System.out.println("Please select an option: ");
                System.out.println("1. Add a new device");
                System.out.println("2. Remove a device");
                System.out.println("3. Update device details");
                System.out.println("4. List all devices");
                System.out.println("5. Find cheapest device");
                System.out.println("6. Sort devices by price");
                System.out.println("7. Calculate total inventory value");
                System.out.println("8. Restock a device");
                System.out.println("9. Export inventory report");
                System.out.println("0. Exit");
                System.out.println();
                //get user input
                try{
                    option = Integer.parseInt(System.console().readLine());
                    if(option < 0 || option > 9){
                        throw new NumberFormatException();
                    }

                }
                catch(NumberFormatException e){
                    System.out.println("Invalid input. Please enter a number between 0 and 9.");
                    continue;
                }
                //    
                try{   
                    switch(option){
                        case 1:
                            
                                System.out.println("Enter category name: ");
                                category = System.console().readLine();
                                System.out.println("Enter device name: ");
                                name = System.console().readLine();
                                
                                if(name == null || name.equals(""))
                                    throw new IllegalArgumentException("invalid name");

                                System.out.println("Enter price: ");
                                price = Double.parseDouble(System.console().readLine());
                                System.out.println("Enter quantity: ");
                                quantity = Integer.parseInt(System.console().readLine());
                                eDevice device = inventory.createDevice(category,name,price,quantity);
                                inventory.addDevice(device);
                                System.out.println(category + " " + name + " " + String.format("%.2f", price)+ " "+ quantity +" amount added...");
                                break;
                        case 2:
                                if(inventory.isEmpty())
                                        throw new IllegalArgumentException("Inventory is empty");

                                System.out.println("Enter the device name you want to remove: ");
                                name = System.console().readLine();
                                tmp = inventory.findDevice(name) ;
                                if(tmp == null){
                                    throw new IllegalArgumentException("Device not found");
                                }
                                inventory.removeDevice(tmp);
                                break;

                        case 3:
                                if(inventory.isEmpty())
                                        throw new IllegalArgumentException("Inventory is empty");

                                System.out.println("Enter the device name you want to update: ");
                                name = System.console().readLine();
                                inventory.updateDevice(name);
                                break;
                        case 4:
                                if(inventory.isEmpty())
                                        throw new IllegalArgumentException("Inventory is empty");
                                inventory.displayInventory();
                                break;
                        case 5:
                                if(inventory.isEmpty())
                                        throw new IllegalArgumentException("Inventory is empty");

                                System.out.println("Cheapest device is: ");
                                tmp = inventory.findCheapest();
                                System.out.println(tmp);
                                break;
                        case 6:
                                if(inventory.isEmpty())
                                        throw new IllegalArgumentException("Inventory is empty");
                                inventory.sortInventory();
                                break;
                        case 7:
                                if(inventory.isEmpty())
                                        throw new IllegalArgumentException("Inventory is empty");
                                System.out.println("Total inventory value: " + String.format("%.2f",inventory.getInventoryValue())); 
                                break;           
                        case 8:
                                if(inventory.isEmpty())
                                        throw new IllegalArgumentException("Inventory is empty");
                                System.out.println("Enter the device name you want to restock: ");
                                name = System.console().readLine();
                                inventory.restockDevice(name);
                                break;
                        case 9:
                                inventory.exportReport();
                                break;
                        case 0:
                                System.out.println("Goodbye!");
                                break;
                        default:
                                throw new IllegalArgumentException("Invalid option");



                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                
        }

        
        


        


    }
}
