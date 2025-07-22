package com.cqupt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cqupt.dto.UserDTO;
import com.cqupt.pojo.User;
import com.cqupt.service.UserService;
import com.cqupt.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags="用户管理")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/findUserPage")
    @ApiOperation("系统用户信息动态分页查询")
    public ResultVo<Page<User>>findUserPage(UserDTO userDTO)throws Exception {
        return userService.findUserPage(userDTO);
    }

    @GetMapping("/findAllUserPage")
    @ApiOperation("全部用户信息动态分页查询")
    public ResultVo<Page<User>>findAllUserPage(UserDTO userDTO)throws Exception {
        return userService.findAllUserPage(userDTO);
    }

    @PostMapping("/addUser")
    @ApiOperation("添加用户信息")
    public ResultVo<User>addUser( User user)throws Exception {
        return userService.addUser(user);
    }

    @PostMapping("updateUser")
    @ApiOperation("更新用户信息")
    public ResultVo updateUser( User user)throws Exception {
        return userService.updateUser(user);
    }

    @GetMapping("/login")
    @ApiOperation("用户登录接口")
    public ResultVo<User> login(String username, String password) throws Exception {
        return userService.login(username, password);
    }

    @PostMapping("/deleteUser")
    @ApiOperation("删除用户")
    public ResultVo deleteUser( User user)throws Exception {
        userService.removeById(user);
        return ResultVo.success("删除成功");
    }
}
