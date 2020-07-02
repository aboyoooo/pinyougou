package com.hlkj.filesoperator.mapper;

import com.hlkj.pojo.model.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {

    @Insert("insert into file(name, groupname, path) values(#{name}, #{groupname}, #{path})")
    public int add(File file);
}
