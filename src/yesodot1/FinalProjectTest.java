package yesodot1;

import org.junit.*;

import java.util.Vector;


public class FinalProjectTest {
    private Bridge bridge;
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


    public boolean registerToProject(Vector<String> ids, String moderator) {
        return bridge.registerToProject(ids,moderator);
    }
}
