package org.jfteam.framework.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/5 14:44
 */
public final class DateUtils {
    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";


    public static String getDate(Date date) {
        return DateUtils.getDate(date, FORMAT_YYYY_MM_DD);
    }

    public static String getDate(Date date, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    public static Date add(int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, amount);
        return calendar.getTime();
    }
}
