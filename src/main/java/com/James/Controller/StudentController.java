package com.James.Controller;

import com.James.Entity.Student;
import com.James.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired // 可以不用new
    private StudentService studentService ;

    // 上面有 map 就不用特別寫
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudent(){
        return  studentService.getAllStudents();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id){
        this.studentService.removeStudentById(id);
    }

    // 選擇讀取物件的方式
    // 要讀寫body 所以要加 RequestBody
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudentById(@RequestBody Student student){
        this.studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        this.studentService.insertStudent(student);
    }

}
