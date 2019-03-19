package com.rakib.angularjs_springboot_crud.repository;

import com.rakib.angularjs_springboot_crud.entity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespository extends JpaRepository<Student, Long> {
}
