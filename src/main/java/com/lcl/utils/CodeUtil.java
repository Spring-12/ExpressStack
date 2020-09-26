package com.lcl.utils;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 生成6位 大小写字母、数字 的组合字符串
 */
public class CodeUtil {

    public static String createCode(){
        return RandomStringUtils.randomAlphanumeric(6);
    }
}
