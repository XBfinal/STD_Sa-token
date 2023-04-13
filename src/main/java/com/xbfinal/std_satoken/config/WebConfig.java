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
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**")//拦截所以资源
                .excludePathPatterns("/user/doLogin/**")//排除路径
        ;

    }
}
