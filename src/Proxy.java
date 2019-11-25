import java.util.Vector;

public class Proxy implements Bridge {
    //fields
    Bridge real;
    //constructor
    public Proxy (){

    }
    @Override
    public boolean addProject(String projectName, String description, int hours, String fname, String lname, String email, String phoneNumber, String organization) {
        return true;
    }

    @Override
    public State checkProjectState(String code) {
        return null;
    }

    @Override
    public boolean registerToProject(Vector<String> ids, String moderator) {
        return true;
    }
}
