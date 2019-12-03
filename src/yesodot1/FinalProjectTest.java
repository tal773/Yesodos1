package yesodot1;

import org.junit.*;

import java.util.Vector;


public class FinalProjectTest {
    private Bridge bridge;
    protected String [] project1, project2,project3,project4,project5,studentsData,invalidStudentsIDs;
    protected int validHours;
    protected String notInDBStudent,moderator;


    public FinalProjectTest() {
        project1= new String[]{"Azur","cloud",
                "satiya","anadela","satia@micro.com",
                "0503216544","microsoft"};
        project2 = new String[]{"iphone","phone"
                ,"steve","jobs","sjobs@apple.com",
                "0503216543","apple"};
        project3=new String[]{"mac","laptop"
                ,"steve","jobs","sjobs@apple.com",
                "0503216543","apple"};
        project4= new String[]{"Cortana","system",
                "satiya","anadela","satia@micro.com",
                "0503216544","microsoft"};
        project5= new String[]{"windows","operation system",
                "satiya","anadela","satia@micro.com",
                "0503216544","microsoft"};
        studentsData=new String[] {"205711111","333333333","212121212","234231123","11111111"};
        moderator="menahem";
        validHours=300;
        notInDBStudent="333333332";
        invalidStudentsIDs=new String[]{"0123452r3","0123452R3","0123452@3"};

    }

    @Before
    public void setUp() throws Exception {
        bridge = Driver.getBridge();//reset and delete the data for each test


    }

    @After
    public void tearDown() throws Exception {
    }

    public boolean addProject(String pName, String desc, int hours, String fName
            , String lName, String email, String phone, String organization) {
        return bridge.addProject(pName,desc,hours,fName,lName,email,phone,organization);
    }


    public State checkProjectState(String code) {
        return bridge.checkProjectState(code);
    }


    public boolean registerToProject(Vector<String> ids,String projectName, String moderator) {
        return bridge.registerToProject(ids,projectName,moderator);
    }

    public String getCode(String projectName){
        return bridge.getCode(projectName);
    }

    //add project by number
    protected boolean addProjectAsIs(int num) {
        switch (num) {
            case 1:
                return addProject(project1[0], project1[1]
                        , validHours, project1[2], project1[3], project1[4],
                        project1[5], project1[6]);

            case 2:
                return addProject(project2[0], project2[1]
                        , validHours, project2[2], project2[3], project2[4],
                        project2[5], project2[6]);

            case 3:
                return addProject(project3[0], project3[1]
                        , validHours, project3[2], project3[3], project3[4],
                        project3[5], project3[6]);

            case 4:
                addProject(project4[0], project4[1]
                        , validHours, project4[2], project4[3], project4[4],
                        project4[5], project4[6]);

            default:
                break;

        }
        return addProject(project5[0], project5[1]
                , validHours, project5[2], project5[3], project5[4],
                project5[5], project5[6]);
    }

    protected boolean addStudents(String []students){
        return bridge.addStudents(students);
    }
    protected boolean addModerator(String moderator){
        return bridge.addModerator(moderator);
    }
}
