package com.lcl.domain;

import java.util.ArrayList;
import java.util.List;

public class PageData<T> {

    //封装每页的数据
    private List<T> pageData = new ArrayList<>();

    //总条数
    private int total;

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
