package com.xy.test.test.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();
        // 放行所有Option请求
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
        // 放行看板注册接口
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/boards/register").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/boards/show-layout").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/boards/IP").permitAll();
        // 放行swagger2文档页面
        http.authorizeRequests().antMatchers("/swagger-ui.html", "/webjars/**", "/swagger-resources/**", "/v2/api-docs").permitAll();
        // 放行websocket接口
        http.authorizeRequests().antMatchers("/board-web-socket/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
    }
}
