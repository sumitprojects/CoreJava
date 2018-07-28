package chapter5;

/*
 * The exception handling in java is one of the powerful mechanism to handle
 * the runtime errors so that normal flow of the application can be maintained.
 * Hierarchy of Java Exception classes:
 *   https://www.javatpoint.com/images/throwable.png
 *
 * 1) Checked Exception :
 *    The classes that extend Throwable class except RuntimeException and Error are known as checked exceptions
 *    e.g.IOException, SQLException etc. Checked exceptions are checked at compile-time.
 *
 * 2) Unchecked Exception :
 *
 *    The classes that extend RuntimeException are known as unchecked exceptions e.g. ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException etc.
 *    Unchecked exceptions are not checked at compile-time rather they are checked at runtime.
 *
 * 3) Error :
 *  Error is irrecoverable e.g. OutOfMemoryError, VirtualMachineError, AssertionError etc.
 */

import java.io.IOException;
import java.util.Scanner;

class ExceptionCall {
    /*
     * Number format Exception Method
     */
    int data = 0;
    Integer arraydata[] = new Integer[5];
    
    /*
     * ArithmeticException code
     *
     * Divide by 0 is called as ArithmeticException Exception
     * */
    int div (int a, int b) {
        int c = 0;
        try {
            //c = (b!=0)?(a/b):0; bypassing the exception
            c = a / b;//creating exception
        } catch (ArithmeticException e) {
            c = 0;
            System.out.println(e);
        }
        /*
         * Rest of code will be executed if the exception is catched
         * otherwise it will be unreachable code.
         * */
        return c;
    }
    
    /*
     * Number format Exception Method
     */
    String NullExp () {
        String s = null;
        try {
            /*
             * below code is unreachable until you provide the data in the s.
             * */
            System.out.println("String length : " + s.length());//exception generated here
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e);
        }
        return s;
    }
    
    int setNum (String data) {
        /*
         * below code will generate the number format exception,
         * if string is given in the method call
         * */
        try {
            this.data = Integer.parseInt(data);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e);
        }
        /*
         * code will execute 0 if exception is generated
         * */
        return this.data;
    }
    
    void setDataArray (int... arraydata) {
        for (int i = 0; i < arraydata.length; i++) {
            /*
             *Below code will generate the ArrayIndexOut of bound exception,
             * if data is overflow other wise null pointer Exception if is is underflow.
             * */
            try {
                this.arraydata[i] = arraydata[i];
            } catch (Exception e) {
                System.out.println(e);
                //e.printStackTrace();
            }
        }
    }
    
    void MulticatchExample () {
        try {
            int a[] = new int[5];
            a[5] = 30 / 10;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException is completed");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException completed");
        }
        /*
         * Other Exception must be called after the Relevant Exception is called.
         * */ catch (Exception e) {
            System.out.println("common task completed");
        }
        System.out.println("rest of the code...");
    }
    
    void NestedTry () {
        try {
            try {
                String n = null;
                System.out.println(n.length());
            } catch (NullPointerException e) {
                System.out.println(e);
            }
            try {
                System.out.println("ArithmeticException Block");
                int b = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e);
            }
            System.out.println("-----------------------------------------------------------------------");
            try {
                System.out.println("ArrayIndexOutofBound Block");
                int a[] = new int[5];
                a[5] = 4;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Other Statement in try block");
        } catch (Exception e) {
            System.out.println("Exception Handled :" + e);
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Rest of the Code Executed!");
    }
    
    void FinallyBlock () {
        try {
            try {
                System.out.println("ArithmeticException Block");
                int b = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e);
            } finally {
                System.out.println("Without exception");
            }
            System.out.println("-----------------------------------------------------------------------");
            try {
                System.out.println("ArrayIndexOutofBound Block");
                int a[] = new int[5];
                a[5] = 4;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            } finally {
                System.out.println("With exception");
            }
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Other Statement in try block");
        } catch (Exception e) {
            System.out.println("Exception Handled :" + e);
        } finally {
            System.out.println("I am outer done.");
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Rest of the Code Executed!");
    }
    
    void TrowExample () {
        int age = 17;
        
        try {
            if (age >= 18) {
                System.out.println("Eligible");
            } else {
                throw new ArithmeticException("Not Eligible");
            }
        } catch (ArithmeticException e) {
            System.out.println("Exception Message: " + e);
        }
    }
    
    void ExceptionPropagation1 () {
        //without throw it will not call the exception
        System.out.println("ExceptionPropagation1 call");
    }
    
    void ExceptionPropagation2 () throws IOException {
        //Here throw keyword is used. So, it will be executed Forcefully although error is not occurred.
        throw new IOException("Device Reading Error");
    }
    
}


public class ExceptionHandling {
    
    public static void main (String[] args) throws IOException {
        ExceptionCall ac = new ExceptionCall();
        int choice = 0;
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("\t\t Exceptions call");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Enter the choice Below:\n" +
                "1. Arithmatic Exception\n" +
                "2. Null Pointer Exception\n" +
                "3. Number Format Exception\n" +
                "4. ArrayIndexOutofBound Exception\n" +
                "5. Multicatch Exception\n" +
                "6. Nested Try Statement\n" +
                "7. Finally Block\n" +
                "8. Throw Block\n" +
                "9. Exception Propagation\n");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t Arithmatic Exception");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Answer :" + ac.div(10, 0));//exception generated by the second value - 0
                System.out.println("-----------------------------------------------------------------------");
                break;
            case 2:
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t Null Pointer Exception");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Null Pointer method Call :" + ac.NullExp());//exception generated by the second value - 0
                System.out.println("-----------------------------------------------------------------------");
                break;
            case 3:
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t Number Format Exception");
                System.out.println("-----------------------------------------------------------------------");
                try {
                    System.out.println("Number Format method Call :" + ac.setNum("a"));//exception generated by the second value - 0
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println("-----------------------------------------------------------------------");
                break;
            case 4:
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t ArrayIndexOutofBound Exception");
                System.out.println("-----------------------------------------------------------------------");
                int arr[] = {1, 2, 3, 4, 5, 6};
                System.out.println("ArrayIndexOutofBound method Call :");
                ac.setDataArray(arr);
                System.out.println("-----------------------------------------------------------------------");
                break;
            case 5:
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t Multicatch Exception");
                System.out.println("-----------------------------------------------------------------------");
                ac.MulticatchExample();
                System.out.println("-----------------------------------------------------------------------");
                break;
            case 6:
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t Nested Try blocks ");
                System.out.println("-----------------------------------------------------------------------");
                ac.NestedTry();
                System.out.println("-----------------------------------------------------------------------");
                break;
            case 7:
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t Finally blocks ");
                System.out.println("-----------------------------------------------------------------------");
                ac.FinallyBlock();
                System.out.println("-----------------------------------------------------------------------");
                break;
            case 8:
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t Throw blocks ");
                System.out.println("-----------------------------------------------------------------------");
                ac.TrowExample();
                System.out.println("-----------------------------------------------------------------------");
                break;
            case 9:
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t ExceptionPropagation blocks ");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t ExceptionPropagation1 blocks ");
                ac.ExceptionPropagation1();
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("\t\t ExceptionPropagation2 blocks ");
                ac.ExceptionPropagation2();
                System.out.println("-----------------------------------------------------------------------");
                break;
            default:
                System.err.println("Invalid Choice");
                break;
        }
    }
}
