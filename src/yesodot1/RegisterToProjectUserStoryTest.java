package yesodot1;

import org.junit.*;

import java.util.Vector;

import static junit.framework.TestCase.*;

public class RegisterToProjectUserStoryTest extends FinalProjectTest {

    Vector<String> students;
    @Before
    public void setUp() throws Exception{
        super.setUp();
        students=new Vector<>();
        students.add("205711111");

    }

    @Test//try 1 to 4 registration
    public void validRegistertion(){
        //menahem is a moderator that has 0 projects and the students are not signed to a project yet
        assertTrue(registerToProject(students,"menahem"));//1 student
        students.add("333333333");
        assertTrue(registerToProject(students,"menahem"));//2 students
        students.add("212121212");
        assertTrue(registerToProject(students,"menahem"));//3 students
        students.add("234231123");
        assertTrue(registerToProject(students,"menahem"));//4 students
    }

    @Test//try 5 students registration
    public void toManyStudentsRegistration(){
        //menahem is a moderator that has 0 projects and the students are not signed to a project yet
        students.add("333333333");
        students.add("333333331");
        students.add("333333332");
        students.add("333333334");
        assertFalse(registerToProject(students,"menahem"));
    }

    @Test
    public void toManyProjectToModerator(){
        //menahem is a moderator that has 0 projects and the students are not signed to a project yet
        registerToProject(students,"menahem");//first project
        students.clear();
        students.add("333333333");
        registerToProject(students,"menahem");//second project
        students.clear();
        students.add("333333331");
        registerToProject(students,"menahem");//third project
        students.clear();
        students.add("333333332");
        registerToProject(students,"menahem");//forth time
        students.clear();
        students.add("333333335");
        assertFalse(registerToProject(students,"menahem"));//fifth time: error
    }

    @Test
    public void oneOfStudentsAlreadyAssignedToProject(){
        //menahem and mira are moderators that have 0 projects and the student 205711111
        // is not signed to a project yet
        registerToProject(students,"menahem");
        assertFalse(registerToProject(students,"mira"));
        students.add("333333333");
        //try 2 students and one of them is assigned to project
        assertFalse(registerToProject(students,"mira"));
        students.add("333333331");
        //try 3 students and one of them is assigned to project
        assertFalse(registerToProject(students,"mira"));
        students.add("333333332");
        //try 4 students and one of them is assigned to project
        assertFalse(registerToProject(students,"mira"));
    }

    @Test
    public void oneOfStudentsIsNotInDB(){
        //menahem is a moderator that has 0 projects and 205711112 is not in the DB,the rest of students
        // are in DB and are not assigned to a project
        students.clear();
        students.add("205711112");//not in DB
        assertFalse(registerToProject(students,"menahem"));
        students.add("333333333");
        //try 2 students and one of them is not in the DB
        assertFalse(registerToProject(students,"menahem"));
        students.add("333333331");
        //try 3 students and one of them is not in the DB
        assertFalse(registerToProject(students,"menahem"));
        students.add("333333332");
        //try 4 students and one of them is not in the DB
        assertFalse(registerToProject(students,"menahem"));
    }

    @Test
    public void oneOfStudentsContainsNotDigitChar(){
        //menahem is a moderator that has 0 projects and 205711111 is not in the DB
        students.add("0123452r3");
        assertFalse(registerToProject(students,"menahem"));//try with small letter
        students.clear();
        students.add("0123452R3");
        assertFalse(registerToProject(students,"menahem"));//try with capital letter
        students.clear();
        students.add("0123452@3");
        assertFalse(registerToProject(students,"menahem"));//try with special char
        students.clear();
        students.add("0123452נ3");
        assertFalse(registerToProject(students,"menahem"));//try with hebrew letter

    }

    @After
    public void tearDown (){
        students.clear();
    }

}
