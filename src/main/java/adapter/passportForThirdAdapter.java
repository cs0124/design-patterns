package adapter;

public class passportForThirdAdapter extends LoginService implements IPassprotForThird{
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id,LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForRegist(String username, String pasword) {
        return null;
    }

    private ResultMsg processLogin(String id, Class<? extends LoginForQQAdapter> clazz) {
        try {
            LoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)){
                return adapter.login(id,adapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
