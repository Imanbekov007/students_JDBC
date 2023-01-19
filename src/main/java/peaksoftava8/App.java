package peaksoftava8;

import peaksoftava8.models.Student;
import peaksoftava8.services.StudentService;
import peaksoftava8.services.StudentServiceImpl;

import java.util.Iterator;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentService studentService=new StudentServiceImpl();

        System.out.println(studentService.deleteStudentID(15L));
        studentService.findAllStudents().forEach(System.out::println);
    }
}
