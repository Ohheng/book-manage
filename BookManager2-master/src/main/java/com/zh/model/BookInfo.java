package com.zh.model;

import java.math.BigDecimal;

public class BookInfo {

    private Integer bookid;
    //书名
    private String bookname;
    //作者
    private String bookauthor;
    //价格
    private BigDecimal bookprice;
    //类型id
    private Integer booktypeid;
    //类型名称
    private String booktypename;
    //简介
    private String bookdesc;
    //借书情况
    private Byte isborrowed;
    //图书照片
    private String bookimg;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public BigDecimal getBookprice() {
        return bookprice;
    }

    public void setBookprice(BigDecimal bookprice) {
        this.bookprice = bookprice;
    }

    public Integer getBooktypeid() {
        return booktypeid;
    }

    public void setBooktypeid(Integer booktypeid) {
        this.booktypeid = booktypeid;
    }

    public String getBooktypename() {
        return booktypename;
    }

    public void setBooktypename(String booktypename) {
        this.booktypename = booktypename;
    }

    public String getBookdesc() {
        return bookdesc;
    }

    public void setBookdesc(String bookdesc) {
        this.bookdesc = bookdesc;
    }

    public Byte getIsborrowed() {
        return isborrowed;
    }

    public void setIsborrowed(Byte isborrowed) {
        this.isborrowed = isborrowed;
    }

    public String getBookimg() {
        return bookimg;
    }

    public void setBookimg(String bookimg) {
        this.bookimg = bookimg;
    }
}
