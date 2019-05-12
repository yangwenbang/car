package com.car.common.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.springframework.util.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class StringUtil {


    public static final String EMAIL_PATTERN = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

    public static final String MOBILE_PATTERN = "^[\\d]{11}$";

    public static final String MESSAGE_CODE_PATTERN = "^[\\d]{6}$";

    public static final String PASSWORD_PATTERN = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";

    public static String getTrace(Throwable t) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer = stringWriter.getBuffer();
        return buffer.toString();
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


    public static String parseString(Object o) {
        return parseString(o, "");
    }

    public static String parseString(Object o, String sDef) {
        return o == null ? sDef : o.toString();
    }

    // 当输入合法的数字字符时，返回true；否则返回false
    // 举例：
    // 输入："-1" 返回：true
    // 输入："+1" 返回：true
    // 输入："+0" 返回：true
    // 输入："-0", 返回：true
    // 输入："0", 返回：true
    // 输入："01" 返回：true
    // 输入："10" 返回：true
    // 输入："10.1", 返回：false
    // 输入："10.0" 返回：false
    // 输入："0.0" 返回：false
    public static boolean isNumeric(String str) {
        String regex = "^[+|-]?\\d+$";
        return str.matches(regex);
    }

    // 只由数字和字母组成，并且要同时含有数字和字母，且长度在8-16位之间。
    // 举例：
    // 输入："!@#$%^&*()", 返回：false
    // 输入："1234567", 返回：false
    // 输入："12345678", 返回：false
    // 输入："1234567890123456", 返回：false
    // 输入："1234567890123456a", 返回：false
    // 输入："abcdefg", 返回：false
    // 输入："abcdefgh", 返回：false
    // 输入："abcdefghijklmnop", 返回：false
    // 输入："abcdefghijklmnop1", 返回：false
    // 输入："1234567a", 返回：true
    // 输入："a12345687", 返回：true
    // 输入："123456789012345a", 返回：true
    // 输入："abcdefghijklmno1", 返回：true
    public static boolean isValidPwd(String pwd) {
        String regex = StringUtil.PASSWORD_PATTERN;
        return pwd.matches(regex);
    }

    // 生成密码
    public static String generatePassword(int length) {
        String val = "";
        Random random = new Random();

        // 参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    public static boolean isValidUTF8Charset(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }

        String newStr = "";
        try {
            newStr = new String(str.getBytes("utf-8"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }

        if (str.equals(newStr)) {
            return true;
        }
        return false;
    }

    public static int getRandomCode() {
        byte[] bytes = SecureRandom.getSeed(20);
        SecureRandom random = new SecureRandom(bytes);
        return random.nextInt(9000) + 1000;
    }

    public static Integer convertInteger(String number) {
        if (isNumeric(number)) {
            return Integer.parseInt(number);
        } else {
            return null;
        }
        // try {
        // return Integer.parseInt(number);
        // } catch (Exception e) {
        // return null;
        // }
    }

    /**
     * 正则表达式校验邮箱
     *
     * @param email 待匹配的邮箱
     * @return 匹配成功返回true 否则返回false;
     */
    public static boolean checkEmail(String email) {
        String regex = StringUtil.EMAIL_PATTERN;
        return email.matches(regex);
    }

    // 验证手机号码：只验证11位数字
    public static boolean checkMobile(String mobileNo) {
        String regex = StringUtil.MOBILE_PATTERN;
        return mobileNo.matches(regex);
    }

    public static boolean upperEqual(String source, String tag) {
        source = source.toUpperCase();
        tag = tag.toUpperCase();
        if (source.equals(tag)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean lowerEqual(String source, String tag) {
        source = source.toLowerCase();
        tag = tag.toLowerCase();
        if (source.equals(tag)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBetweenIpSegment(String ipAddressFromLogin, String limitedContent0, String limitedContent1) {
        int length = ipAddressFromLogin.length();
        int lastSpotPosition = ipAddressFromLogin.lastIndexOf('.');
        String ipAddressFromLoginFirst = ipAddressFromLogin.substring(0, lastSpotPosition);
        int ipAddressFromLoginLast = Integer.parseInt(ipAddressFromLogin.substring(lastSpotPosition + 1, length));

        length = limitedContent0.length();
        lastSpotPosition = limitedContent0.lastIndexOf('.');
        String limitedIpSegmentStartFirst = limitedContent0.substring(0, lastSpotPosition);
        int limitedIpSegmentStartLast = Integer.parseInt(limitedContent0.substring(lastSpotPosition + 1, length));

        length = limitedContent1.length();
        lastSpotPosition = limitedContent1.lastIndexOf('.');
        String limitedIpSegmentEndFirst = limitedContent1.substring(0, lastSpotPosition);
        int limitedIpSegmentEndLast = Integer.parseInt(limitedContent1.substring(lastSpotPosition + 1, length));

        if (!limitedIpSegmentStartFirst.equals(limitedIpSegmentEndFirst)) { // 受限制IP开始地址的头部
            // 不等于
            // 受限制IP结束地址的头部
            return false;
        } else if (!limitedIpSegmentStartFirst.equals(ipAddressFromLoginFirst)) { // 受限制IP开始地址的头部
            // 不等于
            // 输入IP地址的头部
            return false;
        } else if (limitedIpSegmentEndLast < limitedIpSegmentStartLast) { // 受限制IP结束地址的尾部
            // 小于
            // 受限制IP开始地址的尾部
            return false;
        }

        // 判断输入IP地址的尾部是否在区间内
        if (ipAddressFromLoginLast < limitedIpSegmentStartLast || ipAddressFromLoginLast > limitedIpSegmentEndLast) {
            return false;
        }

        return true;
    }

    public static boolean hasValue(String value) {
        if (value != null && !value.isEmpty()) {
            return true;
        }
        return false;
    }


    public static boolean hasValue(Map<String, Object> map, String key) {
        if (map.containsKey(key)) {
            return hasValue((String) map.get(key), true);
        }
        return false;
    }

    public static boolean hasValue(String value, boolean trim) {
        if (trim) {
            if (value != null && !value.trim().isEmpty()) {
                return true;
            }
            return false;
        } else {
            if (value != null && !value.isEmpty()) {
                return true;
            }
            return false;
        }
    }

    public static boolean isProductVersion(String str) {
        String a = "\\d+(\\.\\d+){2}$";
        return str.matches(a);
    }

    public static void main(String[] args) {
        System.out.println(isProductVersion("142424.124242.11245242"));
    }

    /**
     * 将emoji表情替换成*
     *
     * @param source
     * @return 过滤后的字符串
     */
    public static String filterEmoji(String source) {
        if (StringUtil.hasValue(source)) {
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "");
        } else {
            return source;
        }
    }

    public static String getliststr(List<String> list) {
        String result = "";
        for (String item : list) {
            result += item + ",";
        }
        if (list.size() > 0) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    public static String getPinYinHeadChar(String str) {
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }
}
