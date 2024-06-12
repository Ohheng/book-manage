package com.zh.mapper;

import com.zh.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 通过主键删除用户
     *
     * @param userid
     * @return
     */
    int deleteByPrimaryKey(Integer userid);

    /**
     * 新增用户 - 静态
     *
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 新增用户 - 动态
     *
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 通过主键选择
     *
     * @param userid
     * @return
     */
    User selectByPrimaryKey(Integer userid);

    /**
     * 按主键更新 - 动态
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 按主键更新 - 静态
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据用户名、密码及身份进行查询
     *
     * @param username
     * @param password
     * @param isAdmin
     * @return
     */
    User selectByUsernameAndPasswordAndIsAdmin(@Param("username") String username,
                                               @Param("password") String password,
                                               @Param("isAdmin") Byte isAdmin);

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     * 按分页条件进行查询用户信息
     *
     * @param begin
     * @param size
     * @return
     */
    List<User> selectAllByLimit(@Param("begin") Integer begin, @Param("size") Integer size);

    /**
     * 查询用户总数
     *
     * @return
     */
    Integer selectCount();

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> selectAll();

    /**
     * 根据用户名查询用户个数
     *
     * @param params
     * @return
     */
    int selectCountBySearch(Map<String, Object> params);

    /**
     * 根据用户名查询用户信息
     *
     * @param params
     * @return
     */
    List<User> selectBySearch(Map<String, Object> params);
}
