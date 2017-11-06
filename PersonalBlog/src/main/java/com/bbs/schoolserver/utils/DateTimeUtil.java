package com.bbs.schoolserver.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 大森 on 2017/9/18.
 */
public class DateTimeUtil {

    // 毫秒 -> 年月日
    public static String getDateHandler(long time) {
        String strTime = "";
        if (time != 0) {
            Date nowTime = new Date(System.currentTimeMillis());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            strTime = dateFormat.format(nowTime);
        }
        return strTime;
    }

    // 年月日 -> 毫秒
    public static long toDateHandler() {
        return System.currentTimeMillis();
    }
}
