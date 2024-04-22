package hw4;

public class Main {
    public static void main(String[] args) {

        FileSystem fs = new FileSystem();
        FileSystemElement root = new Directory("root", null);
        FileSystemElement currentElement = root;
        int menu = -1;
        
        while( menu != 9) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("===== File System Management Menu =====");
            System.out.println("1. Change directory");
            System.out.println("2. List directory contents");
            System.out.println("3. Create file/directory");
            System.out.println("4. Delete file/directory");
            System.out.println("5. Move file/directory");
            System.out.println("6. Search file/directory");
            System.out.println("7. Print directory tree");
            System.out.println("8. Sort contents by date created");
            System.out.println("9. Exit");
            System.out.print("Please select an option: ");

            try{
                menu = Integer.parseInt(System.console().readLine());
                
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input. Please enter a number.");
                menu = -1;
            }

            switch( menu ){
                case 1:
                    System.out.print("Current Path: ");
                    fs.displayCurrentPath(currentElement);
                    System.out.println();
                    System.out.print("Enter new directory path: ");
                    String path = System.console().readLine();
                    FileSystemElement newElement = fs.searchByPath(path, root);
                    if (newElement != null && newElement instanceof Directory){
                        currentElement = newElement;
                        System.out.println("Current directory changed to: " + path);
                    }
                    else{
                        System.out.println("Invalid path.");
                    }
                    break;
                case 2:
                    System.out.print("Listing Content of " );  
                    fs.displayCurrentPath(currentElement);
                    System.out.println();
                    
                    ((Directory)currentElement).print(" * ");
                    break  ;
                case 3:
                    System.out.print("Current Path: ");
                    fs.displayCurrentPath(currentElement);
                    System.out.println();
                    System.out.print("Create file or directory (f/d): ");

                    String type = System.console().readLine();

                    if(type.equals("f")){
                        System.out.print("Enter name for new file: ");
                        String name = System.console().readLine();
                        new File(name, (Directory)currentElement);
                        if(fs.search(name, currentElement) != null){
                            System.out.println("File already exists.");
                            break;
                        }
                        System.out.println("File created: " + name);
                    }
                    else if(type.equals("d")){
                        System.out.print("Enter name for new directory: ");
                        String name = System.console().readLine();
                        if(fs.search(name, currentElement) != null){
                            System.out.println("File already exists.");
                            break;
                        }
                        new Directory(name, (Directory)currentElement);
                        System.out.println("Directory created: " + name);
                    }
                    else{
                        System.out.println("Invalid input.");
                    }

                    break;
                case 4:
                System.out.print("Current Path: ");
                    fs.displayCurrentPath(currentElement);
                    System.out.println();
                    System.out.print("Enter name of file/directory to delete: ");
                    
                    String name = System.console().readLine();

                    if(name.equals("root")){
                        System.out.println("Cannot delete root.");
                        break;
                    }
                    FileSystemElement element = fs.search(name, currentElement);
                    
                    if (element != null){
                        fs.delete(element);
                        ((Directory)element.getParent()).remove(element);
                        System.out.println("Deleted: " + name);
                    }
                    else{
                        System.out.println("File/Directory not found.");
                    }
                    break;
                case 5: 
                    System.out.print("Current Path: ");
                    fs.displayCurrentPath(currentElement);
                    System.out.println();
                    System.out.print("Enter name of file/directory to move: ");
                    String name1 = System.console().readLine();
                    FileSystemElement element1 = fs.search(name1, currentElement);
                    if (element1 != null){
                        
                        System.out.print("Enter new path: ");
                        String path1 = System.console().readLine();
                        FileSystemElement element2 = fs.searchByPath(path1, currentElement);
                        if (element2 != null && element2 instanceof Directory){
                            
                            element1.setParent((Directory)element2);
                            ((Directory)element2).add(element1);
                            ((Directory)currentElement).remove(element1);
                            System.out.println("Moved: " + name1 + " to " + path1);
                        }
                        else{
                            System.out.println("Invalid path.");
                        }
                    }
                    else{
                        System.out.println("File/Directory not found.");
                    }
                    break;
                case 6:
                    System.out.print("Search query: "); 
                    String name2 = System.console().readLine(); 
                    FileSystemElement element3 = fs.search(name2, root);
                    
                    break;

                case 7:
                    System.out.println("Path to current directory from root: ");

                    fs.printTree(currentElement);
                    break;
                case 8:
                    System.out.print("Sorted" );
                    fs.displayCurrentPath(currentElement );
                    System.out.println(" by date created: ");
                    fs.sortByDateCreated(currentElement);
                    ( (Directory)currentElement).printwithDate("* ");
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    break;
            }

            System.console().readLine();   
        }
    }
}
