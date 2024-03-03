public class Operator extends Person{
    private int wage;
    private Costumer [] costumers;


    public void print_Operator(){
        System.out.println("Name & Surname: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhone());
        System.out.println("ID: " + getID());
        System.out.println("Wage: " + wage);

        print_costumers();

    }

    public void print_costumers(){

        for ( int i =0  ; i < costumers.length ; i++){
            System.out.println("Costumer #" + (i+1) );
            if(costumers[i] instanceof Retail_Customer){
                System.out.println(" (Retail Costumer) ");
            }
            else if(costumers[i] instanceof Corparate_Customer){
                System.out.println(" Corparate Costumer");
            }
            System.out.println("=> ");
            costumers[i].print_costumer();
        }
    }

    public void define_costumers(Costumer [] c){
        costumers = c;
    }
}