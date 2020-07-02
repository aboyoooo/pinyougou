package com.hlkj.securitycenter.service;

import com.hlkj.pojo.model.Permission;
import com.hlkj.pojo.model.User;
import com.hlkj.securitycenter.mapper.UserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userMapper.findByUsername(username);
        if(!Objects.isNull(user)){
            List<Permission> permissionList=userMapper.findPermissionByUsername(username);
            if(permissionList!=null&&permissionList.size()>0){
                List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
                permissionList.stream().forEach(e->{
                    authorities.add(new SimpleGrantedAuthority(e.getPermTag()));
                });
                user.setAuthorities(authorities);
            }
        }
        return user;
    }
}
