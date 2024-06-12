package com.zh.service;

import com.zh.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 保存用户 - redis
     * @param token
     * @param user
     */
    void saveUser(String token, User user);

    /**
     * 获取用户信息 - redis
     * @param token
     * @return
     */
    User getUser(String token);

    /**
     * 退出登录 - redis
     * @param token
     */
    void removeUser(String token);

    /**
     * 注册用户
     * @param username
     * @param password
     * @return
     */
    Integer register(String username, String password);

    /**
     * 设置密码
     * @param id
     * @param password
     */
    void setPassword(Integer id, String password);

    /**
     * 获取数量
     * @return
     */
    Integer getCount();

    /**
     * 查询所有用户
     * @return
     */
    List<User> queryUsers();

    /**
     * 分页查询页数
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

    /**
     * 分页查询用户
     * @param params
     * @return
     */
    List<User> searchUsersByPage(Map<String, Object> params);

    /**
     * 添加用户
     * @param user
     * @return
     */
    Integer addUser(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    Integer deleteUser(User user);

    /**
     * 删除所有用户
     * @param users
     * @return
     */
    Integer deleteUsers(List<User> users);

    /**
     * 更改用户信息
     * @param user
     * @return
     */
    Integer updateUser(User user);
}
