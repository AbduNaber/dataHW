package hw4;

import java.sql.Timestamp;

public abstract class FileSystemElement {

    private String name;
    private Timestamp dateCreated;
    private FileSystemElement parent;


    /**
     * Constructor for FileSystemElement
     * @param name
     * @param parent
     */
    FileSystemElement(String name, FileSystemElement parent) {
        this.name = name;
        this.parent = parent;
        this.dateCreated = new Timestamp(System.currentTimeMillis());
    }

    /**
     * Get the parent of the FileSystemElement
     * @return parent
     */
    public FileSystemElement getParent(){
        return parent;
    }

    /**
     * Get the name of the FileSystemElement
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Get the date the FileSystemElement was created
     * @return dateCreated
     */
    public Timestamp getDateCreated(){
        return dateCreated;
    }

    /**
     * Set the parent of the FileSystemElement
     * @param parent
     */
    public void setParent(FileSystemElement parent){
        this.parent = parent;
    }
    

    /**
     * Print the FileSystemElement
     * @param prefix
     */
    public abstract void print(String prefix);
        


}