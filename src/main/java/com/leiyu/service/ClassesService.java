package com.leiyu.service;

import com.leiyu.pojo.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassesService {
    int addClass(Classes classes);

    int deleteClassById(Integer id);

    int modClass(Classes classes);

    List<Classes> getAllClass();

}
