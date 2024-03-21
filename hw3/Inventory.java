import java.util.*;

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


    public void addDevice(eDevice device){

        boolean found = false;

        if(findDevice(device.getName()) == null){
            return;
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

    public void removeDevice(eDevice device){

        if(findDevice(device.getName())== null){
            throw new IllegalArgumentException("Device not found");
        }

        for (ArrayList<eDevice> list : inventory){
            if(list.get(0).getCategory().equals(device.getCategory())){
                list.remove(device);
            }
        }
    }
    public eDevice updateDevice(String name,String input1,String input2){

        eDevice d = findDevice(name);

        if(d == null){
            throw new IllegalArgumentException("Device not found");
        }

        if(input1.equals("")){

        }
        else{
            d.setPrice(Integer.parseInt(input1));

        }

        if(input2.equals("")){

        }
        else{
            d.setQuantity(Integer.parseInt(input2));
        }
        return d;
    }

    
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

    public void displayInventory(){
        for (ArrayList<eDevice> list : inventory){
            for (eDevice d : list){
                System.out.println(d);
            }
        }
    }
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


}