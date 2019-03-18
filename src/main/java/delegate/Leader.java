package delegate;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee{

    Map<String,IEmployee> map = new HashMap<String,IEmployee>();

    public Leader() {
       map.put("登录",new EmployeeA());
       map.put("加密",new EmployeeB());
    }

    public void doing(String command) {
        map.get(command).doing(command);

    }
}
