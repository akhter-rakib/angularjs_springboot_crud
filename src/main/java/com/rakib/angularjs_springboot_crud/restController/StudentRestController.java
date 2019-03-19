package com.rakib.angularjs_springboot_crud.restController;

import com.rakib.angularjs_springboot_crud.entity.model.Student;
import com.rakib.angularjs_springboot_crud.service.innterface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public List<Student> getStudentList() {
        return studentService.list();
    }

    @RequestMapping(value = "/getStudent/{id}")
    public Student getStudent(@PathVariable("id") Long id) throws Exception {
        return studentService.get(id);
    }

    @RequestMapping(value = "/deleteStudent/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.delete(id);
    }
}
