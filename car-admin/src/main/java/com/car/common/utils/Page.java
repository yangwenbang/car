package com.car.common.utils;

public class Page {
    private int page = 1; // current page

    private int size; // amount of page

    private int num = 10; // numbers of one page

    private int max; // sum of numbers

    public Page() {
    }

    public Page(int page, int num) {
        this.page = page;
        this.num = num;
    }

    public String getSQL(String sql) {
        StringBuilder sb = new StringBuilder(sql);
        String pageSql;
        sb.deleteCharAt(sql.length() - 1);
        if (1 == page) {
            pageSql = " limit " + num + ";";
        } else {
            pageSql = " limit " + (page - 1) * num + "," + num + ";";
        }
        sb.append(pageSql);
        sql = sb.toString();
        return sql;
    }

    // set and get
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        size = 1;
        int sum = max;
        while (sum - num > 0) {
            sum = sum - num;
            size++;
        }
        return size;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
