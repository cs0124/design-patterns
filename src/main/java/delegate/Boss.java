package delegate;

public class Boss {

    void command(String command,Leader leader){
        leader.doing(command);
    }
}
