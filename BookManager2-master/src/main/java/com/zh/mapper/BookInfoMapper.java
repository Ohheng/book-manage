package com.zh.mapper;

import com.zh.model.BookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookInfoMapper {

    /**
     * 获取图书数量
     * @return
     */
    Integer selectCount();

    /**
     * 查询所有图书信息
     * @return
     */
    List<BookInfo> selectAll();

    /**
     * 根据id查询图书
     * @param bookid
     * @return
     */
    BookInfo selectByPrimaryKey(Integer bookid);

    /**
     * 统计搜索总数
     * @param searchParam
     * @return
     */
    int selectCountBySearch(Map<String, Object> searchParam);

    /**
     *搜索查询图书信息
     * @param searchParam
     * @return
     */
    List<BookInfo> selectBySearch(Map<String, Object> searchParam);

    /**
     * 根据id删除图书
     * @param bookid
     * @return
     */
    int deleteByPrimaryKey(Integer bookid);

    /**
     * 添加图书
     * @param record
     * @return
     */
    int insert(BookInfo record);

    /**
     * 添加图书-动态
     * @param record
     * @return
     */
    int insertSelective(BookInfo record);

    /**
     * 更新图书信息-动态
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BookInfo record);

    /**
     * 更新图书信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(BookInfo record);

    /**
     * 分页查询图书
     * @param begin
     * @param size
     * @return
     */
    List<BookInfo> selectAllByLimit(@Param("begin") Integer begin, @Param("size") Integer size);

    /**
     * 根据种类统计图书数量
     * @param map
     * @return
     */
    int selectCountByType(Map<String, Object> map);

    /**
     * 根据种类查询图书信息
     * @param map
     * @return
     */
    List<BookInfo> selectByType(Map<String, Object> map);
}
