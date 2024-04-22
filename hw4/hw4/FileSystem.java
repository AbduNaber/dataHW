package hw4;

import java.util.Collections;
import java.util.LinkedList;

public class FileSystem {
    
    private Directory root;


    /**
     * Constructor for FileSystem
     * Initializes the root directory
     */
    FileSystem (){
        this.root = new Directory("root", null);
    }


    /**
     * Create a file
     * @param name
     * @param parent
     * @return File
     */
    public FileSystemElement createFile(String name, Directory parent){
        return new File(name, parent);
    }

    /**
     * Create a directory
     * @param name
     * @param parent
     * @return Directory
     */
    public FileSystemElement createDirectory(String name, Directory parent){
        return new Directory(name, parent);
    }

    /**
     * Delete a FileSystemElement
     * @param element
     */
    public void delete(FileSystemElement element){
        if(element == root){
            System.out.println("Cannot delete root");
            return;
        }

       
        if(element instanceof Directory){

            ((Directory)element).deleteContent((Directory)element);
            
        }
        
    }

    /**
     * Display the current path
     * @param e
     */
    public void displayCurrentPath(FileSystemElement e){
        
        if( e.getName() == "root" ){
            System.out.print("/");
            return;
        }

        displayCurrentPath(e.getParent());

        System.out.print(e.getName()  );
        if(e instanceof Directory){
            System.out.print("/");
        }

    }
    

    /**
     * Search for a FileSystemElement by name
     * @param name
     * @param e
     * @return FileSystemElement
     */
    public FileSystemElement searchByPath(String path,FileSystemElement root){
        // check if path is valid
        if(path == null || path.length() == 0){
            System.out.println("Invalid path");
            return null;
        }
        if(path.charAt(0) != '/'){
            System.out.println("Invalid path");
            return null;
        }
        

        String[] pathArray = path.split("/");
        FileSystemElement currentElement = root;
        for(int i=1; i<pathArray.length; i++){
            if(currentElement instanceof Directory){
                boolean found = false;
                for(FileSystemElement child : ((Directory)currentElement).getChild()){
                    if(child.getName().equals(pathArray[i])){
                        currentElement = child;
                        found = true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("Invalid path");
                    return null;
                }
            }
            else{
                System.out.println("Invalid path");
                return null;
            }
        }


        return currentElement;
        
    }
    
    /**
     * Get the path of a FileSystemElement
     * @param name
     * @param root
     * @return Path
     */
    public String getPath(String name,FileSystemElement root){
        String result = "";
        LinkedList <FileSystemElement> parents = new LinkedList<FileSystemElement>();
        FileSystemElement e = root;
        while(root.getParent() != null){
            parents.add(root);
            root = root.getParent();
        }
        Collections.reverse(parents);

        for(FileSystemElement e1 : parents){
            result = result + "/" + e1.getName();
        }
        return result;

    }
    

    /**
     * Search for a FileSystemElement by name
     * @param name
     * @param e
     * @return FileSystemElement
     */
    public FileSystemElement search(String name, FileSystemElement e){
        

        if(e.getName().equals(name)){
            System.out.print("Found: ");
            displayCurrentPath(e);
            System.out.println();
            return e;
        }

        if(e instanceof Directory){
            for(FileSystemElement child : ((Directory)e).getChild()){
                FileSystemElement r = search(name, child);
                if(r != null){
                    return r;
                }
            }
        }

        
       return null;
        
    }


    /**
     * Sort the FileSystemElement by name
     * @param e
     */
    public void sortByDateCreated(FileSystemElement e){
        if(e instanceof Directory){
            Collections.sort(((Directory)e).getChild(), (a, b) -> a.getDateCreated().compareTo(b.getDateCreated()));
            for(FileSystemElement child : ((Directory)e).getChild()){
                sortByDateCreated(child);
            }
        }
    }
    


    /**
     * Print the tree
     * @param e
     */
    public void printTree(FileSystemElement e){

        LinkedList <FileSystemElement> parents = new LinkedList<FileSystemElement>();
        FileSystemElement root = e;
        while(root.getParent() != null){
            parents.add(root);
            root = root.getParent();
        }
        
    
        System.out.println("* root/");
        String prefix = "  * ";
        Collections.reverse(parents);
        for(FileSystemElement parent : parents){
            ((Directory)parent).print(prefix, 0);
            prefix = "  " + prefix;
            
        }

        e.print(prefix);



    }

}
