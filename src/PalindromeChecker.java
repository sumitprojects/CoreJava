public class PalindromeChecker {
    
    public static void main (String[] args) {
//        String arr = "Sachin is with Rahul";
//        String arr2[] = arr.split(" ");
//        for(int i = arr2.length-1 ; i>=0;i--){
//            System.out.print(arr2[i] +" ");
//       }
        int r, sum = 0, temp;
        int n = 12131;//It is the number variable to be checked for palindrome
        
        temp = n;
        while (n > 0) {
            r = n % 10;  //getting remainder
            sum = (sum * 10) + r;
            n = n / 10;
        }
        if (temp == sum) {
            System.out.println(temp + " palindrome number ");
        } else {
            System.out.println(temp + " not palindrome");
            palindromechecker(temp);
        }
    }
    
    public static void palindromechecker (int num) {
        int sum = 0, r, temp = 0, i, j;
        i = num;
        while (i > 0) {
            temp = i;
            while (i > 0) {
                r = i % 10;  //getting remainder
                sum = (sum * 10) + r;
                i = i / 10;
            }
            if (temp == sum) {
                System.out.println("palindrome number before " + temp);
                break;
            }
            sum = 0;
            temp--;
            i = temp;
        }
        
        i = num;
        while (true) {
            temp = i;
            while (i > 0) {
                r = i % 10;  //getting remainder
                sum = (sum * 10) + r;
                i = i / 10;
            }
            if (temp < 0) {
                break;
            } else if (temp == sum) {
                System.out.println("palindrome number after " + temp);
                break;
            }
            sum = 0;
            temp++;
            i = temp;
        }
    }
}
