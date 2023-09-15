/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package studentmanagement;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rhian
 */
public class StudentTest {
    
    public StudentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of SaveStudent method, of class Student.
     */
    @Test
    public void TestSaveStudent() {
        System.out.println("SaveStudent");
        Student instance = new Student();
        
        
        String expResult = "Thank you! The student's information has been succesfully saved.";
        
        String result = instance.SaveStudent("J.Bloggs", "10111" , "jbloggs@ymail.com", "disd", 19);
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }

    /**
     * Test of SearchStudent method, of class Student - FINDS VALID ID
     */
    @Test
    public void TestSearchStudent() {
        System.out.println("SearchStudent");
        Student instance = new Student("J.Bloggs", "10111" , "jbloggs@ymail.com", "disd", 19);
        
        String expResult = """
                           STUDENT ID: 10111
                           STUDENT NAME: J.Bloggs
                           STUDENT AGE: 19
                           STUDENT EMAIL: jbloggs@ymail.com
                           STUDENT COURSE: disd""";
        
        String result = instance.SearchStudent("10111");
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
    /**
     * Test of SearchStudent method, of class Student - SEARCHES FOR INVALID ID
     */
    @Test
    public void TestSearchStudent_StudentNotFound() {
        System.out.println("SearchStudent");
        Student instance = new Student("J.Bloggs", "10111" , "jbloggs@ymail.com", "disd", 19);
        
        String expResult = "Student with id: 10112 was not found!";
        
        String result = instance.SearchStudent("10112");
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }

    /**
     * Test of DeleteStudent method, of class Student - FINDS AND DELTES VALID ID
     */
    @Test
    public void TestDeleteStudent() {
        System.out.println("DeleteStudent");
        Student instance = new Student("J.Bloggs", "10111" , "jbloggs@ymail.com", "disd", 19);
        instance.SaveStudent("J.Doe", "10112" , "jdoe@ymail.com", "disd", 21);
        
        String expResult = "Student with id: 10112 WAS deleted!";
        
        String result = instance.DeleteStudent("10112");
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
    /**
     * Test of DeleteStudent method, of class Student - SEARCHES FOR INVALID ID
     */
    @Test
    public void TestDeleteStudent_StudentNotFound() {
        System.out.println("DeleteStudent");
        Student instance = new Student("J.Bloggs", "10111" , "jbloggs@ymail.com", "disd", 19);
        instance.SaveStudent("J.Doe", "10112" , "jdoe@ymail.com", "disd", 21);
        
        String expResult = "Student with id: 10113 was not found!";
        
        String result = instance.DeleteStudent("10113");
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }

    /**
     * Test of StudentAge method, of class Student - VALIDATES CORRECT AGE
     */
    @Test
    public void TestStudentAge_StudentAgeValid() {
        System.out.println("StudentAge");
        String age = "16";
        Student instance = new Student();
        
        boolean expResult = true;
        
        boolean result = instance.StudentAge(age);
        
        assertEquals(expResult, result);
        
        
        System.out.println(" ");
    }
    
    /**
     * Test of StudentAge method, of class Student - VALIDATES INCORRECT AGE
     */
    @Test
    public void TestStudentAge_StudentAgeInvalid() {
        System.out.println("StudentAge");
        String age = "10";
        Student instance = new Student();
        
        boolean expResult = false;
        
        boolean result = instance.StudentAge(age);
        
        assertEquals(expResult, result);
        
        
        System.out.println(" ");
    }
    
    /**
     * Test of StudentAge method, of class Student - VALIDATES NON-INTEGER AGE
     */
    @Test
    public void TestStudentAge_StudentAgeInvalidCharacter() {
        System.out.println("StudentAge");
        String age = "c";
        Student instance = new Student();
        
        boolean expResult = false;
        
        boolean result = instance.StudentAge(age);
        
        assertEquals(expResult, result);
        
        
        System.out.println(" ");
    }

    
}
