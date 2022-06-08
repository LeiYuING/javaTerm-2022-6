package com.leiyu.service;

import com.leiyu.mapper.ClassMapper;
import com.leiyu.pojo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.util.List;
public class ClassesServiceImpl implements ClassesService {

    private ClassMapper classMapper;

    public void setClassMapper(ClassMapper classMapper) {
        this.classMapper = classMapper;
    }

    @Override
    public int addClass(Classes classes) {
        return classMapper.addClass(classes);
    }

    @Override
    public int deleteClassById(Integer id) {
        Classes classes = classMapper.getClassById(id);
        if (classes.getSsum()>0){
            return 0;
        }
        return classMapper.deleteClassById(id);
    }

    @Override
    public int modClass(Classes classes) {
        return classMapper.modClass(classes);
    }

    @Override
    public List<Classes> getAllClass() {
        return classMapper.getAllClass();
    }
}
