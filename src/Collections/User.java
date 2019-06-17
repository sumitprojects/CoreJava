package Collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class User implements Serializable {
	private final static long serialVersionUID = -7907744799305609358L;
	private int id;
	private String name;
	private int age;
	
	public User (int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public static void main (String[] args) {
		ArrayList<User> data = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			data.add(new User(i + 1, ((char) (i + 65)) + "sumit", random.nextInt(100) + 1));
		}
		
		Collections.sort(data, new UserIDOrder());
		
		System.out.println(data);
		
		Collections.sort(data, new UserAgeOrder(true));
		
		System.out.println(data);
		
		Collections.sort(data, new UserNameOrder(true));
		
		System.out.println(data);
	}
	
	public int getId () {
		return id;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	public String getName () {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public int getAge () {
		return age;
	}
	
	public void setAge (int age) {
		this.age = age;
	}
	
	@Override
	public String toString () {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}


class UserIDOrder implements Comparator<User> {
	private boolean order = false;
	
	UserIDOrder () {
	}
	
	UserIDOrder (boolean userOrder) {
		order = userOrder;
	}
	
	@Override
	public int compare (User user, User t1) {
		if (user.getId() > t1.getId()) {
			return (order) ? -1 : 1;
		} else if (user.getId() < t1.getId()) {
			return (order) ? 1 : -1;
		} else {
			return 0;
		}
	}
}


class UserAgeOrder implements Comparator<User> {
	private boolean order = false;
	
	UserAgeOrder () {
	}
	
	UserAgeOrder (boolean userOrder) {
		order = userOrder;
	}
	
	@Override
	public int compare (User user, User t1) {
		if (user.getAge() > t1.getAge()) {
			return (order) ? -1 : 1;
		} else if (user.getAge() < t1.getAge()) {
			return (order) ? 1 : -1;
		} else {
			return 0;
		}
	}
}

class UserNameOrder implements Comparator<User> {
	private boolean order = false;
	
	UserNameOrder () {
	}
	
	UserNameOrder (boolean userOrder) {
		order = userOrder;
	}
	
	@Override
	public int compare (User user, User t1) {
		if (!order) {
			return user.getName().compareTo(t1.getName());
		} else {
			return t1.getName().compareTo(user.getName());
		}
	}
}