package com.xbfinal.std_satoken.test;

import cn.hutool.core.bean.BeanUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: JWTtest
 * @Author 笑霸fianl
 * @Package com.xbfinal.std_satoken.test
 * @Date 2023/4/13 9:06
 * @描述:
 */


public class Utilstest {


    @Test
    public void JwtTest(){



        Map<String, Object> hashMap = new HashMap<>();
        //自己的数据
        hashMap.put("name","笑霸final");
        hashMap.put("age","18");


        String JWTString = Jwts.builder()//生成jwt令牌
                .signWith(SignatureAlgorithm.HS256, "xbfinal")// 签名算法和密钥
                .setClaims(hashMap)//存储自定义的数据(载荷)
                //System.currentTimeMillis()获取当前时间毫秒值 一下表示当前时间后的一个小时
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//有效期  1小时
                .compact();
        System.out.println(JWTString);


    }

    @Test
    public void JwtTest1(){

        Claims keyBody = Jwts.parser()
                .setSigningKey("xbfinal")//签名密钥
                //传入生成的 jwt令牌
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi56yR6Zy4ZmluYWwiLCJleHAiOjE2ODEzNTQxMTcsImFnZSI6IjE4In0.77CDL0t1yFGDeXvM9pH5TKT1Pt5Xq6rUdycl4yPCC6Q")
                .getBody();//拿到我们自定义的内容

        Map<String, Object> stringObjectMap = BeanUtil.beanToMap(keyBody);
        System.out.println(stringObjectMap.get("name"));
        System.out.println(keyBody);

    }


}
