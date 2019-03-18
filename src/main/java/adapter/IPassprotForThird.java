package adapter;

public interface IPassprotForThird {

    ResultMsg loginForQQ(String id);

    ResultMsg loginForWechat(String id);

    ResultMsg loginForRegist(String username,String pasword);
}
