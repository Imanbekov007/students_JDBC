package peaksoftava8.dao;

import peaksoftava8.Gender;
import peaksoftava8.config.DatabaseConnection;
import peaksoftava8.models.Student;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {
    private final Connection connection;

    public StudentDaoImpl() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public void createTable() {
        String query = """
                CREATE TABLE IF NOT EXISTS students(
                id serial primary key,
                name varchar (50) not null,
                age smallint not null
                );
                """;
        try (Statement statement = connection.createStatement();) {
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void saveStudents(Student student) {
        String sqlQuery = """
                insert into students (name, age )
                values(?,?);
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);){
            preparedStatement.setString(1, student.getName());
            preparedStatement.setByte(2, student.getAge());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Student findByStudentId(Long studentId) {
        String query = """
                select * from students where id=?;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);){

            preparedStatement.setLong(1,studentId);
            ResultSet resultSet= preparedStatement.executeQuery();
            Student student = new Student();
            while (resultSet.next()) {
                student.setID(resultSet.getLong("id"));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
            }
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAllStudents() {
        List<Student> allstudents=new ArrayList<>();
        String query= """
                select * from students;
                """;
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Student student=new Student();
                student.setID(resultSet.getLong("id"));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
                allstudents.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allstudents;
    }

    @Override
    public void updateStudent(Long studentId, Student newStudent) {
        String query = """
                update students
                set name = ?,
                age = ?
                where id =?;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setString(1,newStudent.getName());
            preparedStatement.setByte(2,newStudent.getAge());
            preparedStatement.setLong(3,studentId);
             int i = preparedStatement.executeUpdate();
             if(i > 0){
                 System.out.println("Successfully updated");
             }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteStudentID(Long studentID) {
        String  query= """
                delete from students where id = ?;
                """;
        try (PreparedStatement preparedStatement= connection.prepareStatement(query)){
            preparedStatement.setLong(1,studentID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        {
        }

    }

    @Override
    public List<Student> getAllstudentSortByAge(String ascOrDesc) {
        List<Student> allstudentsages = new ArrayList<>();
        switch (ascOrDesc) {
            case ("asc"):
                String query = """
                select * from students
                order by age;
                """;
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Student student=new Student();
                student.setID(resultSet.getLong("id"));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
                allstudentsages.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allstudentsages;
            case ("desc"):
                String query2 = """
                select * from students
                order by age desc ;
                """;
                try {
                    Statement statement=connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query2);
                    while (resultSet.next()){
                        Student student=new Student();
                        student.setID(resultSet.getLong("id"));
                        student.setName(resultSet.getString(2));
                        student.setAge(resultSet.getByte(3));
                        allstudentsages.add(student);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                return allstudentsages;
    }
    return null;
    }

    @Override
    public boolean checkByAge() {
        
        return true;
    }



    @Override
    public Map<Gender, List<Student>> groupByGender() {

        return null;
    }

    @Override
    public void deleteAllStudents() {
        String query= """
                truncate table students;
                """;
        try (Statement statement=connection.createStatement()){
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
