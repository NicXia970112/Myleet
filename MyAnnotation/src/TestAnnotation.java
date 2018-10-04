import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestAnnotation {
    public static void main(String []args)  {
        Person p = new Person();
        Class pcl = p.getClass();
        try {
            Method m = pcl.getMethod("say");
            Before before = m.getAnnotation(Before.class);
            After after = m.getAnnotation(After.class);
            System.out.println(before.value());
            m.invoke(p);
            System.out.println(after.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("没有这个方法");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Person {

    @Before(value = "hi")
    @After(value = "gdbye~")
    public void say() {
        System.out.println("hello I'm nic");
    }

}
