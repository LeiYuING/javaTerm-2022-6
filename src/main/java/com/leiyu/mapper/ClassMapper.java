package com.leiyu.mapper;

import com.leiyu.pojo.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface ClassMapper {
    int addClass(Classes classes);

    int deleteClassById(@Param("id") Integer id);

    int modClass(Classes classes);

    List<Classes> getAllClass();

    Classes getClassById(@Param("id") Integer id);
}
