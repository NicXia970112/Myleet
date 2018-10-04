public class test {
    public static void main(String []args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        test t = new test();
        System.out.println(t.getClass().getClassLoader());
    }
}
