package chapter4;

public class StringFun {
    public static void main(String[] args) {
        // Mutable(Unchangeble) and Immutable
        String ddsff = "aello", s = "this is string", n = s.concat("Edd");
        char[] cc = s.toCharArray();

        System.out.println("hello " + ddsff.compareTo(s) + " " + s.concat(ddsff) + " " + n.length());

        // s1 == s2
        System.out.println(s.equals("aellq") + " " + s.equalsIgnoreCase("aelLq"));
        System.out.println(s.contains("is"));
        System.out.println(n.startsWith("this") + " " + n.startsWith(" ", 4));
        System.out.println(s.endsWith("g") + " " + s.endsWith("string"));
        System.out.println(s.substring(2) + " " + s.substring(1, 3));//12

        String ch[] = s.split(" ");
        for (String c : ch) {
            System.out.println(c);
        }

        System.out.println(String.join("/", ch));

        System.out.println(s.indexOf("is", 4) + " " + s.charAt(8));

        System.out.println(s.trim() + " " + s.toLowerCase() + " " + s.toUpperCase());
    }
}
