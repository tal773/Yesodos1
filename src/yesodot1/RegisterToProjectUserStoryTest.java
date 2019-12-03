package yesodot1;

import org.junit.*;

import java.util.Vector;

import static junit.framework.TestCase.*;

public class RegisterToProjectUserStoryTest extends FinalProjectTest {

    private Vector<String> students;
    @Before
    public void setUp() throws Exception{
        super.setUp();
        students=new Vector<>();
        students.add(studentsData[0]);
        //add students and moderators data to the DB of the project
        addStudents(studentsData);
        addModerator(moderator);
        //insert projects for testing
        addProjectAsIs(1);
        addProjectAsIs(2);
        addProjectAsIs(3);
        addProjectAsIs(4);

    }

    @Test//try 1 to 4 registration
    public void validRegistertion(){
        //menahem is a moderator that has 0 projects and the students are not signed to a project yet
        assertTrue(registerToProject(students,project1[0],moderator));//1 student
        students.add(studentsData[1]);
        assertTrue(registerToProject(students,project2[0],moderator));//2 students
        students.add(studentsData[2]);
        assertTrue(registerToProject(students,project3[0],moderator));//3 students
        students.add(studentsData[3]);
        assertTrue(registerToProject(students,project4[0],moderator));//4 students
    }

    @Test//try 5 students registration
    public void toManyStudentsRegistration(){
        //menahem is a moderator that has 0 projects and the students are not signed to a project yet
        students.add(studentsData[1]);
        students.add(studentsData[2]);
        students.add(studentsData[3]);
        students.add(studentsData[4]);
        assertFalse(registerToProject(students,project1[0],moderator));
    }

    @Test
    public void toManyProjectToModerator(){
        //menahem is a moderator that has 0 projects and the students are not signed to a project yet
        registerToProject(students,project1[0],moderator);//first project
        students.clear();
        students.add(studentsData[1]);
        registerToProject(students,project2[0],moderator);//second project
        students.clear();
        students.add(studentsData[2]);
        registerToProject(students,project3[0],moderator);//third project
        students.clear();
        students.add(studentsData[3]);
        registerToProject(students,project4[0],moderator);//forth time
        students.clear();
        students.add(studentsData[4]);
        addProjectAsIs(5);//add fifth project for another valid project that is not taken in the DB
        assertFalse(registerToProject(students,project5[0],moderator));//fifth time: error
    }

    @Test
    public void oneOfStudentsAlreadyAssignedToProject(){
        //menahem is a moderator that has 0 projects and the student studentData[0]
        // is not signed to a project yet
        registerToProject(students,project1[0],moderator);//assigned studentData[0] to project
        //try 1 student that assigned to project
        assertFalse(registerToProject(students,project2[0],moderator));
        students.add(studentsData[1]);
        //try 2 students and one of them is assigned to project
        assertFalse(registerToProject(students,project3[0],moderator));
        students.add(studentsData[2]);
        //try 3 students and one of them is assigned to project
        assertFalse(registerToProject(students,project4[0],moderator));
        students.add(studentsData[3]);
        //try 4 students and one of them is assigned to project
        assertFalse(registerToProject(students,project4[0],moderator));
    }

    @Test
    public void oneOfStudentsIsNotInDB(){
        //menahem is a moderator that has 0 projects and notInDBStudnet is not in the DB,the rest of students
        // are in DB and are not assigned to a project
        students.clear();
        students.add(notInDBStudent);//not in DB
        assertFalse(registerToProject(students,project2[0],moderator));
        students.add(studentsData[1]);
        //try 2 students and one of them is not in the DB
        assertFalse(registerToProject(students,project2[0],moderator));
        students.add(studentsData[2]);
        //try 3 students and one of them is not in the DB
        assertFalse(registerToProject(students,project2[0],moderator));
        students.add(studentsData[3]);
        //try 4 students and one of them is not in the DB
        assertFalse(registerToProject(students,project2[0],moderator));
    }

    @Test
    public void oneOfStudentsContainsNotDigitChar(){
        //menahem is a moderator that has 0 projects and 205711111 is not in the DB
        students.add(invalidStudentsIDs[0]);
        assertFalse(registerToProject(students,project2[0],moderator));//try with small letter
        students.clear();
        students.add(invalidStudentsIDs[1]);
        assertFalse(registerToProject(students,project2[0],moderator));//try with capital letter
        students.clear();
        students.add(invalidStudentsIDs[2]);
        assertFalse(registerToProject(students,project2[0],moderator));//try with special char

    }

    @Test
    public void projectNameNotInDB(){
        //valid moderator valid students and project name that not in the data base
        assertFalse(registerToProject(students,project5[0],moderator));
    }

}
