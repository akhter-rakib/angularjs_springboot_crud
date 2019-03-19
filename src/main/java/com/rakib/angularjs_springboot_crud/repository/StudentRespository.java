package com.rakib.angularjs_springboot_crud.repository;

import com.rakib.angularjs_springboot_crud.entity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRespository extends JpaRepository<Student, Long> {

    @Query("select std from Student std where std.activeStatus=(:activeStatus)")
    List<Student> list(@Param("activeStatus") Integer activeStatus);
}
