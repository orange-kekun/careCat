package com.example.carecat.service.impl;

import com.example.carecat.entity.User;
import com.example.carecat.mapper.UserMapper;
import com.example.carecat.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 200111124
 * @since 2022-12-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
