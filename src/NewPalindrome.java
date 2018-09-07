public class NewPalindrome {
    public static void main (String[] args) {
        Boolean on = false;
        String number = "sumus";
        Integer start = 0, end, mid;
        end = number.length();
        mid = (end / 2);
        --end;
        while (mid > 0) {
            char array[] = number.toCharArray();
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
        if (on) {
            System.out.println("Data is palindrome");
        } else {
            System.out.println("Data is not palindrome");
        }
        
    }
}
