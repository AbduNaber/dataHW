/**
 * Device
 */
public interface Device {

    /**
     * Get the category of the device 
     * complexity: O(1)
     * @return the category of the device
     */
    public String getCategory();


    /**
     * Get the name of the device
     * complexity: O(1)
     * @return the name of the device
     */
    public String getName();


    /**
     * Get the price of the device
     * complexity: O(1)
     * @return the price of the device
     */
    public double getPrice();


    /**
     * Get the quantity of the device
     * complexity: O(1)
     * @return  the quantity of the device
     */
    public int getQuantity();

    /**
     * Set the category of the device
     * complexity: O(1)
     * @param category
     * @return void
     */
    public void setCategory(String category);


    /**
     * Set the name of the device
     * complexity: O(1)
     * @param name
     * @return void
     */
    public void setName(String name);


    /**
     * Set the price of the device
     * complexity: O(1)
     * @param price
     * @return void
     */
    public void setPrice(double price);


    /**
     * Set the quantity of the device
     * complexity: O(1)
     * @param quantity
     * @return void
     */
    public void setQuantity(int quantity);


    
}