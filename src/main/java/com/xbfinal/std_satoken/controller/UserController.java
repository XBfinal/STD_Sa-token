package com.xbfinal.std_satoken.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.bean.BeanUtil;
import com.xbfinal.std_satoken.entity.User;
import com.xbfinal.std_satoken.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Title: UserController
 * @Author 笑霸fianl
 * @Package com.xbfinal.std_satoken.controller
 * @Date 2023/4/8 16:32
 * @描述:
 */


@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Autowired
    UserService userService;

    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin/zhang/123456
//    @RequestMapping("doLogin")
//    public String doLogin(String username, String password) {
//        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
//        if("zhang".equals(username) && "123456".equals(password)) {
//            StpUtil.login(10001);
//            return "登录成功";
//        }
//        return "登录失败";
//    }
    @GetMapping("doLogin/{username}/{password}")
    public SaResult doLogin(
            @PathVariable("username") String username,
            @PathVariable("password") String password) {

        System.out.println(username);
        System.out.println(password);
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        User user = userService.getByName(username);
        if(BeanUtil.isEmpty(user)){
            return SaResult.error().setCode(2001);//失败

        }
        String SecurePassword = SaSecureUtil.md5(password);//Md5加密
        System.out.println(SecurePassword);

        if(user.getName().equals(username) && user.getPassword().equals(SecurePassword)) {

            StpUtil.login(user.getName());

            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();

            stringRedisTemplate.opsForValue().set("user"+"zhang",username,3, TimeUnit.MINUTES);

            return SaResult.data(tokenInfo);
        }
        return SaResult.error().setCode(2001);//失败
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @GetMapping("isLogin")
    public String isLogin() {
        stringRedisTemplate.expire("user"+"zhang",3,TimeUnit.MINUTES);
        return "当前会话是否登录：" + StpUtil.isLogin();


    }
//http://localhost:8082/user/info
    @GetMapping("info")
    public String info() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

}
