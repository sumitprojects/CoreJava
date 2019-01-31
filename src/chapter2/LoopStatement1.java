package chapter2;

/*
 * for loop
 * while loop
 * do-while loop
 * */
public class LoopStatement1 {
    public static void main (String[] args) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t FOR LOP ");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
        System.out.println("----------------------------------------------------------------");
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t NEW FOR LOP ");
		int[] arr = {12, 23, 44, 56, 78};
        //for each
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("----------------------------------------------------------------");
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Labeled For Loop break");
        aa:
        for (int i = 1; i <= 3; i++) {
            bb:
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    break aa;
                }
                System.out.println(i + " " + j);
            }
        }
        System.out.println("----------------------------------------------------------------");
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Labeled For Loop continue");
        aa:
        for (int i = 1; i <= 3; i++) {
            bb:
            for (int j = 1; j <= 3; j++) {
				if (i == 2 && j == 3) {
                    continue aa;
                }
                System.out.println(i + " " + j);
            }
        }
        System.out.println("----------------------------------------------------------------");
        
    }
}
