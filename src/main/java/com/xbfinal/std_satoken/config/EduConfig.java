package com.xbfinal.std_satoken.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: EduConfig
 * @Author 笑霸fianl
 * @Package com.xbfinal.std_satoken.config
 * @Date 2023/4/8 22:31
 * @描述:
 */

@Configuration
@MapperScan(basePackages = {"com.xbfinal.std_satoken.mapper"})
public class EduConfig {
    /**
     * 逻辑删除插件
     */
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
}
