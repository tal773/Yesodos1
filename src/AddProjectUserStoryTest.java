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
        assertTrue(addProject("Azur","cloud"
                ,300,"satiya","anadela","satia@micro.com",
                "0503216544","microsoft"));
        assertTrue(addProject("iphone","phone"
                ,300,"steve","jobs","sjobs@apple.com",
                "0503216543","apple"));
    }

    @Test
    public void testAlreadyExistingProject(){
        assertTrue(addProject("Azur","cloud"
                ,300,"satiya","anadela","satia@micro.com",
                "0503216544","microsoft"));
        assertFalse(addProject("Azur","cloud"
                ,300,"satiya","anadela","satia@micro.com",
                "0503216544","microsoft"));
        assertFalse(addProject("aZur","cloud"
                ,300,"satiya","anadela","satia@micro.com",
                "0503216544","microsoft"));
    }

    @Test
    public void testInvalidAddProject(){
        //missing fields
        assertFalse(addProject("iphone",null
                ,300,"steve","jobs","sjobs@apple.com",
                "0503216543","apple"));
        assertFalse(addProject("iphone",null
                ,300,"steve","jobs","sjobs@apple.com",
                "0503216543","apple"));

        assertFalse(addProject("iphone",null
                ,300,null,"jobs","sjobs@apple.com",
                "0503216543","apple"));
        //invalid phone
        assertFalse(addProject("iphone","phone"
                ,300,"steve","jobs","sjobs@apple.com",
                "050abc6543","apple"));

        assertFalse(addProject("iphone","phone"
                ,300,"steve","jobs","sjobs@apple.com",
                "-05032#$%543","apple"));

        assertFalse(addProject("iphone","phone"
                ,300,"steve","jobs","sjobs@apple.com",
                "-0503216543","apple"));
        //invalid hours
        assertFalse(addProject("iphone","phone"
                ,-42,"steve","jobs","sjobs@apple.com",
                "0503216543","apple"));

        assertFalse(addProject("iphone","phone"
                ,0,"steve","jobs","sjobs@apple.com",
                "0503216543","apple"));

    }

    @Test
    public void testProjectCondition(){
        // there is no project with the code 112
        assertEquals(checkProjectState("112"),null);

        // there is project with the code 111
        assertNotNull(checkProjectState("111"));
    }
}
