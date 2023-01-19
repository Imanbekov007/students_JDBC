package peaksoftava8.services;

import peaksoftava8.Gender;
import peaksoftava8.models.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    // create table
    String creatTable();

    // save students
    String saveStudents(Student student);

    // find by studentsId
    Student findByStudentId(Long studentId);

    //find all
    List<Student> findAllStudents();

    // update students
    String updateStudent(Long studentId, Student newStudent);

    //delete
    String deleteStudentID(Long studentID);
    List<Student> getAllstudentSortByAge(String ascOrDesc);
    String  checkByAge();
    Map<Gender,List<Student>> groupByGender();
    String  deleteAllStudents();

}
