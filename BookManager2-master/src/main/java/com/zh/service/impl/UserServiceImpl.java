package com.zh.service.impl;

import com.zh.mapper.UserMapper;
import com.zh.model.User;
import com.zh.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userMapper.selectByUsernameAndPasswordAndIsAdmin(user.getUsername(), user.getUserpassword(), user.getIsadmin());
    }

    /**
     * 保存用户 - redis
     *
     * @param token
     * @param user
     */
    @Override
    public void saveUser(String token, User user) {
        // 设置redisTemplate对象key的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // key是token，value是用户保存到redis中，超时时间1小时
        redisTemplate.opsForValue().set(token, user, 1, TimeUnit.HOURS);
    }

    /**
     * 获取用户信息 - redis
     *
     * @param token
     * @return
     */
    @Override
    public User getUser(String token) {
        // 根据token得到user
        return (User) redisTemplate.opsForValue().get(token);
    }

    /**
     * 退出登录 - redis
     *
     * @param token
     */
    @Override
    public void removeUser(String token) {
        // 移除token
        redisTemplate.delete(token);
    }

    /**
     * 注册用户
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public Integer register(String username, String password) {
        User tmp = userMapper.selectByUsername(username);
        if (tmp != null) return 0;  //账号重复

        User user = new User();
        user.setUsername(username);
        user.setUserpassword(password);
        user.setIsadmin((byte) 0);
        return userMapper.insertSelective(user);
    }

    /**
     * 设置密码
     *
     * @param id
     * @param password
     */
    @Override
    public void setPassword(Integer id, String password) {
        User user = new User();
        user.setUserid(id);
        user.setUserpassword(password);
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 获取数量
     *
     * @return
     */
    @Override
    public Integer getCount() {
        return userMapper.selectCount();
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> queryUsers() {
        return userMapper.selectAll();
    }

    /**
     * 分页查询页数
     *
     * @return
     */
    @Override
    public int getSearchCount(Map<String, Object> params) {
        return userMapper.selectCountBySearch(params);
    }

    /**
     * 分页查询用户
     *
     * @param params
     * @return
     */
    @Override
    public List<User> searchUsersByPage(Map<String, Object> params) {
        return userMapper.selectBySearch(params);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public Integer addUser(User user) {
        return userMapper.insertSelective(user);
    }

    /**
     * 删除用户
     *
     * @param user
     * @return
     */
    @Override
    public Integer deleteUser(User user) {
        if (user.getUserid() == 1) return 0;
        return userMapper.deleteByPrimaryKey(user.getUserid());
    }

    /**
     * 删除所有用户
     *
     * @param users
     * @return
     */
    @Override
    public Integer deleteUsers(List<User> users) {
        int count = 0;
        for (User user : users) {
            count += deleteUser(user);
        }
        return count;
    }

    /**
     * 更改用户信息
     *
     * @param user
     * @return
     */
    @Override
    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

}
