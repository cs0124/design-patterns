package proxy.StaticProxy;

public class StaticProxyTest {

    public static void main(String[] args) {
        Mother mother = new Mother(new Son());

        mother.findLove();
    }
}
