package com.James.Dao;

import com.James.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao {
    public static HashMap<Integer,Student> student;
    static {
        student = new HashMap<Integer, Student>(){
            {
                put(1,new Student(1,"Marrow","nothing"));
            }
        };
    }
    @Override
    public Collection<Student> getAllStudents() {
        return student.values();
    }

    @Override
    public Student getStudentById(int id) {
        return student.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.student.remove(id);
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudentToDb(Student student) {

    }
}
