package hw4;

import java.sql.Timestamp;

public abstract class FileSystemElement {
    private String name;
    private Timestamp dateCreated;
    private FileSystemElement parent;

    FileSystemElement(String name, FileSystemElement parent) {
        this.name = name;
        this.parent = parent;
        this.dateCreated = new Timestamp(System.currentTimeMillis());
    }

    public FileSystemElement getParent(){
        return parent;
    }
    public String getName() {
        return name;
    }

    public Timestamp getDateCreated(){
        return dateCreated;
    }

    public abstract void print(String prefix);
        


}