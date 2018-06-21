package chapter1;
/*
Data Type	Default Value	Default size
boolean	    false	        1 bit
char	    '\u0000'	    2 byte
byte	        0	        1 byte
short	        0	        2 byte
int	            0	        4 byte
long	        0L	        8 byte
float	        0.0f	    4 byte
double	        0.0d	    8 byte
*/

public class DataTypes {
    public static void main(String[] args) {
        Boolean one = false;
        boolean second = true;

        int a = 100000;
        Integer b = -200000;

        long a1 = 100000L;
        Long b1 = -200000L;

        float f1 = 234.5f;
        Float f2 = 234.5f;

        double d1 = 12.3;
        Double d2 = 12.3;

        char letterA = 'A';
        Character letterB = 'B';
    }
}
