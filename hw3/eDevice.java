public abstract class eDevice implements Device{

    String category;
    String name;
    int price;
    int quantity;



    public eDevice(String category, String name, int price, int quantity){
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCategory(){
        return category;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(int price){
        this.price = price;
    }


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
        return "Category: " + category + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity;
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

}