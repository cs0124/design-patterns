package proxy.DynamicProxy;

import proxy.Person;

public class DynamicProxyTest {

    public static void main(String[] args) {
        Person p =(Person) new MeiPo().getInstance(new Customer());
        p.findLove();
    }
}
