package hw4;

import java.util.LinkedList;

public class Directory extends FileSystemElement{

    LinkedList<FileSystemElement> children ;
    
    public Directory(String name, Directory parent){
        super(name, parent);
        children = new LinkedList<FileSystemElement>();
        
    }

    public void add(FileSystemElement child){
        children.add(child);
    }

    public void remove(FileSystemElement child){
        children.remove(child);
    }


    public LinkedList<FileSystemElement> getChild(){
        return children;
    }

    public void deleteContent(Directory child){
        
        for(FileSystemElement e : child.getChild()){

            if(e instanceof Directory){
                deleteContent((Directory)e);
            }

            e = null;
        }

        
    }

    @Override  
    public void print(String prefix) {
        System.out.println(prefix +getName());
        for(FileSystemElement e : children){
            e.print(prefix + "  ");
        }
    }
}
