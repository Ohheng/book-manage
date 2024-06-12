package com.zh.service;

import com.zh.model.BookType;

import java.util.List;
import java.util.Map;

public interface BookTypeService {

    /**
     * 获得数量
     *
     * @return
     */
    Integer getCount();

    /**
     * 获得搜索数量
     *
     * @return
     */
    Integer getSearchCount(Map<String, Object> params);

    /**
     * 分页查询图书类型
     *
     * @param params
     * @return
     */
    List<BookType> searchBookTypesByPage(Map<String, Object> params);

    /**
     * 添加类型
     *
     * @param bookType
     * @return
     */
    Integer addBookType(BookType bookType);

    /**
     * 删除类型
     *
     * @param bookType
     * @return
     */
    Integer deleteBookType(BookType bookType);

    /**
     * 删除一些类型
     *
     * @param bookTypes
     * @return
     */
    Integer deleteBookTypes(List<BookType> bookTypes);

    /**
     * 更新类型
     *
     * @param bookType
     * @return
     */
    Integer updateBookType(BookType bookType);

    /**
     * 查询类型
     *
     * @return
     */
    List<BookType> queryBookTypes();

}
