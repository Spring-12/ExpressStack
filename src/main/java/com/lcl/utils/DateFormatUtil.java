package com.lcl.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

    public static String dateFormat(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
