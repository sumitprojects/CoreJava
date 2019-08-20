package chapter4;

import java.util.Arrays;

public class NewArray {
    public static void main(String[] args) {
        int[] data = new int[5];
        int i;
        int sum = 0;
        for (i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100);
        }
        for (int j = 0; j < data.length; j++) {
            System.out.println(data[j]);
        }
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));

        for (int j = 0; j < data.length; j++) {
            sum += data[j];
        }
        System.out.println("sum of " + sum);
    }

}
