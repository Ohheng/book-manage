package com.zh.service.impl;

import com.zh.mapper.BookTypeMapper;
import com.zh.model.BookType;
import com.zh.service.BookTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BookTypeServiceImpl implements BookTypeService {

    @Resource
    private BookTypeMapper bookTypeMapper;

    /**
     * 获得数量
     *
     * @return
     */
    @Override
    public Integer getCount() {
        return bookTypeMapper.selectCount();
    }

    /**
     * 获得搜索数量
     *
     * @return
     */
    @Override
    public Integer getSearchCount(Map<String, Object> params) {
        return bookTypeMapper.selectCountBySearch(params);
    }

    /**
     * 分页查询图书类型
     *
     * @param params
     * @return
     */
    @Override
    public List<BookType> searchBookTypesByPage(Map<String, Object> params) {
        return bookTypeMapper.selectBySearch(params);
    }

    /**
     * 添加类型
     *
     * @param bookType
     * @return
     */
    @Override
    public Integer addBookType(BookType bookType) {
        return bookTypeMapper.insertSelective(bookType);
    }

    /**
     * 删除类型
     *
     * @param bookType
     * @return
     */
    @Override
    public Integer deleteBookType(BookType bookType) {
        int count = 0;
        try {
            count = bookTypeMapper.deleteByPrimaryKey(bookType.getBooktypeid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 删除一些类型
     *
     * @param bookTypes
     * @return
     */
    @Override
    public Integer deleteBookTypes(List<BookType> bookTypes) {
        int count = 0;
        for (BookType bookType : bookTypes) {
            count += deleteBookType(bookType);
        }
        return count;
    }

    /**
     * 更新类型
     *
     * @param bookType
     * @return
     */
    @Override
    public Integer updateBookType(BookType bookType) {
        return bookTypeMapper.updateByPrimaryKeySelective(bookType);
    }

    /**
     * 查询类型
     *
     * @return
     */
    @Override
    public List<BookType> queryBookTypes() {
        return bookTypeMapper.selectAll();
    }
}
