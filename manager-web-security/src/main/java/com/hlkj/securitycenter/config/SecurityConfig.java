package com.hlkj.securitycenter.config;

import com.hlkj.pojo.model.Permission;
import com.hlkj.securitycenter.handler.MyAuthenticationFailureHandler;
import com.hlkj.securitycenter.handler.MyAuthenticationSuccessHandler;
import com.hlkj.securitycenter.mapper.PermissionMapper;
import com.hlkj.securitycenter.service.MyUserDetailService;
import com.hlkj.securitycenter.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService userDetailService;
    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;
    @Resource
    private PermissionMapper permissionMapper;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //对表单密码进行加密
        auth.userDetailsService(userDetailService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String)rawPassword);
            }
            //加密的密码与数据库密码进行比对
            //rawPassword 表单密码     encodedPassword数据库密码
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return MD5Util.encode((String)rawPassword).equals(encodedPassword);
            }
        });
    }
    //配置httpSecurity拦截资源
    protected void configure(HttpSecurity http) throws Exception{
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizaRequests=http.authorizeRequests();
        List<Permission> permissionList=permissionMapper.findAllPermission();
        if(permissionList!=null&&permissionList.size()>0){
            permissionList.stream().forEach(permission -> {
                authorizaRequests.antMatchers(permission.getUrl()).hasAnyAuthority(permission.getPermTag());
            });
        }
        authorizaRequests.antMatchers("/login").permitAll()
                .antMatchers("/js/**","/css/**","/img/**","/plugins/**").permitAll()
                .antMatchers("/**").fullyAuthenticated().and().formLogin()
                .loginPage("/login").successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and().csrf().disable();
    }













}
