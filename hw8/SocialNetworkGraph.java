import java.util.*;

public class SocialNetworkGraph {
    Map<String, Person> people = new HashMap<>();
    Map<Person, List<Person>> friendships = new HashMap<>();

    // getter for people
    public Map<String, Person> getPeople() {
        return people;
    }

    // getter for friendships
    public Map<Person, List<Person>> getFriendships() {
        return friendships;
    }
   /**
    * Method to add a person to the network
    * @param name
    * @param age
    * @param hobbies
    */
    public void addPerson(String name, int age, List<String> hobbies) {
        
        if(people.containsKey(name)){
            System.out.println("Person already exists in the network.");
            return;
        }


        Person person = new Person(name, age, hobbies);
        people.put(name, person);
        friendships.put(person, new ArrayList<>());
        System.out.println("Person added: " + person);
    }

    /**
     * Method to remove a person from the network
     * @param name
     * @param date
     * @return Person
     */
    public Person removePerson(String name, Date date) {
        Person person = people.get(name);
       if(person.timestamp.compareTo(date) != 0){
           System.out.println("Person cannot be removed as the timestamp is not valid");
           return null;
         }

        person = people.remove(name);
        if (person != null) {
            friendships.remove(person);
            for (List<Person> friends : friendships.values()) {
                friends.remove(person);
            }
            System.out.println("Person removed: " + person);
        } else {
            System.out.println("Person not found in the network.");
        }
        return person;
    }

    /**
     * Method to add a friendship between two people
     * @param name1
     * @param d1
     * @param name2
     * @param d2
     */
    public void addFriendship(String name1,Date d1, String name2, Date d2) {
        Person person1 = people.get(name1);
        Person person2 = people.get(name2);
        
        if (person1 != null && person2 != null) {
            friendships.get(person1).add(person2);
            friendships.get(person2).add(person1);
            System.out.println("Friendship added between " + person1.name + " and " + person2.name);
        } else {
            System.out.println("person not found ");
        }
    }

    /**
     * Method to remove a friendship between two people
     * @param name1
     * @param name2
     */
    public void removeFriendship(String name1, String name2) {
        Person person1 = people.get(name1);
        Person person2 = people.get(name2);
        if (person1 != null && person2 != null) {
            friendships.get(person1).remove(person2);
            friendships.get(person2).remove(person1);
            System.out.println("Friendship removed between " + person1.name + " and " + person2.name);
        } else {
            System.out.println("person not found");
        }
    }

    /**
     * Method to suggest friends for a person
     * @param name
     * @param date
     * @param k
     */
    public void suggestFriends(String name, Date date, int k) {
        Person person = people.get(name);
        if (person == null) {
            System.out.println("Person not found");
            return;
        }
        if(person.timestamp.compareTo(date) != 0){
            System.out.println("Person cannot be removed as the timestamp");
            return ;
        }

        Map<Person, Double> scores = new HashMap<>();
        for (Person friend : people.values()) {
            if (friend == person) {
                continue;
            }

            double score = 0;
            for (Person mutualFriend : friendships.get(friend)) {
                if (mutualFriend != person && friendships.get(person).contains(mutualFriend)) {
                    score += 1;
                }
            }

            for (String hobby : person.hobbies) {
                if (friend.hobbies.contains(hobby)) {
                    score += 0.5;
                }
            }

            scores.put(friend, score);
        }

        List<Map.Entry<Person, Double>> sortedScores = new ArrayList<>(scores.entrySet());
        sortedScores.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        System.out.println("Friend suggestions for " + person.name + ":");
        for (int i = 0; i < k && i < sortedScores.size(); i++) {
            System.out.println(sortedScores.get(i).getKey() + " (Score: " + sortedScores.get(i).getValue() + ")");
        }
    }


    /**
     * Method to find the shortest path between two people
     * @param startName
     * @param endName
     */
    public void findShortestPath(String startName, String endName) {
        Person start = people.get(startName);
        Person end = people.get(endName);
        if (start == null || end == null) {
            System.out.println("One or both persons not found in the network.");
            return;
        }

        Map<Person, Person> prev = new HashMap<>();
        Queue<Person> queue = new LinkedList<>();
        Set<Person> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Person current = queue.poll();
            if (current == end) {
                printPath(start, end, prev);
                return;
            }

            for (Person neighbor : friendships.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    prev.put(neighbor, current);
                }
            }
        }

        System.out.println("No path found between " + startName + " and " + endName);
    }


    /**
     * Method to print the shortest path between two people
     * @param start
     * @param end
     * @param prev
     */
    private void printPath(Person start, Person end, Map<Person, Person> prev) {
        List<Person> path = new ArrayList<>();
        for (Person at = end; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        System.out.println("Shortest path: " + path);
    }

    /**
     * Method to count the number of clusters in the network
     */
    public void countClusters() {
        Set<Person> visited = new HashSet<>();
        int count = 0;

        for (Person person : people.values()) {
            if (!visited.contains(person)) {
                List<Person> cluster = new ArrayList<>();
                bfs(person, visited, cluster);
                count++;
                System.out.println("Cluster " + count + ": " + cluster);
            }
        }

        System.out.println("Total clusters: " + count);
    }

    /**
     * Method to perform breadth-first search to find clusters
     * @param start
     * @param visited
     * @param cluster
     */    
    private void bfs(Person start, Set<Person> visited, List<Person> cluster) {
        Queue<Person> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Person current = queue.poll();
            cluster.add(current);

            for (Person neighbor : friendships.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}
