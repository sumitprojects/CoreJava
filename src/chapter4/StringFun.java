package chapter4;

import chapter8.User;

public class StringFun {
    public static void main(String[] args) {
		// Immutable(Unchangeable / unmodifiable)
      String data = "hello", string = "This is string.", another = string.concat("this is another string."), data2 = "";
        char[] cc = string.toCharArray();
        System.out.println("String Comparision :" + data.compareTo(string) + "\n" +
                "Sting Concatenation :" + string.concat(data) + "\n" +
                "String Concatenation :" + another + "\n" +
                "String Length :" + another.length() + "\n" +
                "String equality :" + data.equals("Hello") + "\n" +
                "String equality without case :" + data.equalsIgnoreCase("HELLO") + "\n" +
                "String contains :" + string.contains("is") + "\n" +
                "String Starts with :" + another.startsWith("This") + "\n" +
                "String Starts with using Index :" + another.startsWith("i", 5) + "\n" +
                "String ends with :" + string.endsWith(".") + "\n" +
                "String ends with :" + string.endsWith("string") + "\n" +
                "String substring :" + string.substring(2) + "\n" +
                "String Substring :" + (string.substring(1, 7)).substring(1, 3) + "" + "\n");//1 to7 will concider"his is" and substring will find form it.

        System.out.print("String Split :");
        String ch[] = string.split(" ");
        for (String c : ch) {
          System.out.println(c + " ");
        }
  
      System.out.println("\nString Join :" + String.join(" ", ch) + "\n" +
              "String index of :" + string.indexOf("is", 4) + "\n" +
                "String Char at :'" + string.charAt(1) + "'\n" +
                "String trim :" + string.trim() + "\n" +
                "String Lowercase :" + string.toLowerCase() + "\n" +
                "String Uppercase :" + string.toUpperCase());
  
      System.out.println(string.replace("is", "was") + "\n" +
              "data2 empty:" + data2.isEmpty());
	
		User user = new User();
		user.setId(2);
		user.setName("sumit");
		System.out.println(user);
    }
}
