package com.cqupt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.UserDTO;
import com.cqupt.mapper.MenuMapper;
import com.cqupt.mapper.RoleMenuMapper;
import com.cqupt.mapper.UserMapper;
import com.cqupt.pojo.Menu;
import com.cqupt.pojo.User;
import com.cqupt.service.UserService;
import com.cqupt.utils.ResultVo;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMenuMapper roleMenuMapper;
    @Autowired
    MenuMapper menuMapper;

    @Override
    public ResultVo<User> login(String userName, String password) throws Exception {
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("user_name", userName);
        qw.eq("password", password);
        User user=getOne(qw);
        System.out.println(user);
        if(user!=null){
            if(user.getIsDeleted()==0){
                //根据用户角色获取当前用户的菜单
                //1.获取得到角色对应的menu_id
                QueryWrapper listRoleQw = new QueryWrapper<>();
                listRoleQw.eq("role_id",user.getRoleId());
                listRoleQw.select("menu");
                List<Integer>menuIds=roleMenuMapper.selectObjs(listRoleQw);
                //根据menu_id查询一级菜单列表
                List<Menu>menuList=menuMapper.selectBatchIds(menuIds);
                //3.查询子菜单
                for(Menu menu:menuList){
                    QueryWrapper listMenuQw = new QueryWrapper<>();
                    listMenuQw.eq("parent_id",menu.getId());
                    menu.setChildren(menuMapper.selectList(listMenuQw));
                }
                user.setMenuList(menuList);
                HashMap<String,Object>map=new HashMap<>();
                //如果登录验证成功，则需要生成令牌token token就是按照特定规则生成的字符串
                JwtBuilder builder= Jwts.builder();
                String token=builder.setSubject(userName) //主题，就是token中携带的数据
                        .setIssuedAt(new Date())  //设置token的生成时间
                        .setId(user.getId().toString())  //设置用户id为token id
                        .setClaims(map)  //map中可以存放用户的角色权限信息
                        .setExpiration(new Date(System.currentTimeMillis()+24*60*60*1000)) //设置过期时间
                        .signWith(SignatureAlgorithm.HS256,"cqupt123456") //设置加密方式和加密密码
                        .compact();
                return ResultVo.success(user,token);
            }
            return ResultVo.fail("无权限,请联系管理员");
        }
        return ResultVo.fail("账号密码错误");
    }

    @Override
    public ResultVo<Page<User>> findUserPage(UserDTO userDTO) throws Exception {
        Page<User>myPage=new Page<>(userDTO.getPageSize(),6);
        QueryWrapper qw=new QueryWrapper();
        if(userDTO.getRoleId()!=null&&userDTO.getNickName()!=""){
            qw.like("nick_name","%"+userDTO.getNickName()+"%");
        }
        qw.eq("is_deleted",0);
        qw.eq("role_id",userDTO.getRoleId());
        page(myPage,qw);
        return ResultVo.success(myPage);
    }

    @Override
    public ResultVo<Page<User>> findAllUserPage(UserDTO userDTO) throws Exception {
        Page<User>myPage=new Page<>(userDTO.getPageSize(),6);
        QueryWrapper qw=new QueryWrapper();
        page(myPage,qw);
        return ResultVo.success(myPage);
    }

    @Override
    public ResultVo addUser(User user) throws Exception {
        user.setIsDeleted(0);
        userMapper.insert(user);
        return ResultVo.success("插入成功");
    }

    @Override
    public ResultVo updateUser(User user) throws Exception {
        UpdateWrapper uw=new UpdateWrapper();
        userMapper.update(user,uw);
        return ResultVo.success("修改成功");
    }
}
