package com.rakib.angularjs_springboot_crud.service.innterface;

import com.rakib.angularjs_springboot_crud.entity.model.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    List<Student> list();

    Student delete(Long id);

    Student get(Long id);

}
