package adapter;

public class LoginService {

    public ResultMsg regist(String username,String password){

        return new ResultMsg(200,"注册成功",new Member());
    }

    public ResultMsg login(String username,String password){
        return new ResultMsg(200,"登录成功",new Member());
    }
}
