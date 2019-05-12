package com.car;

import com.car.modules.sys.shiro.ShiroUtils;

public class test {
    public static void main(String[] args) {
        System.out.println(ShiroUtils.sha256("admin123", "YzcmCZNvbXocrsz9dm8e"));
    }
}
