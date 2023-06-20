package com.xbfinal.std_satoken.Interceptor;

import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.xbfinal.std_satoken.utils.MyJwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: LoginCheckInterceptor
 * @Author 笑霸fianl
 * @Package com.xbfinal.std_satoken.iterceputer
 * @Date 2023/4/13 13:42
 * @描述:
 */
@Slf4j
@Component //拦截器配置好后别忘了注册
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取请求头中的token
        String jwt = request.getHeader("satoken");
        //验证令牌
        if(StrUtil.isEmpty(jwt)){
            //不存在
            log.info("token为空");
            log.info("令牌为空");
            String jsonStr = JSONUtil.toJsonStr(SaResult.error("没有登录").toString());
            response.getWriter().write(jsonStr);
            return false;
        }
        try{

            Claims parser = MyJwtUtils.parser(jwt);

        }catch (Exception e){
            log.info("token为空");

            String jsonStr = JSONUtil.toJsonStr(SaResult.error("没有登录").toString());
            response.getWriter().write(jsonStr);
            return false;
        }

        //放行
        log.info("登录放行");
        return true;
    }
}
