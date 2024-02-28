public class Operator extends Person{
    private int wage;
    private Costumer [] costumers;


    public void print_Operator(){

    }

    public void print_costumers(){

        for ( int i =0  ; i < costumers.length ; i++){
            costumers[i].print_costumer();
        }
    }

    public void define_costumers(Costumer [] c){

    }
}