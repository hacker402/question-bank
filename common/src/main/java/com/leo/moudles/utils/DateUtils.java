package com.leo.moudles.utils;

import com.leo.moudles.utils.validate.ValidateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * DateUtils
 * </p>
 *
 * @author qingweiqu
 */
public class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static final String DATE_FORMATE = "yyyy-MM-dd";

    public static final String DATE_FOR_MATE = "yyyyMMdd";

    public static final String YEAR_FORMATE = "yyyy";

    public static final String DATE_TIME_FORMATE = "yyyy-MM-dd HH:mm:ss";

    public static final String END_OF_DAY = " 23:59:59";

    public static final String START_OF_DAY = " 00:00:00";

    public static final String MAX_END_OF_DATE = "9999-12-31";

    /**
     * 当前时间
     *
     * @return Date
     */
    public static Date now() {
        return new Date();
    }


    public static String nowStr() {
        return dateToString(now(), DATE_TIME_FORMATE);
    }

    public static String nowStrDay() {
        return dateToString(now(), DATE_FORMATE);
    }


    /**
     * 计算开始时间与今天间隔时间
     *
     * @param startDate 开始时间
     * @return int
     */
    public static int getGapDayForToday(Date startDate) {
        return getGapDays(startDate, now());
    }

    /**
     * 计算两个日期间隔天数
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 间隔天数
     */
    public static int getGapDays(Date startDate, Date endDate) {
        ValidateUtils.create()
                .append(startDate, DataUtils::isNotNull, "startDate为空")
                .append(endDate, DataUtils::isNotNull, "endDate为空")
                .validate();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(startDate);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(endDate);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) {
            //同一年
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    //闰年
                    timeDistance += 366;
                } else {
                    //不是闰年
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else {
            //不同年
            return day2 - day1;
        }
    }

    public static Date plusDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    public static Date plusMinutes(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    public static Date lessMinutes(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, -minute);
        return calendar.getTime();
    }


    public static Date lessDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -day);
        return calendar.getTime();
    }


    public static Date stringToDate(String date, String format) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.parse(date);
        } catch (Exception e) {
            logger.error("DateUtil.stringToDate failed:", e);
            return null;
        }
    }

    public static String strNow() {
        return dateToString(now(), DATE_FOR_MATE);
    }

    public static String dateToString(Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                java.text.DateFormat df = new SimpleDateFormat(format);
                result = df.format(date);
            }
        } catch (Exception e) {
            logger.error("DateUtil.dateToString failed:", e);
        }
        return result;
    }

    public static Date getEndOfDate(String date) {
        return stringToDate(date + END_OF_DAY, DATE_TIME_FORMATE);
    }

    public static Date getStartOfDate(String date) {
        return stringToDate(date + START_OF_DAY, DATE_TIME_FORMATE);
    }

    public static boolean isBeforeNow(Date date) {
        return now().getTime() - date.getTime() > 0;
    }

    public static boolean isAfterNow(Date date) {
        return date.getTime() - now().getTime() > 0;
    }

}
