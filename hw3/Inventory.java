import java.util.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Inventory{

   private LinkedList <ArrayList<eDevice>> inventory ;

    /**
     * Constructor for the Inventory class
     * complexity: O(1)
     * @param none
     * @return void
     */
    public Inventory(){
        inventory = new LinkedList <ArrayList<eDevice>>();
    }
    
    /**
     * Creates a new device based on the category
     * complexity: O(1)
     * @param category
     * @param name
     * @param price
     * @param quantity
     * @return eDevice
     */
    public eDevice createDevice(String category,String name,double price,int quantity){
        
        switch(category){

            case "Smartphone":
                return new Smartphone(category,name,price,quantity);
            case "Laptop":
                return new Laptop(category,name,price,quantity);
            case "Camera":
                return new Camera(category,name,price,quantity);
            case "Tv":
                return new Tv(category,name,price,quantity);
            case "Watch":
                return new Watch(category,name,price,quantity);
            default:
                throw new IllegalArgumentException("Invalid category");

        }
        
    }
    
    /**
     * Adds a device to the inventory
     * complexity: O(n)
     * @param device
     * @return void
     */
    public void addDevice(eDevice device){

        boolean found = false;

        if(findDevice(device.getName()) != null){
            throw new IllegalArgumentException("Device already exists");
           
        }

        for (ArrayList<eDevice> list : inventory){
            if(list.get(0).getCategory().equals(device.getCategory())){
                list.add(device);
                found = true;
            }
        }

        if (!found){
            ArrayList<eDevice> list = new ArrayList<eDevice>();
            list.add(device);
            inventory.add(list);
        }
    }
    /**
     * Removes a device from the inventory
     * complexity: O(n)
     * @param device
     * @return void
     */
    public void removeDevice(eDevice device){

       
        System.out.println(device.getName() + " removed...");
        for (ArrayList<eDevice> list : inventory){
            if(list.get(0).getCategory().equals(device.getCategory())){
                list.remove(device);
            }
        }
       
    }
    
    /**
     * Updates a device in the inventory
     * complexity: O(n)
     * @param name
     * @return eDevice
     */
    public eDevice updateDevice(String name){

        
        eDevice tmp = this.findDevice(name) ;
        if(tmp == null){
            throw new IllegalArgumentException("Device not found");
        }
        System.out.println("Enter new price (leave blank to keep current price): ");   
        String newPrice = System.console().readLine();

        if(newPrice.length() > 0){
            tmp.setPrice(Double.parseDouble(newPrice));
        }
        System.out.println("Enter new quantity (leave blank to keep current quantity): ");
        String newQuantity = System.console().readLine();
        if(newQuantity.length() > 0){
            tmp.setQuantity(Integer.parseInt(newQuantity));
        }

        System.out.println(name + " updated...");
        return tmp;
    }

   /**
     * Finds the cheapest device in the inventory
     * complexity: O(n)
     * @param none
     * @return eDevice
     */
    public eDevice findCheapest(){
        eDevice cheapest = inventory.get(0).get(0);
        for (ArrayList<eDevice> list : inventory){
            for (eDevice d : list){
                if(d.getPrice() < cheapest.getPrice()){
                    cheapest = d;
                }
            }
        }
        return cheapest;
    }

    /**
     * Displays the inventory
     * complexity: O(n)
     * @param none
     * @return void
     */
    public void displayInventory(){
        System.out.println("Device List: ");
        int i =1;
        for (ArrayList<eDevice> list : inventory){
            for (eDevice d : list){
                
                System.out.println(i +". " + d.toString());
                i++;
            }
        }
        if(i == 1){
            System.out.println("No devices in inventory");
        }
    }
    /**
     * Finds a device in the inventory
     * complexity: O(n)
     * @param DeviceName 
     * @return eDevice 
     */
    public eDevice findDevice(String  DeviceName){
        for (ArrayList<eDevice> list : inventory){
            for (eDevice d : list){
                if(d.getName().equals(DeviceName)){
                    return d;
                }
            }
        }
        return null;
    }
    /**
     * Sorts the inventory by price
     * complexity: O(nlogn)
     * @param none
     * @return void
     */
    public void sortInventory(){


        ArrayList<eDevice> allDevices = new ArrayList<eDevice>();
        for (ArrayList<eDevice> list : inventory){
            for (eDevice d : list){
                allDevices.add(d);
            }
        }
        Collections.sort(allDevices);

        
        int i = 1;
        System.out.println("Devices sorted by price: ");

        for (eDevice d : allDevices){
            System.out.println(i + d.toString());
            i++;
        }
    }

    /**
     * Calculates the total value of the inventory
     * complexity: O(n)
     * @param none
     * @return double
     */
    public double getInventoryValue(){
        double total = 0;
        for (ArrayList<eDevice> list : inventory){
            for (eDevice d : list){
                total += d.getPrice() * d.getQuantity();
            }
        }
        return total;
    }
    /**
     * Restocks a device
     * complexity: O(n)
     * @param name
     * @return void
     */
    public void restockDevice(String name){

        eDevice tmp = this.findDevice(name) ;
        if(tmp == null){
            throw new IllegalArgumentException("Device not found");
        }
        System.out.println("Do you want to add or remove stock? (Add/Remove): ");
        String action = System.console().readLine();
        if(action.equals("Add")){
            System.out.println("Enter quantity to add: ");
            int add = Integer.parseInt(System.console().readLine());
            tmp.setQuantity(tmp.getQuantity()+add);
        }
        else if(action.equals("Remove")){
            System.out.println("Enter quantity to remove: ");
            int remove = Integer.parseInt(System.console().readLine());
            tmp.setQuantity(tmp.getQuantity()-remove);
        }
        else{
            throw new IllegalArgumentException("Invalid action");
        }
        System.out.println(name + " restocked...");
    }
    
    /**
     * Exports a report of the inventory
     * complexity: O(n)
     * @param none
     * @return void
     */
    public void exportReport(){
        System.out.println("Exporting report...");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"));
            writer.write("Electronics Shop Inventory Report\n");
            writer.write("Generated on: "+ new Date() + "\n");
            writer.write("---------------------------------------\n");
            writer.write("| No. | Category    | Name                | Price   | Quantity |\n");
            writer.write("---------------------------------------\n");
            int i = 1;
            for (ArrayList<eDevice> list : inventory){
                for (eDevice d : list){
                    writer.write("| " + i + " | " + d.getCategory() + " | " + d.getName() + " | " + String.format("%.2f", d.getPrice()) + " | " + d.getQuantity() + " |\n");
                    i++;
                }
            }
            writer.write("---------------------------------------\n");

            writer.write("Summary:\n");
            writer.write("Total number of devices: " + (i -1)+ "\n");
            writer.write("Total inventory value: " + getInventoryValue() + "\n");
            writer.write("End of report\n");
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Couldn't write to file");
        }


    }
    public boolean isEmpty(){
        return inventory.isEmpty();
    }
}