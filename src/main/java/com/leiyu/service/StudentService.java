package com.leiyu.service;

import com.leiyu.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentService {
    int addPhoto(Map map);

    int addStudent(Student student);

    int deleteStudentById(Integer id);

    int modStudent(Student student);

    List<Student> getAllStudent(Student student);
}
