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
  
  static String palindromeMaxGenerator (String data) {
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
  
  static String palindromeMinGenerator (String data) {
    char array[] = data.toLowerCase().toCharArray();
    int start = 0, end = data.length(), mid = (end / 2);
    --end;
    boolean on = false;
    while (mid > 0) {
      if (array[start] == array[end]) {
        on = true;
      } else {
        int min = Integer.max(array[start], array[end]);
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
    String number = "mole";
    
    if (palindromeChecker(number)) {
      System.out.println(number + " is palindrome");
    } else {
      System.out.println(number + " is not palindrome");
      System.out.println("Nearest Palindrome : " + palindromeMaxGenerator(number));
      System.out.println("Farest Palindrome : " + palindromeMinGenerator(number));
    }
    
  }
}
