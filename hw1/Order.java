public class Order {

    private String product_name;
    private int count;
    private int total_price;
    private int status;
    private int CostumerID;


    public Order(String product_name, int count, int total_price, int status, int CostumerID){
        this.product_name = product_name;
        this.count = count;
        this.total_price = total_price;
        this.status = status;
        this.CostumerID = CostumerID;
    }

    public Order(){
        this.product_name = "";
        this.count = 0;
        this.total_price = 0;
        this.status = 0;
        this.CostumerID = 0;
    }

    public void print_order(){

        System.out.print("Product name: " + product_name);
        System.out.print(" - Count: " + count);
        System.out.print(" - Total price: " + total_price);
        System.out.println(" - Status: " + status);
        
        
    }
    
    public boolean equals(Object o){

        if (o == this){
            return true;
        }

        if (o instanceof Order){
            Order p = (Order) o;
            return product_name.equals(p.product_name) && count == p.count && total_price == p.total_price && status == p.status && CostumerID == p.CostumerID;
        }
        else{
            return false;
        }
    }

}
