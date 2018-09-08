public class NearestPalindromeNumberFinder {
    public static void main (String[] args) {
        Integer number = 1;
        int checkNumber = 200;
        int check = 0;
        int temp = 0;
        int palin = 0;
        do {
            String s = number.toString();
            int start = 0, end, mid, i;
            char[] data;
            data = s.toCharArray();
            end = data.length;
            --end;
            mid = (end % 2 == 0) ? (end / 2) : (end + 1) / 2;
            for (i = 0; i <= mid; ++i) {
                if (i == mid) {
                    if (number == checkNumber) {
                        System.out.println("palindrome number before " + checkNumber + " is " + temp);
                        System.out.println("here " + checkNumber + " is also palindrome");
                        palin = 1;
                    }
                    if (number > checkNumber) {
                        if (palin == 0) {
                            System.out.println("palindrome number before " + checkNumber + " is " + temp);
                        }
                        System.out.println("palindrome number after " + checkNumber + " is " + number);
                        check = 1;
                        break;
                    } else {
                        temp = number;
                    }
                }
                if (data[i] == data[end - i]) {
                    continue;
                } else {
                    break;
                }
            }
            number++;
        } while (check == 0);
    }
}