package hw4;

public class File extends FileSystemElement{
    

    /**
     * Constructor for File
     * @param name
     * @param parent
     */
    File(String name, Directory parent){
        super(name, parent);
        parent.add(this);
    }

    
    @Override
    public void print(String prefix) {
        System.out.println(prefix.substring(0, prefix.length()-2) +" " +getName());
    }
}
