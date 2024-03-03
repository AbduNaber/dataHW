public class Costumer extends Person{
    

    private Order [] orders;
    private int operator_ID;

    public Costumer(String name, String surname, String address, String phone, int ID, int operator_ID){
        super(name, surname, address, phone, ID);
        this.operator_ID = operator_ID;
        orders = new Order[100];
    }

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
            if(orders[i] == null){
                break;
            }
            System.out.print("Order #" + (i+1) + " => ");    
            orders[i].print_order();
        }
    }

    public void define_order(Order [] o){
        orders = o;
    }
    public void add_order(Order o){
        for (int i = 0; i < orders.length; i++){
            if (orders[i] == null){
                orders[i] = o;
                break;
            }
        }
    }

    public void setOperatorID(int id){
        operator_ID = id;
    }

    public int getOperatorID(){
        return operator_ID;
    }
    
}
