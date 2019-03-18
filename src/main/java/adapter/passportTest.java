package adapter;

public class passportTest {

    public static void main(String[] args) {
        IPassprotForThird passprotForThird = new passportForThirdAdapter();
        passprotForThird.loginForQQ("dsfsdfs");
    }
}
