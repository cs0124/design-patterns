package proxy.StaticProxy;

public class Mother {

    private Son son;

    public Mother(Son son) {
        this.son = son;
    }

    public void findLove(){
        System.out.println("开始寻找合适的人选。。。");
        this.son.findLove();
        System.out.println("如果合适那就办事吧。。。");
    }
}
