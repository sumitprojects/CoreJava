package chapter4;

public class StringBufferFun {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("\t\t String Buffer");
        System.out.println("-------------------------------------------------------------");
        StringBuffer sb = new StringBuffer("Hello ");
        System.out.println("Initial capacity : " + sb.capacity());//default 16+5
        sb.append("Java");//now original string is changed
        System.out.println("Append : " + sb);//prints Hello Java
        System.out.println("Substring : " + sb.substring(6, 8));
        
        sb = new StringBuffer("Hello");
        sb.insert(1, "Java");//now original string is changed
        System.out.println("insert : " + sb);//prints HJavaello

        sb = new StringBuffer("Hello");
        sb.replace(1, 3, "Java");
        System.out.println("replace : " + sb);//prints HJavalo

        sb = new StringBuffer("Hello");
        System.out.println("\'lo\' located on : " + sb.indexOf("lo"));
        sb.delete(sb.indexOf("el"), sb.indexOf("el") + 2);
        System.out.println("delete : " + sb);//prints Hlo

        sb = new StringBuffer("Hello String");
        sb.reverse();
        System.out.println("reverse : " + sb);//prints olleH

        sb = new StringBuffer();
        System.out.println("Initial capacity : " + sb.capacity());//default 16
        sb.append("Hello");
        System.out.println("capacity : " + sb.capacity());//now 16
        sb.append("java is my favourite language");
        System.out.println("new capacity : " + sb.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2
        sb.ensureCapacity(10);//now no change
        System.out.println("Ensure cap 10 : " + sb.capacity());//now 34
    
        sb.ensureCapacity(71);//now (34*2)+2//(70*2)
        System.out.println("Ensure cap 50 : " + sb.capacity());//now 70
    }
}
