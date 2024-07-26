package principle;

public class FlyweightClass {

    public static void main(String[] args) {
        test1();
        test2();
    }


    /**
     * 享元模式在 Java Integer 中的应用
     */
    private static void test1() {
        Integer i1 = 31;
        Integer i2 = 31;
        Integer i3 = 129;
        Integer i4 = 129;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);

        //true
        //false

        Integer.valueOf(129);
    }

    /**
     * 享元模式在 Java String 中的应用
     */
    private static void test2() {
        String s1 = "打工充";
        String s2 = "打工充";
        String s3 = new String("打工充");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        //true
        //false
    }

}
