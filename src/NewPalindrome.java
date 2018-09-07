public class NewPalindrome {
    static Boolean palindromeChecker (String data) {
        char array[] = data.toLowerCase().toCharArray();
        int start = 0, end = data.length(), mid = (end / 2);
        --end;
        boolean on = false;
        while (mid > 0) {
            if (array[start] == array[end]) {
                ++start;
                --end;
                --mid;
                on = true;
                continue;
            } else {
                on = false;
                break;
            }
        }
        return on;
    }
    
    static String palindromeGenerator (String data) {
        char array[] = data.toLowerCase().toCharArray();
        int start = 0, end = data.length(), mid = (end / 2);
        --end;
        boolean on = false;
        while (mid > 0) {
            if (array[start] == array[end]) {
                on = true;
            } else {
                int min = Integer.min(array[start], array[end]);
                array[start] = (char) min;
                array[end] = (char) min;
                on = true;
            }
            ++start;
            --end;
            --mid;
        }
        return String.valueOf(array);
    }
    
    public static void main (String[] args) {
        boolean on = false;
        String number = "mon";
        
        if (palindromeChecker(number)) {
            System.out.println("Data is palindrome");
        } else {
            System.out.println("Data is not palindrome");
            System.out.println("Nearest Palindrome Data : " + palindromeGenerator(number));
        }
        
    }
}
