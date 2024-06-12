package com.zh.model;

public class BookType {

    private Integer booktypeid;
    //图书类型
    private String booktypename;
    //相关
    private String booktypedesc;

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

    public String getBooktypedesc() {
        return booktypedesc;
    }

    public void setBooktypedesc(String booktypedesc) {
        this.booktypedesc = booktypedesc;
    }
}