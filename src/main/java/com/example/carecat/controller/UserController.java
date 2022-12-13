package com.example.carecat.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.carecat.common.BaseContext;
import com.example.carecat.common.R;
import com.example.carecat.entity.User;
import com.example.carecat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 200111124
 * @since 2022-12-09
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    public R<User> login(HttpServletRequest request, @RequestBody User user){
        log.info("user{}",user);
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //数据库匹配用户名
        queryWrapper.eq(User::getUsername,user.getUsername());
        User tmp = userService.getOne(queryWrapper);
        if(tmp == null){
            return  R.error("用户不存在，请注册");
        }
        //密码比对
        if(!tmp.getPassword().equals(password)){
            return R.error("密码错误");
        }
        //登录成功，session保存id
        request.getSession().setAttribute("user",tmp.getId());
        return R.success(user);
    }

    /**
     * 退出
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public R<String>  logOut(HttpServletRequest request) {
        //清理session中信息
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }

    @PostMapping("/register")
    public R<User> register(HttpServletRequest request, @RequestBody User user){
        //先查看用户名是否重复
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        log.info(user.getUsername());
        queryWrapper.eq(User::getUsername,user.getUsername());
        User tmp = userService.getOne(queryWrapper);
        log.info("tmp{}",tmp);
        if(tmp!=null){
            return  R.error("已经存在该用户");
        }else{
            //密码加密处理
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            userService.save(user);
            request.getSession().setAttribute("user",user.getId());
        }
        return R.success(user);
    }


}

