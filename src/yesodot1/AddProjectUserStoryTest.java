package yesodot1;

import org.junit.*;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertFalse;

public class AddProjectUserStoryTest extends  FinalProjectTest {

    String [] project1, project2;
    int validHours=300;
    @Before
    public void setUp() throws Exception {
        super.setUp();
         project1= new String[]{"Azur","cloud",
                "satiya","anadela","satia@micro.com",
                "0503216544","microsoft"};
         project2 = new String[]{"iphone","phone"
                ,"steve","jobs","sjobs@apple.com",
                "0503216543","apple"};
    }

    private boolean addProjectAsIs(int num){
        if(num ==1)
        return addProject(project1[0],project1[1]
                ,validHours,project1[2],project1[3],project1[4],
                project1[5],project1[6]);
        else
            return  addProject(project2[0],project2[1]
                    ,validHours,project2[2],project2[3],project2[4],
                    project2[5],project2[6]);

    }
    @Test
    public void testValidAddProject() {
        assertTrue(addProjectAsIs(1));
        assertTrue(addProjectAsIs(2));
    }

    @Test
    public void testAlreadyExistingProject(){
        assertTrue(addProjectAsIs(1));
        assertFalse(addProjectAsIs(2));
        assertFalse(addProject("aZur",project1[1]
                ,validHours,project1[2],project1[3],project1[4],
                project1[5],project1[6]));
    }

    @Test
    public void testInvalidAddProject(){
        //missing fields
        assertFalse(addProject(project2[0],null
                ,validHours,project2[2],project2[3],project2[4],
                project2[5],project2[6]));

        assertFalse(addProject(project2[0],null
                ,validHours,null,project2[3],project2[4],
                project2[5],project2[6]));
        //invalid phone
        assertFalse(addProject(project2[0],project2[1]
                ,validHours,project2[2],project2[3],project2[4],
                "050abc6543",project2[6]));

        assertFalse(addProject(project2[0],project2[1]
                ,validHours,project2[2],project2[3],project2[4],
                "-05032#$%543",project2[6]));

        assertFalse(addProject(project2[0],project2[1]
                ,validHours,project2[2],project2[3],project2[4],
                "-0503216543",project2[6]));
        //invalid hours
        assertFalse(addProject(project2[0],project2[1]
                ,-42,project2[2],project2[3],project2[4],
                project2[5],project2[6]));

        assertFalse(addProject(project2[0],project2[1]
                ,0,project2[2],project2[3],project2[4],
                project2[5],project2[6]));

    }

    @Test
    public void testProjectCondition(){
        // there is no project with the code 112
        assertEquals(checkProjectState("112"),null);

        // there is project with the code 111
        assertNotNull(checkProjectState("111"));
    }
}
