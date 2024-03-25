
public abstract class eDevice implements Device , Comparable<eDevice>{

    String category;
    String name;
    double price;
    int quantity;


    /**
     * Constructor for eDevice
     * complexity: O(1)
     * @param category
     * @param name
     * @param price
     * @param quantity
     */
    public eDevice(String category, String name, double price, int quantity){
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    /**
     * Returns the category of the device
     * complexity: O(1)
     * @return the category of the device
     */
    public String getCategory(){
        return category;
    }


    /**
     * Returns the name of the device
     * complexity: O(1)
     * @return the name of the device
     */
    public String getName(){
        return name;
    }
    /**
     * Returns the price of the device
     * complexity: O(1)
     * @return the price of the device
     */
    public double getPrice(){
        return price;
    }

    /**
     * Returns the quantity of the device
     * complexity: O(1)
     * @return the quantity of the device
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Sets the category of the device
     * complexity: O(1)
     * @param category
     * @return void
     */
    public void setCategory(String category){
        this.category = category;
    }

    /**
     * Sets the name of the device
     * complexity: O(1)
     * @param name
     * @return void
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the price of the device
     * complexity: O(1)
     * @param price
     * @return void
     */
    public void setPrice(double price){
        this.price = price;
    }

    /**
     * Sets the quantity of the device
     * complexity: O(1)
     * @param quantity
     * @return void
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * Returns a string representation of the device
     * complexity: O(1)
     * @return a string representation of the device
     */
    @Override
    public String toString(){
        return "Category: " + category + ", Name: " + name + ", Price: " + String.format("%.2f", this.price) + ", Quantity: " + quantity;
    }


    /**
     * Returns if the device is equal to object
     * complexity: O(1)
     * @param obj
     * @return if the device is equal to object
     */
    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(!(obj instanceof eDevice)){
            return false;
        }
        eDevice device = (eDevice) obj;
        return device.getCategory().equals(category) && device.getName().equals(name) && device.getPrice() == price && device.getQuantity() == quantity;
    }
    
    public int compareTo(eDevice device){
        if(this.getPrice() > device.getPrice()){
            return 1;
        }
        else if(this.getPrice() < device.getPrice()){
            return -1;
        }
        else{
            return 0;
        }
    }
}