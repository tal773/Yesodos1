package yesodot1;

import org.junit.*;
import static junit.framework.TestCase.*;

public class addDataTest extends FinalProjectTest {

    @Before
    public void setUp() throws Exception {
        super.setUp();

    }

    @Test
    public void addDataTest(){
        //test that the add functions are working for the test
        assertTrue(addStudents(studentsData));
        assertTrue(addModerator(moderator));
    }
}
