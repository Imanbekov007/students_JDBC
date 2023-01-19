package peaksoftava8.services;

import peaksoftava8.Gender;
import peaksoftava8.dao.StudentDao;
import peaksoftava8.dao.StudentDaoImpl;
import peaksoftava8.models.Student;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService{
    StudentDao studentDao=new StudentDaoImpl();
    @Override
    public String creatTable() {
        studentDao.createTable();
        return "Successfully added";
    }

    @Override
    public String saveStudents(Student student) {
        studentDao.saveStudents(student);
        return "Successfully saved";
    }

    @Override
    public Student findByStudentId(Long studentId) {
       return studentDao.findByStudentId(studentId);

    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAllStudents();
    }

    @Override
    public String updateStudent(Long studentId, Student newStudent) {
         studentDao.updateStudent(studentId,newStudent);
         return "successfully updated";
    }



    @Override
    public String deleteStudentID(Long studentID) {
        studentDao.deleteStudentID(studentID);
        return "Successfully deleted";
    }

    @Override
    public List<Student> getAllstudentSortByAge(String ascOrDesc) {
        return studentDao.getAllstudentSortByAge(ascOrDesc);
    }

    @Override
    public String checkByAge() {
        return null;
    }


    @Override
    public Map<Gender, List<Student>> groupByGender() {
        return null;
    }

    @Override
    public String deleteAllStudents() {
        studentDao.deleteAllStudents();
        return "Successfully deleted";
    }
}
