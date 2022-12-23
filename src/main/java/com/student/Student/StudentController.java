package com.student.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) throws IllegalAccessException {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) throws IllegalAccessException {
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path="{studentId}")
    public void updateStudent(
    @PathVariable("studentId") Long studentId,
    @RequestParam(required = false) String name,
    @RequestParam(required = false) String email
    ) throws IllegalAccessException {
        studentService.updateStudent(studentId,name,email);
    }


}
