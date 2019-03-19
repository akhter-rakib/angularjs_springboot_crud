package com.rakib.angularjs_springboot_crud.restController;

import com.rakib.angularjs_springboot_crud.entity.model.Student;
import com.rakib.angularjs_springboot_crud.service.innterface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }
}
