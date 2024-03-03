public class Operator extends Person{
    private int wage;
    private Costumer [] costumers;

    public Operator(String name, String surname, String address, String phone, int ID, int wage){
        super(name, surname,address, phone, ID);
        this.wage = wage;
        costumers = new Costumer[100];
    }

    public void print_Operator(){
        System.out.println("Name & Surname: " + getName() + " " + getSurname());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhone());
        System.out.println("ID: " + getID());
        System.out.println("Wage: " + wage);

        print_costumers();

    }

    public void print_costumers(){

        for ( int i =0  ; i < costumers.length ; i++){
            if(costumers[i] == null){
                break;
            }
            System.out.println("----------------------------");
            System.out.print("Costumer #" + (i+1) );
            if(costumers[i] instanceof Retail_Customer){
                System.out.println(" (Retail Costumer): ");
            }
            else if(costumers[i] instanceof Corparate_Customer){
                System.out.println(" (Corparate Costumer): ");
            }
           
            costumers[i].print_costumer();
        }
    }

    public void define_costumers(Costumer [] c){
        costumers = c;
    }

    public void add_costumer(Costumer c){
        for (int i = 0; i < costumers.length; i++){
            if (costumers[i] == null){
                costumers[i] = c;
                break;
            }
        }
    }
}