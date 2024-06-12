package com.zh.service.impl;

import com.zh.mapper.BookInfoMapper;
import com.zh.model.BookInfo;
import com.zh.service.BookInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BookInfoServiceImpl implements BookInfoService {

    @Resource
    private BookInfoMapper bookInfoMapper;

    /**
     * 获取图书数量
     *
     * @return
     */
    @Override
    public Integer getCount() {
        return bookInfoMapper.selectCount();
    }

    /**
     * 查询所有图书信息
     *
     * @return
     */
    @Override
    public List<BookInfo> queryBookInfos() {
        return bookInfoMapper.selectAll();
    }

    /**
     * 根据id查询图书信息
     *
     * @param bookid
     * @return
     */
    @Override
    public BookInfo queryBookInfoById(Integer bookid) {
        return bookInfoMapper.selectByPrimaryKey(bookid);
    }

    /**
     * 统计搜索总数
     *
     * @param params
     * @return
     */
    @Override
    public Integer getSearchCount(Map<String, Object> params) {
        return bookInfoMapper.selectCountBySearch(params);
    }

    /**
     * 分页搜索查询图书信息
     *
     * @param params
     * @return
     */
    @Override
    public List<BookInfo> searchBookInfosByPage(Map<String, Object> params) {
        return bookInfoMapper.selectBySearch(params);
    }

    /**
     * 添加图书信息
     *
     * @param bookInfo
     * @return
     */
    @Override
    public Integer addBookInfo(BookInfo bookInfo) {
        return bookInfoMapper.insertSelective(bookInfo);
    }

    /**
     * 删除图书信息
     *
     * @param bookInfo
     * @return
     */
    @Override
    public Integer deleteBookInfo(BookInfo bookInfo) {
        int count = 0;
        try {
            count = bookInfoMapper.deleteByPrimaryKey(bookInfo.getBookid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 删除一些图书信息
     *
     * @param bookInfos
     * @return
     */
    @Override
    public Integer deleteBookInfos(List<BookInfo> bookInfos) {
        int count = 0;
        for (BookInfo bookInfo : bookInfos) {
            count += deleteBookInfo(bookInfo);
        }
        return count;
    }

    /**
     * 更新一些图书信息
     *
     * @param bookInfo
     * @return
     */
    @Override
    public Integer updateBookInfo(BookInfo bookInfo) {
        return bookInfoMapper.updateByPrimaryKeySelective(bookInfo);
    }

}
