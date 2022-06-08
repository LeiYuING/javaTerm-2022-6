package com.leiyu.controller;

import com.leiyu.pojo.Student;
import com.leiyu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    ModelAndView studentList(ModelAndView modelAndView, @RequestParam(value = "cname") @Nullable String cname,@Nullable @RequestParam("sname")String sname){
        Student student = new Student();
        student.setCname(cname);
        student.setSname(sname);
        List<Student> studentsList = studentService.getAllStudent(student);
        modelAndView.addObject("studentList",studentsList);
        modelAndView.setViewName("jsp/studentList");
        return modelAndView;
    }

    @RequestMapping("/sadd")
    ModelAndView sadd(ModelAndView modelAndView,Student student){
        try {
            studentService.addStudent(student);
            modelAndView.setViewName("redirect:/student/list");
        } catch (Exception e) {
            modelAndView.addObject("error","添加失败");
            modelAndView = studentList(modelAndView,null,null);
        }
        return modelAndView;
    }

    @RequestMapping("/to-modStudent/{id}")
    ModelAndView to_mods(ModelAndView modelAndView,@PathVariable("id")int id){
        modelAndView.addObject("id",id);
        modelAndView.setViewName("jsp/studentMod");
        return modelAndView;
    }

    @RequestMapping("/delStudent/{id}")
    ModelAndView dels(ModelAndView modelAndView,@PathVariable("id")int id){
        try {
            studentService.deleteStudentById(id);
            modelAndView.setViewName("redirect:/student/list");
        } catch (Exception e) {
            modelAndView.addObject("error","删除失败");
            modelAndView = studentList(modelAndView,null,null);
        }
        return modelAndView;
    }

    @RequestMapping("/modStudent")
    ModelAndView mods(ModelAndView modelAndView,Student student){
        try {
            studentService.modStudent(student);
            modelAndView.setViewName("redirect:/student/list");
        } catch (Exception e) {
            modelAndView.addObject("error","修改失败");
            modelAndView = studentList(modelAndView,null,null);
        }
        return modelAndView;
    }

    @RequestMapping("/addPhoto")
    ModelAndView addp(ModelAndView modelAndView, @RequestParam("id")int id, BindingResult br, @RequestParam(value = "headURL",required = false) MultipartFile file){
        System.out.println(file);
        if (br.hasErrors()){
            modelAndView.addObject("error","图片上传失败");
            modelAndView = studentList(modelAndView,null,null);
        }else {
            String path = "C:\\Users\\User_LeiYu\\IdeaProjects\\JavaTerm\\web\\upload";

            File realPath = new File(path);
            if (!realPath.exists()){
                realPath.mkdirs();
            }

            String filename = "pg-" + UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
            File newfile = new File(realPath, filename);
            try {
                file.transferTo(newfile);
                Map<Object, Object> map = new HashMap<>();
                map.put("id",id);
                map.put("photo",filename);
                studentService.addPhoto(map);
                modelAndView.setViewName("redirect:/student/list");
            } catch (IOException e) {
                modelAndView.addObject("error","图片上传失败");
                modelAndView = studentList(modelAndView,null,null);
            }

        }
        return modelAndView;
    }

    @RequestMapping("to-upload/{id}")
    public ModelAndView to_update(ModelAndView modelAndView,@PathVariable("id")int id){
        modelAndView.addObject("id",id);
        modelAndView.setViewName("jsp/photoUpdate");
        return modelAndView;
    }
}
