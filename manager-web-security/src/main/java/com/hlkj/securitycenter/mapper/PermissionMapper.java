package com.hlkj.securitycenter.mapper;

import com.hlkj.pojo.model.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper {
    // 查询苏所有权限
    @Select(" select * from sys_permission ")
    List<Permission> findAllPermission();
}

