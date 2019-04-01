package delegate;

import java.util.ArrayList;
import java.util.List;

public class DelegateTest {
    public static void main(String[] args) {

        new Boss().command("加密",new Leader());

        List<String> list = new ArrayList<String>();
        list.add("a");
    }

}
