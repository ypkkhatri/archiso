package com.yog.fw.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    public static long getTime(Date date, boolean isEnd) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

        if (isEnd) {
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
        } else {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 1);
        }
        return calendar.getTimeInMillis();
    }

    public static long getTsOfMonth(Date date, boolean isEnd, boolean isPrevious) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

        if (isEnd) {
            if (isPrevious) {
                calendar.add(Calendar.MONTH, -1);
            }
            calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
        } else {
            if (isPrevious) {
                calendar.add(Calendar.MONTH, -1);
            }
            calendar.set(Calendar.DATE, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 1);
        }
        return calendar.getTimeInMillis();
    }

    public static long getTimeEndHours(Date date, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);

        return calendar.getTimeInMillis();
    }

    public static long getTimeInMillis(String dateString, String format) {
        long ts = 0L;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);

            Date date = sdf.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            ts = calendar.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ts;
    }

    public static long getDateInMillis(Date date) {
        long ts = 0L;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        ts = calendar.getTimeInMillis();
        return ts;
    }

    public static long getCurrentDateInMillis() {
        long ts = 0L;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        ts = calendar.getTimeInMillis();
        return ts;
    }

    public static String getFormatedDate(Long dateMs, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date(dateMs);
        return sdf.format(date);
    }

    public static Date getDate(long dateTs) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateTs);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
