package com.james.example.cloud.nacos.dubbo.common.utils;

/**
 * 字符串工具
 *
 * Created by James on 2020/3/6.
 */
public class StringUtils {

    /**
     * 判空操作
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判非空操作
     *
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
}
