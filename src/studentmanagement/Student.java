package studentmanagement;

import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.ArrayList;
/**
 *
 * @author rhian
 */
public class Student {
    
    ArrayList<String> studentID = new ArrayList<String>();              //Array List used to save student IDs
    ArrayList<String> studentName = new ArrayList<String>();            //Array List used to save student Names
    ArrayList<Integer> studentAge = new ArrayList<Integer>();           //Array List used to save student Ages
    ArrayList<String> studentEmail = new ArrayList<String>();           //Array List used to save student Emails
    ArrayList<String> studentCourse = new ArrayList<String>();          //Array List used to save student Courses

    /*--------------------------------------------- PART 1 - QUESTION 1 --------------------------------------------*/
    
    /* -------------------------------------------- CONSTRUCTORS ---------------------------------------------------*/
    
    Student()
    {       
        
    }
    
    Student(String name, String id, String email, String course, int age)
    {
        studentID.add(id);
        studentName.add(name);
        studentAge.add(age);
        studentEmail.add(email);
        studentCourse.add(course);
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* --------------------------------- FUNCTION USED TO VALIDATE STUDENT AGE --------------------------------------*/
    
    public boolean StudentAge(String age)
    {
        boolean num = true;
        
        for (int i=0; i < age.length(); i++)         
        {
            if (Character.isDigit(age.charAt(i)) == false)
            {
                num = false;

                break;
            }
            else
            {
                num = true;
            }
        }
        
        if(num == true)
        {
            if(Integer.parseInt(age) < 16)
            {
                num = false;
            }
        }
        
        return num;
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* ------------------------------ FUNCTION THAT SERVES AS APPLICATION START UP ----------------------------------*/
    
    public void StartMenu()
    {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("*********************************************");
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        if (input.equals("1"))
        {
            MenuApplication();                      
        }
        else
        {
            ExitStudentApplication();
        }        
        
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* ------------------------------ FUNCTION THAT EXITS APPLICATION -----------------------------------------------*/
    
    public void ExitStudentApplication()
    {
        System.exit(0);
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* ------------------------------ FUNCTION THAT SERVES AS APPLICATION MENU --------------------------------------*/
    
    public void MenuApplication()
    {
        System.out.println("Plese select one of the following items:");
        System.out.println("1) Capture a new student");
        System.out.println("2) Search for a student");
        System.out.println("3) Delete a student");
        System.out.println("4) Print student report");
        System.out.println("5) Exit Application");
        
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Scanner scan1 = new Scanner(System.in);
        
        if (input.equals("5"))
        {
            ExitStudentApplication();
        }
        else if (input.equals("1"))
        {
            boolean flag = false;
            
            System.out.println("CAPTURE A NEW STUDENT");
            System.out.println("*********************************************");

            Scanner scan2 = new Scanner(System.in);

            System.out.print("Enter the student id: ");
            String id = scan2.next();

            System.out.print("Enter the student name: ");
            String name = sc.next();

            System.out.print("Enter the student age: ");
            String age = scan2.next();

            Scanner scan = new Scanner(System.in);

            flag = StudentAge(age);

            while (!flag)
            {
                System.out.println("You have entered an incorrect student age!!! ");                                       

                System.out.print("Please re-enter the student age >> ");
                age = scan.next();

                flag = StudentAge(age);
            }

            System.out.print("Enter the student email: ");
            String email = scan2.next();        

            System.out.print("Enter the student course: ");
            String course = scan2.next();

           // AddStudent(name, id, email, course, Integer.parseInt(input));

            System.out.println("--------------------------------------------------------------------");

            System.out.println(SaveStudent(name, id, email, course, Integer.parseInt(input)));
                                
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            input = scan1.nextLine();

            if (input.equals("1"))
            {
                MenuApplication();                      
            }
            else
            {
                ExitStudentApplication();
            } 
        }
        else if (input.equals("2"))
        {
            Scanner scan3 = new Scanner(System.in);
        
            System.out.print("Enter the student id to search: ");
            String searchId = scan3.next();
           
            System.out.println(SearchStudent(searchId));
            
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            input = scan1.nextLine();

            if (input.equals("1"))
            {
                MenuApplication();                      
            }
            else
            {
                ExitStudentApplication();
            } 
        }
        else if (input.equals("3"))
        {
            Scanner scan4 = new Scanner(System.in);
        
            System.out.print("Enter the student id to delete: ");
            String deleteId = scan4.next();

            System.out.print("Are you sure you want to delete student " + deleteId + " from the system? Yes (y) to delete. ");
            String answer = sc.next();

            if (answer.equals("y"))
            {

                System.out.println(DeleteStudent(deleteId));
            }        
            
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            input = scan1.nextLine();

            if (input.equals("1"))
            {
                MenuApplication();                      
            }
            else
            {
                ExitStudentApplication();
            } 
        }
        else if (input.equals("4"))
        {
            StudentReport();
            
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            input = scan1.nextLine();

            if (input.equals("1"))
            {
                MenuApplication();                      
            }
            else
            {
                ExitStudentApplication();
            } 
        }
        
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* ---------------- FUNCTION THAT SAVES STUDENT DETAILS TO APPROPRIATE ARRAYS -----------------------------------*/
    
    public String SaveStudent(String name, String id, String email, String course, int age)
    {
        studentID.add(id);
        studentName.add(name);
        studentEmail.add(email);
        studentCourse.add(course);
        studentAge.add(age);
        
        String output = "Thank you! The student's information has been succesfully saved.";
        
        return output;
    }   
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* ------------------------------ FUNCTION THAT SEARCHES ID ARRAY FOR USER INPUT --------------------------------*/
        
    public String SearchStudent(String id)
    {
        String course = "";
        String name = "";
        String email = "";
        int age = 0;
        boolean found = false;
        String output = "";
        
        for (int i = 0; i < studentID.size(); i++) 
        {            
            if (studentID.get(i).equals(id))
            {                
                found = true;
                name = studentName.get(i);
                email = studentEmail.get(i);
                course = studentCourse.get(i); 
                age = studentAge.get(i);
                
                break;
            }
        }
        
        System.out.println("--------------------------------------------------------------------");
        
        if (found == true)
        {
            output = "STUDENT ID: " + id + "\n" + "STUDENT NAME: " + name + "\n" + "STUDENT AGE: " + Integer.toString(age) + "\n" + "STUDENT EMAIL: " + email + "\n" + "STUDENT COURSE: " + course;
        }
        else if (found == false)
        {
                  
            output = "Student with id: " + id + " was not found!";
        }
        
        return output;
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* ----------------- FUNCTION THAT SEARCHES ID ARRAY FOR USER INPUT AND REMOVES FOUND ITEM ----------------------*/
    
    public String DeleteStudent(String id)
    {
        boolean found = false;
        String output = "";
        
        for (int i = 0; i < studentID.size(); i++) 
        {
            if (studentID.get(i).equals(id))
            {
                found = true;
                studentName.remove(i);
                studentEmail.remove(i);
                studentCourse.remove(i); 
                studentAge.remove(i);
                studentID.remove(i);

                break;
            }
        }
        
        System.out.println("--------------------------------------------------------------------");

        if (found == true)
        {
            output = "Student with id: " + id + " WAS deleted!";
        }
        else
        {
            output = "Student with id: " + id + " was not found!";
        }
        
        return output;
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* ----------------------- FUNCTION THAT LOOPS THROUGH ALL ARRAYS AND PRINTS ITEMS ------------------------------*/
    
    public void StudentReport()
    {
        int counter = 1;
        
        for (int i = 0; i < studentID.size(); i++)
        {
            System.out.println("STUDENT " + Integer.toString(counter));
            System.out.println("--------------------------------------------------------------------");
            System.out.println("STUDENT ID: " + studentID.get(i));
            System.out.println("STUDENT NAME: " + studentName.get(i));
            System.out.println("STUDENT AGE: " + Integer.toString(studentAge.get(i)));
            System.out.println("STUDENT EMAIL: " + studentEmail.get(i));
            System.out.println("STUDENT COURSE: " + studentCourse.get(i));
            
            if (i != studentID.size()-1)
            {
                System.out.println("--------------------------------------------------------------------");
            }
           // System.out.println("-----------------------------------------");
            
            counter++;
        }
        
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
}
