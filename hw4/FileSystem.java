package hw4;

import java.util.LinkedList;

public class FileSystem {
    
    private Directory root;

    FileSystem (){
        this.root = new Directory("root", null);
    }

    public FileSystemElement createFile(String name, Directory parent){
        return new File(name, parent);
    }

    public FileSystemElement createDirectory(String name, Directory parent){
        return new Directory(name, parent);
    }

    public void delete(FileSystemElement element){

        if(element instanceof Directory){

            ((Directory)element).deleteContent((Directory)element);
            element = null;
        }
        else{
            element = null;

        }
        
    }
    public void displayCurrentPath(FileSystemElement e){

        if( e.getName() == "root" ){
            System.out.print("/");
            return;
        }

        displayCurrentPath(e.getParent());
        System.out.print(e.getName() + "/");

    }

    public void search(String name, FileSystemElement e){

        if(e.getName().equals(name)){
            displayCurrentPath(e);
            
        }

        if(e instanceof Directory){
            for(FileSystemElement child : ((Directory)e).getChild()){
                search(name, child);
            }
        }
    }

    public void printTree(FileSystemElement e){

        LinkedList <FileSystemElement> parents = new LinkedList<FileSystemElement>();
        while(e.getParent() != null){
            parents.add(e);
            e = e.getParent();
        }
        System.out.println("* root/");
        for(int i = 0; i < parents.size(); i++){

            System.out.print("  ");
        }
    }

}
