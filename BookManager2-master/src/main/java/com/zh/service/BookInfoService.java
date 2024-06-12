package com.zh.service;

import com.zh.model.BookInfo;

import java.util.List;
import java.util.Map;

public interface BookInfoService {

    /**
     * 获取图书数量
     *
     * @return
     */
    Integer getCount();

    /**
     * 查询所有图书信息
     *
     * @return
     */
    List<BookInfo> queryBookInfos();

    /**
     * 根据id查询图书信息
     * @param bookid
     * @return
     */
    BookInfo queryBookInfoById(Integer bookid);

    /**
     * 统计搜索总数
     * @param params
     * @return
     */
    Integer getSearchCount(Map<String, Object> params);

    /**
     * 分页搜索查询图书信息
     *
     * @param params
     * @return
     */
    List<BookInfo> searchBookInfosByPage(Map<String, Object> params);

    /**
     * 添加图书信息
     *
     * @param bookInfo
     * @return
     */
    Integer addBookInfo(BookInfo bookInfo);

    /**
     * 删除图书信息
     *
     * @param bookInfo
     * @return
     */
    Integer deleteBookInfo(BookInfo bookInfo);

    /**
     * 删除一些图书信息
     *
     * @param bookInfos
     * @return
     */
    Integer deleteBookInfos(List<BookInfo> bookInfos);

    /**
     * 更新一些图书信息
     *
     * @param bookInfo
     * @return
     */
    Integer updateBookInfo(BookInfo bookInfo);
}
