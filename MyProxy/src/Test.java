import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String []args) {
        Waiter person = new person();
//        Waiter proxy = new WaiterProxy(person);
//        proxy.say();

        MyInvocation m = new MyInvocation(person);
        Waiter proxy = (Waiter) m.getProxy();
        proxy.say();

    }
}

interface Waiter {

    public void say();

}

class person implements  Waiter {

    @Override
    public void say() {
        System.out.println("here you are");
    }
}

class WaiterProxy implements  Waiter {

    private Waiter waiter;

    public WaiterProxy(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public void say() {
        this.sayBefore();
        waiter.say();
        this.sayAfter();
    }

    private void sayBefore() {
        System.out.println("hello");
    }

    private void sayAfter() {
        System.out.println("bye~");
    }
}

class MyInvocation implements InvocationHandler {

    private Object target;

    public MyInvocation(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        sayBefore();
        Object result = method.invoke(target, args);
        sayAfter();
        return result;
    }

    private void sayBefore() {
        System.out.println("hello");
    }

    private void sayAfter() {
        System.out.println("bye~");
    }

}