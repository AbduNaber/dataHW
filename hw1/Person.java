public class Person {
    
    private String name;
    private String surname;
    private String address;
    private String phone;
    private int ID;



    public Person(String name, String surname, String adress, String phone, int ID){
        this.name = name;
        this.surname = surname;
        this.address = adress;
        this.phone = phone;
        this.ID = ID;
    }


    public Person(){
        this.name = "";
        this.surname = "";
        this.address = "";
        this.phone = "";
        this.ID = 0;
    }

    

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getAddress(){
        return address;
    }

    public String getPhone(){
        return phone;
    }

    public int getID(){
        return ID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setAdress(String adress){
        this.address = adress;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setID(int ID){
        this.ID = ID;
    }
    
    public String toString(){
        return "Name: " + name + " Surname: " + surname + " Adress: " + address + " Phone: " + phone + " ID: " + ID;
    }

}
