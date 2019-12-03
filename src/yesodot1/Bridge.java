package yesodot1;

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
    public boolean registerToProject( Vector<String> ids,String projectName,String moderator);
    public String getCode(String projectName);//get code of a project from DB by name
    public boolean addStudents(String[] students);
    public boolean addModerator(String moderator);

}
