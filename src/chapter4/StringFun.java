package chapter4;

public class StringFun {
    public static void main(String[] args) {
        // Mutable(Unchangeble) and Immutable
        String data = "hello", string = "this is string.", another = string.concat("this is another string.");
        char[] cc = string.toCharArray();

        System.out.println("String Comparision :" + data.compareTo(string) + "\n" +
                "Sting Concatination :" + string.concat(data) + "\n" +
                "Sting Length :" + another.length() + "\n" +
                "String equality :" + data.equals("hello") + "\n" +
                "String equality without case :" + data.equalsIgnoreCase("THIS") + "\n" +
                "String contains :" + string.contains("is") + "\n" +
                "String Starts with :" + another.startsWith("this") + "\n" +
                "String Starts with another :" + another.startsWith(" ", 4) + "\n" +
                "String ends with :" + string.endsWith("ing") + "\n" +
                "String ends with :" + string.endsWith("string") + "\n" +
                "String substring :" + string.substring(2) + "\n" +
                "String Substring :" + string.substring(1, 3));

        System.out.print("String Split :");
        String ch[] = string.split(" ");
        for (String c : ch) {
            System.out.print(c + " ");
        }

        System.out.println("\nString Join :" + String.join("/", ch) + "\n" +
                "String index of :" + string.indexOf("is", 4) + "\n" +
                "String Char at :" + string.charAt(8) + "\n" +
                "String trim :" + string.trim() + "\n" +
                "String Lowercase :" + string.toLowerCase() + "\n" +
                "String Uppercase :" + string.toUpperCase());
    }
}
