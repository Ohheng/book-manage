package com.zh.service;

import com.zh.model.Borrow;

import java.util.List;
import java.util.Map;

public interface BorrowService {
    /**
     * 统计数量
     * @return
     */
    Integer getCount();

    /**
     * 获取查询总数
     * @param params
     * @return
     */
    Integer getSearchCount(Map<String, Object> params);

    /**
     * 分页查询借阅
     * @param params
     * @return
     */
    List<Borrow> searchBorrowsByPage(Map<String, Object> params);
    /**
     * 添加借阅
     * @param borrow
     * @return
     */
    Integer addBorrow(Borrow borrow);

    Integer addBorrow2(Borrow borrow);

    /**
     * 删除借阅
     * @param borrow
     * @return
     */
    Integer deleteBorrow(Borrow borrow);
    /**
     * 删除一些借阅
     * @param borrows
     * @return
     */
    Integer deleteBorrows(List<Borrow> borrows);

    /**
     * 更新借阅
     * @param borrow
     * @return
     */
    Integer updateBorrow(Borrow borrow);

    Integer updateBorrow2(Borrow borrow);

    /**
     * 通过id查询
     * @param borrowid
     * @return
     */
    Borrow queryBorrowsById(Integer borrowid);
}
