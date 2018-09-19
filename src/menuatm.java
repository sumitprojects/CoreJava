import javax.swing.*;
import java.util.Scanner;

//import java.io.IOException;
//import java.io.Serializable;

// CHAPTER 8 PROGRAM INSIDE THIS ONE.
// NEXT PROGRAM BANK ACCOUNT-.
public class menuatm {
  
  /**
   * @param args
   */
  public static void main (String[] args) {
    // TODO Auto-generated method stub
    Scanner user_input = new Scanner(System.in);
    
    mainloop:
    while (true) {
      
      System.out.println("             --**ATM MACHINE**-- \n");
      System.out.println(" -Select your desired operation from the Menu- \n");
      System.out.println("------------------------------------------------- \n");
      System.out.println("[1]:- View account balance.\n");
      System.out.println("[2]:- Withdraw cash.\n");
      System.out.println("[3]:- Make a deposit.\n");
      System.out.println("[4]:- Exit.\n");
      
      int user_answer = user_input.nextInt();
      switch (user_answer) {
        case 1:
          System.out.println("Your account balance is:");
          System.out.println("$ 3.458.184,93 .\n");
          System.out.println("Would you like to do another transaction? [Y/N]");
          
          // /*[b]*/ FIRST TRY[/b]
          int temp = JOptionPane.showConfirmDialog(null, "Would you like to do another transaction?", "[Y/N]", JOptionPane.YES_NO_OPTION);
          if (temp == 0) {
            //String showInputDialog = JOptionPane.showInputDialog(null, "Select your new transaction");
            menuatm menuatm = new menuatm();
          } else {
            JOptionPane.showMessageDialog(null, "Thanks for using ATM. Have a nice day.");
            break mainloop;
          }
        case 2:
          System.out.println("Please type the amount that you want to withdraw: ");
          int withdrawalAmount = user_input.nextInt();
          System.out.println(withdrawalAmount + " $, are being withdrawed.");
          System.out.println("Please take your cash");
          continue mainloop;
        
        case 3:
          System.out.println("Please type the amount that you would like to deposit: ");
          int depositAmount = user_input.nextInt();
          System.out.println(depositAmount + " $, are going to be deposited in your account.");
          System.out.println("Please insert the cash");
          continue mainloop;
        
        case 4:
          System.out.println("Thanks for using ATM. Have a nice day. \n");
          System.exit(user_answer);
          continue mainloop;
        
        default:
          System.out.println("Invalid Choice. Please select an option from the menu.");
          continue mainloop;
      }
      
      
    }
  }
  
  private static String mainloop () {
    // TODO Auto-generated method stub
    return null;
  }
}
