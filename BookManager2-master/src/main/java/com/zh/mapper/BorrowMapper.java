package com.zh.mapper;

import com.zh.model.Borrow;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BorrowMapper {
    /**
     * 通过id删除
     * @param borrowid
     * @return
     */
    int deleteByPrimaryKey(Integer borrowid);

    /**
     * 新增
     * @param record
     * @return
     */
    int insert(Borrow record);

    /**
     * 新增 - 动态
     * @param record
     * @return
     */
    int insertSelective(Borrow record);

    /**
     * 通过id查询
     * @param borrowid
     * @return
     */
    Borrow selectByPrimaryKey(Integer borrowid);

    /**
     * 更新 - 动态
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Borrow record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Borrow record);

    /**
     *
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    List<Borrow> selectAllByLimit(@Param("begin") Integer begin, @Param("size") Integer size);

    /**
     * 统计数量
     * @return
     */
    Integer selectCount();

    /**
     * 统计搜索结果数量
     * @param searchParam
     * @return
     */
    int selectCountBySearch(Map<String, Object> searchParam);

    /**
     * 搜索
     * @param searchParam
     * @return
     */
    List<Borrow> selectBySearch(Map<String, Object> searchParam);

    /**
     * 统计借阅读者数量
     * @param userid
     * @return
     */
    Integer selectCountByReader(Integer userid);

    /**
     * 读者分页查询
     * @param begin
     * @param size
     * @param userid
     * @return
     */
    List<Borrow> selectAllByLimitByReader(@Param("begin") Integer begin, @Param("size") Integer size, @Param("userid") Integer userid);
}