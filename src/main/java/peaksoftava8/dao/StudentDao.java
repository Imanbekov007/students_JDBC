package peaksoftava8.dao;

import peaksoftava8.Gender;
import peaksoftava8.models.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    // create table
    void createTable();

    // save students
    void saveStudents(Student student);

    // find by studentsId
    Student findByStudentId(Long studentId);

    // find all
    List<Student> findAllStudents();

    // update students
    void updateStudent(Long studentId, Student newStudent);

    // delete
    void deleteStudentID(Long studentID);
    List<Student>getAllstudentSortByAge(String ascOrDesc);
    boolean checkByAge();
    Map<Gender,List<Student>> groupByGender();
    void deleteAllStudents(); //ddl;

}
