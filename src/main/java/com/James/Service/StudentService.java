package com.James.Service;

import com.James.Dao.StudentDao;
import com.James.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Collection;


@Service
public class StudentService {


    @Autowired // 可以不用new
    @Qualifier("mongoData") // 做選擇 查看Dao底下class
    private StudentDao studentDao;

    public  void removeStudentById(int id) {
        this.studentDao.removeStudentById(id);
    }

    public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }

    public Student getStudentById(int id){ // check if student exist
        return this.studentDao.getStudentById(id);
    }

    public void updateStudent(Student student){
       this.studentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentDao.insertStudentToDb(student);
    }
}
