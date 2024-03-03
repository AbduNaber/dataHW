public class Costumer extends Person{
    

    private Order [] orders;
    private int operator_ID;

    public void print_costumer(){
        System.out.println("Name & Surname: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhone());
        System.out.println("ID: " + getID());
        System.out.println("Operator ID: " + operator_ID);
        print_orders();
    }

    protected void print_orders(){
        
        for ( int i =0  ; i < orders.length ; i++){
            System.out.println("Order #" + (i+1) + " => ");    
            orders[i].print_order();
        }
    }

    public void define_order(Order [] o){
        orders = o;
    }

    public void setOperatorID(int id){
        operator_ID = id;
    }

    public int getOperatorID(){
        return operator_ID;
    }
    
}
