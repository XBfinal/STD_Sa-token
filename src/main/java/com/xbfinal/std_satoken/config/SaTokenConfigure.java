package com.xbfinal.std_satoken.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Title: SaTokenConfigure
 * @Author 笑霸fianl
 * @Package com.xbfinal.std_satoken.config
 * @Date 2023/4/8 16:53
 * @描述:
 */

@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle -> StpUtil.checkLogin()))
                .addPathPatterns("/**")//拦截路径
                .excludePathPatterns("/user/doLogin/**","/user/isLogin")//开放路径

        ;

    }

}
