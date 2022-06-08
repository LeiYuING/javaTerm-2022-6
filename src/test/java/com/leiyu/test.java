package com.leiyu;

import com.leiyu.mapper.ClassMapper;
import com.leiyu.pojo.Classes;
import com.leiyu.pojo.Student;
import com.leiyu.service.ClassesService;
import com.leiyu.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {


    @Test
    public void test(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        Object studentService = context.getBean("studentService");
        StudentService bean = (StudentService) studentService;
        Student student = new Student();
        student.setSname("hh");
        student.setCname("计科七班");
        student.setAge(19);
        student.setGender(0);
        int i = bean.addStudent(student);
        System.out.println(i);
//        List<Student> allStudent = bean.getAllStudent(new Student());
//        for (Student student : allStudent) {
//            System.out.println(student);
//        }
//        Classes classById = bean.getClassById(1);
//        System.out.println(classById);
//        List<Classes> allClass = bean.getAllClass();
//        for (Classes aClass : allClass) {
//            System.out.println(aClass);
//        }
    }

}
