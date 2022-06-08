package com.leiyu.mapper;

import com.leiyu.pojo.Classes;
import com.leiyu.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface StudentMapper {

    int addPhoto(Map map);

    int addClassSum(@Param("id") Integer id);

    int addStudent(Student student);

    int deleteStudentById(@Param("id") Integer id);

    int modStudent(Student student);

    List<Student> getAllStudent(Student student);
}
