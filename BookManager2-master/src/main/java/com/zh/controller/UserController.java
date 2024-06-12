package com.zh.controller;

import com.zh.model.User;
import com.zh.service.UserService;
import com.zh.utils.MyResult;
import com.zh.utils.MyUtils;
import com.zh.utils.TokenProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        // 登录
        User userObj = userService.login(user);
        if (userObj == null) {   // 账号或密码错误
            // 返回结果对象
            return MyResult.getResultMap(420, "账号或密码错误");
        } else {    // 账号密码正确
            // 创建token
            String token = TokenProcessor.getInstance().makeToken();
            // 保存到Redis
            userService.saveUser(token, userObj);
            // 返回结果对象
            return MyResult.getResultMap(200, "登录成功",
                    new HashMap<String, String>() {{
                        put("token", token);
                    }});
        }
    }

    /**
     * 查看用户信息
     *
     * @param token
     * @return
     */
    @RequestMapping("/info")
    public Map<String, Object> info(String token) {
        // 从redis中取用户
        User user = userService.getUser(token);
        if (user == null) {  // 获取失败
            return MyResult.getResultMap(420, "获取用户信息失败");
        } else {    // 获取成功
            return MyResult.getResultMap(200, "获取用户信息成功", user);
        }
    }

    /**
     * 退出登录
     *
     * @param token
     * @return
     */
    @RequestMapping("/logout")
    public Map<String, Object> logout(String token) {
        // 从redis中移除用户
        userService.removeUser(token);
        return MyResult.getResultMap(200, "退出登录成功");
    }

    /**
     * 注册
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/register")
    public Integer register(String username, String password) {
        return userService.register(username, password);
    }

    /**
     * 修改密码
     *
     * @param userid
     * @param username
     * @param isadmin
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping(value = {"/alterPassword", "reader/alterPassword"})
    public Integer alterPassword(Integer userid, String username, Byte isadmin, String oldPassword, String newPassword) {
        //检查旧密码是否正确
        User userObj = new User();
        userObj.setUserid(userid);
        userObj.setUsername(username);
        userObj.setUserpassword(oldPassword);
        userObj.setIsadmin(isadmin);

        User user = userService.login(userObj);
        if (user == null) {  //旧密码不正确
            return 0;
        } else {    //旧密码正确，设置新密码
            userService.setPassword(userObj.getUserid(), newPassword);
            return 1;
        }
    }

    /**
     * 获得数量
     *
     * @return
     */
    @GetMapping("/getCount")
    public Integer getCount() {
        return userService.getCount();
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping("/queryUsers")
    public List<User> queryUsers() {
        return userService.queryUsers();
    }

    /**
     * 分页查询用户
     * params: {page, limit, username}
     *
     * @param params
     * @return
     */
    @GetMapping("/queryUsersByPage")
    public Map<String, Object> queryUsersByPage(@RequestParam Map<String, Object> params) {
        MyUtils.parsePageParams(params);
        int count = userService.getSearchCount(params);
        List<User> users = userService.searchUsersByPage(params);
        return MyResult.getListResultMap(0, "success", count, users);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public Integer addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * 删除用户
     *
     * @param user
     * @return
     */
    @DeleteMapping("/deleteUser")
    public Integer deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }

    /**
     * 删除一些用户
     *
     * @param users
     * @return
     */
    @DeleteMapping("/deleteUsers")
    public Integer deleteUsers(@RequestBody List<User> users) {
        return userService.deleteUsers(users);
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    public Integer updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
