package com.car.common.utils;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

public class ToolUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成几位验证码？
     *
     * @param count
     * @return
     */
    public static String getRandomNumCode(int count) {
        String codeNum = "";
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int next = random.nextInt(10000);//目的是产生足够随机的数，避免产生的数字重复率高的问题
            codeNum += numbers[next % 10];
        }
        return codeNum;
    }

    /**
     * 生成guid的标识
     *
     * @return
     */
    public static String getGuid() {
        UUID uuid = java.util.UUID.randomUUID();
        String guid = uuid.toString();
        guid = guid.replaceAll("-", "");
        return guid;
    }

    //
    public static String getFilename(String filename) {
        String suffix = filename.substring(filename.lastIndexOf("."));
        return getGuid() + suffix;
    }

    public static void main(String[] args) {
        System.out.println(secondToTime(600000));
    }

    public static void ChangeValue(Integer a, Integer b) {
        if (a > b) {
            Integer t = a;
            a = b;
            b = t;
        }
    }

    public static void ChangeValue(Float a, Float b) {
        if (a > b) {
            Float t = a;
            a = b;
            b = t;
        }
    }


    public static float rounding(float num) {
        BigDecimal b = new BigDecimal(num);
        float re_num = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        return re_num;
    }

    public static float rounding(double num) {
        BigDecimal b = new BigDecimal(num);
        float re_num = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        return re_num;
    }


    public static String formateByteSpeed(long srcSpeed) {
        int targetSpeed = 0;
        if (srcSpeed / 1024 >= 1024) {

            targetSpeed = Math.round((srcSpeed / 1024 / 1024) * 100) / 100;
            return String.format("%s Mb/S", targetSpeed);
        } else {
            targetSpeed = Math.round((srcSpeed / 1024) * 100) / 100;
            return String.format("%s Kb/S", targetSpeed);
        }
    }


    /**
     * 将秒数转换为日时分秒，
     *
     * @param second
     * @return
     */
    public static String secondToTime(long second) {
        long days = second / 86400;            //转换天数
        second = second % 86400;            //剩余秒数
        long hours = second / 3600;            //转换小时
        second = second % 3600;                //剩余秒数
        long minutes = second / 60;            //转换分钟
        second = second % 60;                //剩余秒数
        String time = "";
        //return days + "天" + hours + "小时" + minutes + "分" + second + "秒";
        if (days > 0) {
            time += days + "天";
        }
        if (hours > 0) {
            time += hours + "小时";
        }
        if (minutes > 0) {
            time += minutes + "分";
        }
        if (second > 0) {
            time += second + "秒";
        }
        return time;
    }
}
