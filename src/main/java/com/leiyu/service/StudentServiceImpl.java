package com.leiyu.service;

import com.leiyu.mapper.StudentMapper;
import com.leiyu.pojo.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService{
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public int addPhoto(Map map) {
        return studentMapper.addPhoto(map);
    }

    @Transactional
    @Override
    public int addStudent(Student student) {
        studentMapper.addClassSum(student.getId());
        return studentMapper.addStudent(student);
    }

    @Override
    public int deleteStudentById(Integer id) {
        return studentMapper.deleteStudentById(id);
    }

    @Override
    public int modStudent(Student student) {
        return studentMapper.modStudent(student);
    }

    @Override
    public List<Student> getAllStudent(Student student) {
        return studentMapper.getAllStudent(student);
    }
}


