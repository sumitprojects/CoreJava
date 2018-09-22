package chapter4;

public class Arrays {
    private String[] data;

    public Arrays() {
    }

    public Arrays(String[] data) {
        this.data = data;
    }

    public static void main(String[] args) {
    
        String[] data = {"Data1", "Data2"}, data1, data2 = new String[5];
        //data1 = new String[]{"Data1", "Data2", "Data3", "Data4", "Data5"};
        for (int i = 0; i < data2.length; i++) {
            data2[i] = "sumit " + i;
        }
        data1 = java.util.Arrays.copyOf(data2, 3);
        System.out.println(java.util.Arrays.toString(data1));
        Arrays[] a = new Arrays[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Arrays();
        }
        a[0].setData(data);
        System.out.println("---------------------------------------------------------");
        for (String s : data) {
            System.out.println(s);
        }
        long start = System.currentTimeMillis(), end;
        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; i < 1000000; i++) {
                new Arrays();
            }
        }
        end = System.currentTimeMillis();
        System.out.println("start : " + start + " end: " + end + " diff: " + (end - start));
        System.out.println("---------------------------------------------------------");
        for (String s : data1) {
            System.out.println(s);
        }
        //System.out.println(a.getData().length);
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
