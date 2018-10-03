package chapter1;

/*
   precedence [] () .
Operator Type	Category	    Precedence
Unary	        postfix	        expr++ expr--
                prefix	        ++expr --expr +expr -expr ~ !
---------------------------------------------------------------
Arithmetic	    multiplicative	* / %
                additive	     + -
----------------------------------------------------------------
Shift	        shift	        << >> >>>
----------------------------------------------------------------
Relational	    comparison	    < > <= >= instanceof
                equality	    == !=
----------------------------------------------------------------
Bitwise	        bitwise AND	    &
bitwise         exclusive OR	^
bitwise         inclusive OR	|
----------------------------------------------------------------
Logical	        logical AND	    &&
logical         OR	            ||
----------------------------------------------------------------
Ternary	        ternary	        ? :
----------------------------------------------------------------
Assignment	    assignment	    = += -= *= /= %= &= ^= |= <<= >>= >>>=
----------------------------------------------------------------
*/
public class Operators {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Increment-Decrement");
        int x = 10;
        System.out.println("x++ =>" + x++);//10 (11)
        System.out.println("++x =>" + ++x);//12
        System.out.println("x-- =>" + x--);//12 (11)
        System.out.println("--x =>" + --x);//10
        System.out.println("----------------------------------------------------------------");

        System.out.println("----------------------------------------------------------------");
        int a = 10;
        int b = -10;
        boolean c = true;
        boolean d = false;
        System.out.println("\t\t ~ and !");
        System.out.println("~a  " + ~a);//-11 (minus of total positive value which starts from 0)
        System.out.println("~b  " + ~b);//9 (positive of total minus, positive starts from 0)
        System.out.println("!c  " + !c);//false (opposite of boolean value)
        System.out.println("!d  " + !d);//true
        System.out.println("----------------------------------------------------------------");

        System.out.println("----------------------------------------------------------------");
        int a1 = 10;
        int b1 = 5;
        System.out.println("\t\t Arithmetic Operator");
        System.out.println("a1+b1 " + (a1 + b1));//15
        System.out.println("a1-b1 " + (a1 - b1));//5
        System.out.println("a1*b1 " + (a1 * b1));//50
        System.out.println("a1/b1 " + (a1 / b1));//2
        System.out.println("a1%b1 " + (a1 % b1));//0
        System.out.println("----------------------------------------------------------------");

        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Left Shift Operator");
		System.out.println("10<<2 " + (10 << 2));//10*(2^2)=10*4=40
        System.out.println("10<<3 " + (10 << 3));//10*2^3=10*8=80
        System.out.println("20<<2 " + (20 << 2));//20*2^2=20*4=80
        System.out.println("15<<4 " + (15 << 4));//15*2^4=15*16=240
        System.out.println("----------------------------------------------------------------");

        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Right Shift Operator");
        System.out.println("10>>2 " + (10 >> 2));//10/2^2=10/4=2
        System.out.println("20>>2 " + (20 >> 2));//20/2^2=20/4=5
        System.out.println("20>>2 " + (20 >> 3));//20/2^3=20/8=2
        System.out.println("----------------------------------------------------------------");

        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Logical && and Bitwise &");
        System.out.println("(10<5 && 10<20)" + (10 < 5 && 10 < 20));//false && true = false
        System.out.println("(10<5 &  10<20)" + (10 < 5 & 10 < 20));//false & true = false
        System.out.println("----------------------------------------------------------------");

        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Logical || and Bitwise |");
        System.out.println("(10<5 || 10<20)" + (10 < 5 || 10 < 20));//false || true = true
        System.out.println("(10<5 |  10<20)" + (10 < 5 | 10 < 20));//false | true = true
        System.out.println("(10 | 2)" + (10 | 2));//1010 | 0010 = 1010
        System.out.println("----------------------------------------------------------------");

        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Ternary Operator");
        a = 2;
        b = 5;
        int min = (a < b) ? a : b;
        System.out.println("(a<b)?a:b " + min);
        System.out.println("----------------------------------------------------------------");
		{
			System.out.println("----------------------------------------------------------------");
			System.out.println("\t\t Assignment Operator ");
			a = 10;
			System.out.println("a+=1 " + (a += 1));//11
			System.out.println("a-=1 " + (a -= 1));//10
			System.out.println("a*=1 " + (a *= 1));//10
			System.out.println("a/=1 " + (a /= 1));//10
			System.out.println("a%=1 " + (a %= 1));//0
			System.out.println("a&=1 " + (a &= 1));//0
			System.out.println("a|=1 " + (a |= 1));//1
			System.out.println("a<<=1 " + (a <<= 1));//2
			System.out.println("a>>=1 " + (a >>= 1));//1
			System.out.println("a>>>=1 " + (a >>>= 1));//0
			System.out.println("----------------------------------------------------------------");
		}
    }
}
