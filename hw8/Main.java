import java.sql.Timestamp;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        // create a menu for the user to interact with the program
        System.out.println("===== Social Network Analysis Menu =====");
        int choice = 0;
        boolean exit = false;
        SocialNetworkGraph SocialNetworkGraph = new SocialNetworkGraph();
        Timestamp date;
        Timestamp date2;

      
        SocialNetworkGraph.addPerson("Alice", 25, Arrays.asList("Reading", "Hiking", "Swimming"));
        SocialNetworkGraph.addPerson("Bob", 30, Arrays.asList("Hiking", "Swimming", "Cooking"));
        SocialNetworkGraph.addPerson("Charlie", 35, Arrays.asList("Swimming", "Cooking", "Painting"));
        SocialNetworkGraph.addPerson("David", 40, Arrays.asList("Cooking", "Painting", "Gardening"));
        SocialNetworkGraph.addPerson("Eve", 45, Arrays.asList("Painting", "Gardening", "Reading"));
        SocialNetworkGraph.addPerson("Frank", 50, Arrays.asList("Gardening", "Reading", "Hiking"));
        SocialNetworkGraph.addPerson("Grace", 55, Arrays.asList("Reading", "Hiking", "Swimming"));
        SocialNetworkGraph.addPerson("Heidi", 60, Arrays.asList("Hiking", "Swimming", "Cooking"));
        SocialNetworkGraph.addPerson("Ivan", 65, Arrays.asList("Swimming", "Cooking", "Painting"));
        SocialNetworkGraph.addPerson("Judy", 70, Arrays.asList("Cooking", "Painting", "Gardening"));

        // add friendships
        SocialNetworkGraph.addFriendship("Alice",SocialNetworkGraph.getPeople().get("Alice").timestamp, "Bob", SocialNetworkGraph.getPeople().get("Bob").timestamp);
        SocialNetworkGraph.addFriendship("Alice",SocialNetworkGraph.getPeople().get("Alice").timestamp, "Charlie", SocialNetworkGraph.getPeople().get("Charlie").timestamp);
        SocialNetworkGraph.addFriendship("Alice",SocialNetworkGraph.getPeople().get("Alice").timestamp, "David", SocialNetworkGraph.getPeople().get("David").timestamp);
        SocialNetworkGraph.addFriendship("Alice",SocialNetworkGraph.getPeople().get("Alice").timestamp, "Eve", SocialNetworkGraph.getPeople().get("Eve").timestamp);
        SocialNetworkGraph.addFriendship("Alice",SocialNetworkGraph.getPeople().get("Alice").timestamp, "Frank", SocialNetworkGraph.getPeople().get("Frank").timestamp);
        SocialNetworkGraph.addFriendship("Eve",SocialNetworkGraph.getPeople().get("Eve").timestamp, "Frank", SocialNetworkGraph.getPeople().get("Frank").timestamp);
        SocialNetworkGraph.addFriendship("Eve",SocialNetworkGraph.getPeople().get("Eve").timestamp, "Grace", SocialNetworkGraph.getPeople().get("Grace").timestamp);
        SocialNetworkGraph.addFriendship("Eve",SocialNetworkGraph.getPeople().get("Eve").timestamp, "Heidi", SocialNetworkGraph.getPeople().get("Heidi").timestamp);
        SocialNetworkGraph.addFriendship("Ivan",SocialNetworkGraph.getPeople().get("Ivan").timestamp, "Judy", SocialNetworkGraph.getPeople().get("Judy").timestamp);
        SocialNetworkGraph.addFriendship("Ivan",SocialNetworkGraph.getPeople().get("Ivan").timestamp, "Heidi", SocialNetworkGraph.getPeople().get("Heidi").timestamp);
        SocialNetworkGraph.addFriendship("Ivan",SocialNetworkGraph.getPeople().get("Ivan").timestamp, "Grace", SocialNetworkGraph.getPeople().get("Grace").timestamp);

        Scanner scanner = new Scanner(System.in);
        
        while(!exit){
            try{
            System.out.println("1. Add a person");
            System.out.println("2. Remove person");
            System.out.println("3. Add friendship");
            System.out.println("4. Remove friendship");
            
            System.out.println("5. Find shortest path");
            System.out.println("6. Suggest friends");
            System.out.println("7. Count Cluster");
            System.out.println("8. Exit");
            System.out.print("Please select an option: ");
            

            
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice){
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter hobbies (comma separated): ");
                    String[] hobbies = scanner.nextLine().split(",");
                    List<String> hobbyList = Arrays.asList(hobbies);
                    SocialNetworkGraph.addPerson(name, age, hobbyList);
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter Person's timestamp: ");
                    date = Timestamp.valueOf(scanner.nextLine());

                    
                    SocialNetworkGraph.removePerson(name, date);
                    break;
                case 3:
                    System.out.print("Enter name1: ");
                    String name1 = scanner.nextLine();
                    System.out.println("Enter 1. Person's timestamp: ");
                    date = Timestamp.valueOf(scanner.nextLine());
                    System.out.print("Enter name2: ");
                    String name2 = scanner.nextLine();
                    System.out.println("Enter 2. Person's timestamp: ");
                    date2 = Timestamp.valueOf(scanner.nextLine());

                    SocialNetworkGraph.addFriendship(name1,date, name2,date2);
                    break;
                case 4:
                    System.out.print("Enter name1: ");
                    name1 = scanner.nextLine();
                    System.out.println("Enter 1. Person's timestamp: ");
                    date = Timestamp.valueOf(scanner.nextLine());
                    System.out.print("Enter name2: ");
                    name2 = scanner.nextLine();
                    System.out.println("Enter 2. Person's timestamp: ");
                    date2 = Timestamp.valueOf(scanner.nextLine());

                    SocialNetworkGraph.removeFriendship(name1, name2);
                    break;
                case 5:
                    System.out.print("Enter start name: ");
                    name1 = scanner.nextLine();
                    System.out.print("Enter end name: ");
                    name2 = scanner.nextLine();
                    SocialNetworkGraph.findShortestPath(name1, name2);
                    break;
                case 6:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter Person's timestamp: ");
                    
                    date2 = Timestamp.valueOf(scanner.nextLine());

                    System.out.println("Enter maximum number of friends to suggest: ");
                    SocialNetworkGraph.suggestFriends(name, date2, scanner.nextInt());
                    break;
                case 7:
                    SocialNetworkGraph.countClusters();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            } catch (Exception e) {
                System.out.println("Error");
                
            }
        }
        
        
    }
}
