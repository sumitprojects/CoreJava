package chapter4;

import java.util.StringTokenizer;

public class StringTokenizerClass {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------");
        System.out.println("\t\t String Tokenizer");
        System.out.println("---------------------------------------------------------");
        StringTokenizer st = new StringTokenizer("my name is sumit", " ");
        System.out.println("Splitting by \" \"");
        System.out.println("---------------------------------------------------------");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        System.out.println("---------------------------------------------------------");
        st = new StringTokenizer("my-name-is-sumit", "-");
        System.out.println("Splitting by \"-\"");
        System.out.println("---------------------------------------------------------");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        System.out.println("---------------------------------------------------------");
    }
}
