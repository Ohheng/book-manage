package com.zh.mapper;

import com.zh.model.BookType;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookTypeMapper {
    /**
     * 根据id删除图书类型
     *
     * @param booktypeid
     * @return
     */
    int deleteByPrimaryKey(Integer booktypeid);

    /**
     * 新增图书类型
     *
     * @param record
     * @return
     */
    int insert(BookType record);

    /**
     * 新增图书类型 - 动态
     *
     * @param record
     * @return
     */
    int insertSelective(BookType record);

    /**
     * 根据id查找
     *
     * @param booktypeid
     * @return
     */
    BookType selectByPrimaryKey(Integer booktypeid);

    /**
     * 更新图书类型 - 动态
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BookType record);

    /**
     * 更新图书类型
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(BookType record);

    /**
     * 分页查询
     *
     * @param begin
     * @param size
     * @return
     */
    List<BookType> selectAllByLimit(@Param("begin") Integer begin, @Param("size") Integer size);

    /**
     * 查询图书类型数量
     *
     * @return
     */
    Integer selectCount();

    /**
     * 查询图书类型
     *
     * @return
     */
    List<BookType> selectAll();

    /**
     * 通过类型名查询图书类型数量
     *
     * @param searchParam
     * @return
     */
    int selectCountBySearch(Map<String, Object> searchParam);

    /**
     * 通过类型名查询图书类型
     *
     * @param searchParam
     * @return
     */
    List<BookType> selectBySearch(Map<String, Object> searchParam);
}
