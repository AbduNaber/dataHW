public class Corparate_Customer extends Costumer {
    private String company_name;

    @Override
    public void print_costumer() {
        System.out.println("Name & Surname: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhone());
        System.out.println("ID: " + getID());
        System.out.println("Operator ID: " + getOperatorID());
        System.out.println("Company Name: " + company_name);
        super.print_orders();
    }
}
