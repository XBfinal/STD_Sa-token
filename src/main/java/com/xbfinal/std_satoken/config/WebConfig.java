package com.xbfinal.std_satoken.config;

import com.xbfinal.std_satoken.Interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Title: WebConfig
 * @Author 笑霸fianl
 * @Package com.xbfinal.std_satoken.config
 * @Date 2023/4/13 14:02
 * @描述:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    LoginCheckInterceptor loginCheckInterceptor;

    /**
     * 注册拦截器的方法
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginCheckInterceptor)
//                .addPathPatterns("/**")//拦截所以资源
//                .excludePathPatterns("/user/doLogin/**")//排除路径
//                .excludePathPatterns("/user/isLogin")
////                .order(1) 有多个拦截器的话设置优先级 数字越小优先级越高
//        ;
//
//    }
}
