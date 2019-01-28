package com.example.controller;

import com.example.entity.User;
import com.example.service.IUserService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description: TODO
 * @author: li_jiazhi
 * @create: 2019-01-17 11:18
 **/
@Controller
public class TestController {
    @Autowired
    private IUserService userService;
    @RequestMapping(value={"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(User user){
        Integer count = userService.save(user);
        System.out.println(count);
        return count.toString();
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String ,String> map){
        System.out.println("user login .....");
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "unknownAccount";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "incorrectPassword";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        //认证成功由shiro框架自行处理
        return "login";
    }


    //访问此连接时会触发MyShiroRealm中的权限分配方法
    @RequestMapping("/permission")
    @RequiresPermissions("student:test")
    public void test(){
        System.out.println("permission  test");
    }
}
