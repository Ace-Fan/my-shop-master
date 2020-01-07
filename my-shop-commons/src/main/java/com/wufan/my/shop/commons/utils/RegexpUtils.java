package com.wufan.my.shop.commons.utils;

/**
 * @author ：WuFan
 * @date ：Created in 2019/11/23 0023 17:49
 * @description：
 * @modified By：
 * @version: $
 */
public class RegexpUtils {
    /**
     * 验证手机号
     */
    public static final String PHONE = "^1(3|4|5|7|8)\\d{9}$";

    /**
     * 验证邮箱地址
     */
    public static final String EMAIL = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";

    /**
     * 验证手机号
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        return phone.matches(PHONE);
    }

    /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        return email.matches(EMAIL);
    }
}
