package hw4;

import java.util.LinkedList;

public class Directory extends FileSystemElement{

    LinkedList<FileSystemElement> children ;
    

    /**
     * Constructor for Directory
     * @param name
     * @param parent
     */
    public Directory(String name, Directory parent){
        super(name, parent);
        children = new LinkedList<FileSystemElement>();
        if(parent != null)
            parent.add(this);

        
    }

    /**
     * Add a child to the directory
     * @param child
     */
    public void add(FileSystemElement child){
        children.add(child);
    }

    /**
     * Remove a child from the directory
     * @param child
     */
    public void remove(FileSystemElement child){
        children.remove(child);
    }

    /**
     * Get the children of the directory
     * @return children
     */
    public LinkedList<FileSystemElement> getChild(){
        return children;
    }

    /**
     * Delete the content of the directory
     * @param child
     */
    public void deleteContent(Directory child){
        
        for(FileSystemElement e : child.getChild()){

            if(e instanceof Directory){
                deleteContent((Directory)e);
            }

            e = null;
        }

        
    }

    /**
     * Print the directory with the date created
     * @param prefix
     */
    public void printwithDate(String prefix) {
        
        for(FileSystemElement e : this.getChild()){
            
            System.err.println(prefix + e.getName() + " " + e.getDateCreated() );
            
        }
    }
    @Override  
    public void print(String prefix) {
        
        for(FileSystemElement e : this.getChild()){
            
            
            if(e instanceof Directory){
                ((Directory)e).print( "  " + prefix, 1);
            }
            e.print( "  " + prefix);
        }
    }

    /**
     * Print the directory
     * @param prefix
     * @param flag
     */
    public void print(String prefix,int flag) {
        System.out.println(prefix + getName() + "/");
    }

}