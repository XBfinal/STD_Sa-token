package com.xbfinal.std_satoken.utils;

import cn.hutool.core.bean.BeanUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: MyJwtUtils
 * @Author 笑霸fianl
 * @Package com.xbfinal.std_satoken.utils
 * @Date 2023/4/13 12:52
 * @描述:
 */
public class MyJwtUtils {

    private static final String SigningKey="xbfinal";//签名

    public static String builder(Map<String, Object> hashMap){


        return Jwts.builder()//生成jwt令牌
                .signWith(SignatureAlgorithm.HS256, SigningKey)// 签名算法和密钥
                .setClaims(hashMap)//存储自定义的数据(载荷)
                //System.currentTimeMillis()获取当前时间毫秒值 一下表示当前时间后的一个小时
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//有效期  1小时
                .compact();
    }


    public static Claims parser(String JWTString){

        return Jwts.parser()
                .setSigningKey(SigningKey)//签名密钥
                //传入生成的 jwt令牌
                .parseClaimsJws(JWTString)
                .getBody();

    }

}
