package chapter4;

public class StringBuilderFun {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("\t\t String Builder");
        System.out.println("-------------------------------------------------------------");
        StringBuilder sb = new StringBuilder("Hello ");
        sb.append("Java");//now original string is changed
        System.out.println("Append : " + sb);//prints Hello Java
        System.out.println("Substring : " + sb.substring(6));
        sb = new StringBuilder("Hello");
        sb.insert(1, "Java");//now original string is changed
        System.out.println("insert : " + sb);//prints HJavaello

        sb = new StringBuilder("Hello");
        sb.replace(1, 3, "Java");
        System.out.println("replace : " + sb);//prints HJavalo

        sb = new StringBuilder("Hello");
        sb.delete(1, 3);
        System.out.println("delete : " + sb);//prints Hlo

        sb = new StringBuilder("Hello String");
        sb.reverse();
        System.out.println("reverse : " + sb);//prints olleH

        sb = new StringBuilder();
        System.out.println("Initial capacity : " + sb.capacity());//default 16
        sb.append("Hello");
        System.out.println("capacity : " + sb.capacity());//now 16
        sb.append("java is my favourite language");
        System.out.println("new capacity : " + sb.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2
        sb.ensureCapacity(10);//now no change
        System.out.println("Ensure cap 10 : " + sb.capacity());//now 34

        sb.ensureCapacity(50);//now (34*2)+2
        System.out.println("Ensure cap 50 : " + sb.capacity());//now 70
    }
}
