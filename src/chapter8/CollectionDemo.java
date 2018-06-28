package chapter8;

import java.util.*;

/*
 * Collections in java is a framework that provides an architecture to store and manipulate the group of objects.
 * */
public class CollectionDemo {
    static Scanner sc = new Scanner(System.in);

    static void getAllUser(Collection user) {
        System.out.println("--------------------------------------------------------");
        System.out.println("\t\t ID \t\t\t| \t\t Name");
        Iterator itr = user.iterator();
        while (itr.hasNext()) {
            User user1 = (User) itr.next();
            System.out.println("--------------------------------------------------------");
            System.out.println("|\t\t " + user1.getId() + "\t\t\t\t| \t\t\t" + user1.getName() + "\t\t\t|");
            System.out.println("--------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        int choice = 0, counter;
        List<User> list;
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("\t\t\t Collection Demo");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Enter the choice Below:\n" +
                "1. ArrayList\n" +
                "2. LinkList\n" +
                "3. HashTable\n" +
                "4. Map\n");
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
                }
                getAllUser(list);
                break;
            default:
                System.err.println("Invalid Choice");
                break;
        }
    }
}
