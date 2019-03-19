package com.rakib.angularjs_springboot_crud.service.Impl;

import com.rakib.angularjs_springboot_crud.config.ActiveStatus;
import com.rakib.angularjs_springboot_crud.entity.model.Student;
import com.rakib.angularjs_springboot_crud.repository.StudentRespository;
import com.rakib.angularjs_springboot_crud.service.innterface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRespository studentRespository;

    @Override
    public void saveStudent(Student student) {
        studentRespository.save(student);
    }

    @Override
    public List<Student> list() {
        return studentRespository.list(ActiveStatus.ACTIVE.getValue());
    }

    @Override
    public Student delete(Long id) {
        Student student = get(id);
        student.setActiveStatus(ActiveStatus.DELETE.getValue());
        studentRespository.save(student);
        return student;
    }

    @Override
    public Student get(Long id) {
        return studentRespository.getOne(id);
    }
}
