
import java.util.Vector;
enum State {
    APPROVED,
    DENIED,
    WAITING,
    IN_PROGRESS,

}
public interface Bridge {

    public boolean addProject(String projectName, String description,
                              int hours,String fname, String lname,
                              String email,String phoneNumber,String organization);
    public State checkProjectState (String code);
    public boolean registerToProject( Vector<String> ids,String moderator);

}
