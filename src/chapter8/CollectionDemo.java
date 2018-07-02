package chapter8;

import java.util.*;

/*
 * Collections in java is a framework that provides an architecture to store and manipulate the group of objects.
 * */
public class CollectionDemo {
    static Scanner sc = new Scanner(System.in);
    
    /**
     * Method print all the List of the user from the Collections(List or Set).
     *
     * @param user excepts Collection such as List and Sets
     */
    static void getAllUser (Collection user) {
        System.out.println("--------------------------------------------------------");
        System.out.println("\t\t ID \t\t\t| \t\t Name");
        Iterator itr = user.iterator();
        while (itr.hasNext()) {
            User user1 = (User) itr.next();
            System.out.println("--------------------------------------------------------");
            System.out.println(user1.toString());
            //System.out.println("|\t\t " + user1.getId() + "\t\t\t\t| \t\t\t" + user1.getName() + "\t\t\t|");
            System.out.println("--------------------------------------------------------");
        }
    }
    
    public static void main (String[] args) {
        int choice = 0, counter;
        List<User> list;
        Set<User> userset;
        
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("\t\t\t Collection Demo");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Enter the choice Below:\n" +
                "1. ArrayList\n" +
                "2. LinkList\n" +
                "3. HashSet\n" +
                "4. LinkedHashSet\n" +
                "5. TreeSet\n" +
                "6. PriorityQueue");
        choice = sc.nextInt();
        System.out.println("How many User you want to add?");
        counter = sc.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t\t ArrayList");
                System.out.println("-----------------------------------------------------------------------");
                list = new ArrayList<>();
                System.out.println("Enter id and name");
                for (int i = 0; i < counter; i++) {
                    User u = new User(sc.nextInt(), sc.nextLine());
                    list.add(u);
                }
                getAllUser(list);
                System.out.println("Get(0) in UserList :" + list.get(0).getId());
                break;
            case 2:
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t\t LinkedList");
                System.out.println("-----------------------------------------------------------------------");
                list = new LinkedList<>();
                System.out.println("Enter id and name");
                for (int i = 0; i < counter; i++) {
                    User u = new User(sc.nextInt(), sc.nextLine());
                    list.add(u);
                    //list.add(u);
                }
                getAllUser(list);
                break;
            case 3:
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t\t Hashset");
                System.out.println("-----------------------------------------------------------------------");
                userset = new HashSet<>();
                System.out.println("Enter id and name");
                for (int i = 0; i < counter; i++) {
                    User u = new User(sc.nextInt(), sc.nextLine());
                    userset.add(u);
                    //userset.add(u);
                }
                getAllUser(userset);
                break;
            case 4:
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t\t LinkedHashSet");
                System.out.println("-----------------------------------------------------------------------");
                userset = new LinkedHashSet<>();
                System.out.println("Enter id and name");
                for (int i = 0; i < counter; i++) {
                    User u = new User(sc.nextInt(), sc.nextLine());
                    userset.add(u);
                }
                getAllUser(userset);
                break;
            case 5:
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t\t TreeSet");
                System.out.println("-----------------------------------------------------------------------");
                userset = new TreeSet<>();
                System.out.println("Enter id and name");
                for (int i = 0; i < counter; i++) {
                    User u = new User(sc.nextInt(), sc.nextLine());
                    userset.add(u);
                }
                getAllUser(userset);
                break;
            case 6:
                PriorityQueue<String> queue = new PriorityQueue<String>();
                queue.add("Amit");
                queue.add("Vijay");
                queue.add("Karan");
                queue.add("Jai");
                queue.add("Rahul");
                System.out.println("head:" + queue.element());
                System.out.println("head:" + queue.peek());
                System.out.println("iterating the queue elements:");
                Iterator itr = queue.iterator();
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
                queue.remove();
                queue.poll();
                System.out.println("after removing two elements:");
                Iterator<String> itr2 = queue.iterator();
                while (itr2.hasNext()) {
                    System.out.println(itr2.next());
                }
                break;
            default:
                System.err.println("Invalid Choice");
                break;
        }
    }
}