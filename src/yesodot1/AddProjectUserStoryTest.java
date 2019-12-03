package yesodot1;

import org.junit.*;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertFalse;

public class AddProjectUserStoryTest extends  FinalProjectTest {


    @Before
    public void setUp() throws Exception {
        super.setUp();

    }


    @Test
    public void testValidAddProject() {
        assertTrue(addProjectAsIs(1));
        assertTrue(addProjectAsIs(2));
    }

    @Test
    public void testAlreadyExistingProject(){
        assertTrue(addProjectAsIs(1));
        assertFalse(addProjectAsIs(1));//try insert project 1 again
        //name is not case sensitive, all other fields are different from project 1
        assertFalse(addProject("aZur",project2[1]
                ,validHours,project2[2],project2[3],project2[4],
                project2[5],project2[6]));
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

    @Test //@TODO
    public void testProjectCondition(){
        addProjectAsIs(1);
        String code=getCode(project1[0]); //get the code of project 1
        // there is no project with the code : code+"2" because project1 is the only project in the DB
        assertNull(checkProjectState(code+"2"));

        // project 1 is with the code: code
        assertNotNull(checkProjectState(code));
    }
}
