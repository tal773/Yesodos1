package yesodot1;

import java.util.Vector;

public class Proxy implements Bridge {
    //fields
    Bridge real;
    //constructor
    public Proxy (){

    }
    @Override
    public boolean addProject(String projectName, String description, int hours, String fname, String lname, String email, String phoneNumber, String organization) {
        if(real!=null)
            return real.addProject(projectName,description,hours,
                    fname,lname,email,phoneNumber,organization);
        return true;
    }

    @Override
    public State checkProjectState(String code) {
        if(real!=null)
            return real.checkProjectState(code);
        return null;
    }

    @Override
    public boolean registerToProject(Vector<String> ids,String projectName, String moderator) {
        if(real!=null)
            return real.registerToProject(ids,projectName,moderator);
        return true;
    }

    @Override
    public String getCode(String projectName) {
        if(real!=null)
            return real.getCode(projectName);
        return null;
    }

    @Override
    public boolean addStudents(String[] students) {
        if(real!=null)
            return real.addStudents(students);
        return true;
    }

    @Override
    public boolean addModerator(String moderator) {
        if(real!=null)
            return real.addModerator(moderator);
        return true;
    }
}
