package hw4;

public class File extends FileSystemElement{
    
    File(String name, Directory parent){
        super(name, parent);
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + "File: "+getName());
    }
}
