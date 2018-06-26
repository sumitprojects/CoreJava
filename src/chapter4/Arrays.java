package chapter4;

public class Arrays {
    private String[] data;

    public Arrays() {
    }

    public Arrays(String[] data) {
        this.data = data;
    }

    public static void main(String[] args) {
        String[] data = {"Data1", "Data2"}, data1;
        data1 = new String[]{"Data1", "Data2", "Data3", "Data4", "Data5"};
        Arrays a = new Arrays();
        a.setData(data);
        System.out.println("---------------------------------------------------------");
        for (String s : data) {
            System.out.println(s);
        }
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
