package com.leiyu.controller;

import com.leiyu.pojo.Classes;
import com.leiyu.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    @RequestMapping("/list")
    ModelAndView classList(ModelAndView modelAndView){
        List<Classes> classList = classesService.getAllClass();
        modelAndView.addObject("classList",classList);
        modelAndView.setViewName("jsp/classList");
        return modelAndView;
    }

    @GetMapping("/delClass/{id}")
    ModelAndView delClass(ModelAndView modelAndView, @PathVariable("id")int id){
        int i = classesService.deleteClassById(id);
        if (i>0){
            modelAndView.setViewName("redirect:/class/list");
            return modelAndView;
        }
        modelAndView.addObject("error","删除失败");
        modelAndView = classList(modelAndView);
        return modelAndView;
    }

    @RequestMapping("/to-modClass/{id}")
    ModelAndView toModClass(ModelAndView modelAndView,@PathVariable("id") int id){
        modelAndView.addObject("id",id);
        modelAndView.setViewName("/jsp/classMod");
        return modelAndView;
    }

    @RequestMapping("/addClass")
    ModelAndView addClass(ModelAndView modelAndView,Classes classes){
        try {
            classesService.addClass(classes);
            modelAndView.setViewName("redirect:/class/list");
        } catch (Exception e) {
            modelAndView.addObject("error","添加失败");
            modelAndView = classList(modelAndView);
        }
        return modelAndView;
    }

    @RequestMapping("/modClass")
    ModelAndView modClass(ModelAndView modelAndView,Classes classes){
        try {
            classesService.modClass(classes);
            modelAndView.setViewName("redirect:/class/list");
        }catch (Exception e){
            modelAndView.addObject("error","修改失败");
            modelAndView = classList(modelAndView);
        }
        return modelAndView;
    }


}
