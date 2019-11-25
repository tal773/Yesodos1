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
    }
}
