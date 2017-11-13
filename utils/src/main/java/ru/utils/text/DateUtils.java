package ru.utils.text;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import ru.utils.Config;
import ru.utils.LogUtils;

/**
 * a
 * Created by deler on 18.08.16.
 */
public class DateUtils {


    private static final String TAG = DateUtils.class.getSimpleName();

    private static final DateFormat ISO8601_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Config.LOCALE);
    private static final DateFormat ISO8601_2_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ", Config.LOCALE);
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Config.LOCALE);
    private static final DateFormat DATE_FORMAT_2 = new SimpleDateFormat("dd.MM.yyyy", Config.LOCALE);
    private static final DateFormat DATE_FORMAT_DOT_SHOT = new SimpleDateFormat("dd.MM.yy", Config.LOCALE);
    public static final DateFormat DATE_FORMAT_READABLE = new SimpleDateFormat("d MMMM yyyy", Config.LOCALE);
    public static final String DATE_STRING_FORMAT_READABLE = "d MMMM yyyy";
    private static final String EMPTY_DATE_STRING_VALUE = "1-1-1";


    public static String formatDateByDot(String dateString) {

        Date date;
        try {
            date = parseDate(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

        return formatDateByDot(date);
    }

    @NonNull
    public static String formatDateByDot(Date date) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        calendar.setTime(date);
        int categoryYear = calendar.get(Calendar.YEAR);

        if (categoryYear == year) {
            return new SimpleDateFormat("dd.MM", Config.LOCALE).format(date);
        } else {
            return DATE_FORMAT_DOT_SHOT.format(date);
        }
    }

    public static String formatDateDot(String dateString) {

        Date date;
        try {
            date = parseDate(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

        return formatDateDot(date);
    }

    @NonNull
    public static String formatDateDot(Date date) {
        return DATE_FORMAT_DOT_SHOT.format(date);
    }


    public static Date parseDateString(String dateString) throws ParseException {
        if (TextUtils.isEmpty(dateString)) return new Date(0);
        DATE_FORMAT.setTimeZone(TimeZone.getDefault());
        return DATE_FORMAT.parse(dateString);
    }

    public static String formatDateString(String dateString, String format) {
        try {
            Date date = parseDate(dateString);
            return formatDate(format, date);
        } catch (ParseException e) {
            LogUtils.d(TAG, "Failed to parse date: " + dateString);
            return "";
        }
    }

    @NonNull
    public static String formatDate(String format, Date date) {
        SimpleDateFormat outputFormat = new SimpleDateFormat(format, Config.LOCALE);
        return outputFormat.format(date);
    }

    public static boolean isDateEmpty(String dateString) {
        if (TextUtils.isEmpty(dateString))
            return true;

        dateString = dateString.replace("0", "");
        return dateString.equals(EMPTY_DATE_STRING_VALUE);
    }

    public static boolean isDateEmpty(Date date) {
        return date == null;
    }

    public static Date parseDate(String dateString) throws ParseException {
        ParseException exception;
        try {
            DATE_FORMAT.setTimeZone(TimeZone.getDefault());
            return DATE_FORMAT.parse(dateString);
        } catch (ParseException ignored) {
        }
        try {
            return ISO8601_DATETIME_FORMAT.parse(dateString);
        } catch (ParseException ignored) {
        }
        try {
            return ISO8601_2_DATETIME_FORMAT.parse(dateString);
        } catch (ParseException ignored) {
        }
        try {
            return DATE_FORMAT_DOT_SHOT.parse(dateString);
        } catch (ParseException ignored) {
        }
        try {
            return DATE_FORMAT_2.parse(dateString);
        } catch (ParseException ignored) {
        }
        try {
            dateString = dateString.replace("Z", "+0000");
            return ISO8601_DATETIME_FORMAT.parse(dateString);
        } catch (ParseException e) {
            exception = e;
        }

        try {
            return new Date(Long.valueOf(dateString));
        } catch (Exception ignored) {
        }

        throw exception;
    }

    public static Date parseIso8601DateTimeString(String dateString) throws ParseException {
        //Java 6 date is not fully compatible with ISO 8601 and doesn't recognize 'Z' marker as +00:00 timezone
        //see http://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html#timezone
        dateString = dateString.replace("Z", "+0000");
        return ISO8601_DATETIME_FORMAT.parse(dateString);
    }


    public static String formatAsIso8601DateTimeString(Date date) {
        return ISO8601_DATETIME_FORMAT.format(date);
    }

    public static String formatIso8601DateTimeString(String dateString, String format) {
        try {
            Date date = parseIso8601DateTimeString(dateString);
            SimpleDateFormat outputFormat = new SimpleDateFormat(format, Config.LOCALE);
            return outputFormat.format(date);
        } catch (ParseException e) {
            LogUtils.d(TAG, "Failed to parse date: " + dateString);
            return "";
        }
    }

    public static String getIso8601DateTimeString(Date date) {
        return ISO8601_DATETIME_FORMAT.format(date);
    }

    /**
     * Return length of time interval between baseDate and comparedDate
     *
     * @param baseDate     start of interval
     * @param comparedDate end of interval
     * @return comparedDate - baseDate
     */
    public static int dateDifferenceInDays(Date baseDate, Date comparedDate) {
        // http://stackoverflow.com/a/3797137
        int millisInDay = 24 * 60 * 60 * 1000;
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        start.setTime(baseDate);
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);

        end.setTime(comparedDate);
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);

        Date startDate = start.getTime();
        Date endDate = end.getTime();
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / millisInDay;

        start.add(Calendar.DAY_OF_MONTH, (int) diffDays);
        while (start.before(end)) {
            start.add(Calendar.DAY_OF_MONTH, 1);
            diffDays++;
        }
        while (start.after(end)) {
            start.add(Calendar.DAY_OF_MONTH, -1);
            diffDays--;
        }
        return (int) diffDays;
    }


    public static Date removeTime(Date date) {
        Calendar cal = getDatePart(date);
        return cal.getTime();
    }

    @NonNull
    private static Calendar getDatePart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public static Date getDatePlusMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.MONTH, month);
        int newMonth = calendar.get(Calendar.MONTH);
        if (newMonth == Calendar.FEBRUARY) {
            int day2 = calendar.get(Calendar.DAY_OF_MONTH);
            if (day2 == 28 && day >= 29) {
                calendar.set(Calendar.MONTH, Calendar.MARCH);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
            }

        }
        return calendar.getTime();
    }

    public static Date getDatePlusDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static boolean isFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH) == 1;
    }

    public static int getDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getRussianDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case 1:
                return 7;
            default:
                return dayOfWeek - 1;
        }
    }

    public static Date getDateFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    public static Date getDateLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int lastDay;
        switch (getMonth(date)) {
            case Calendar.JANUARY:
            case Calendar.MARCH:
            case Calendar.MAY:
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.OCTOBER:
            case Calendar.DECEMBER:
                lastDay = 31;
                break;
            case Calendar.FEBRUARY:
                if (calendar.get(Calendar.YEAR) % 4 == 0) {
                    lastDay = 29;
                } else {
                    lastDay = 28;
                }
                break;
            default:
                lastDay = 30;
                break;
        }
        calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        return calendar.getTime();
    }

    public static boolean isWeekend(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

    public static String getMonthString(int month) {
        switch (month) {
            case Calendar.JANUARY:
                return "Январь";
            case Calendar.FEBRUARY:
                return "Февраль";
            case Calendar.MARCH:
                return "Март";
            case Calendar.APRIL:
                return "Апрель";
            case Calendar.MAY:
                return "Май";
            case Calendar.JUNE:
                return "Июнь";
            case Calendar.JULY:
                return "Июль";
            case Calendar.AUGUST:
                return "Август";
            case Calendar.SEPTEMBER:
                return "Сентябрь";
            case Calendar.OCTOBER:
                return "Октябрь";
            case Calendar.NOVEMBER:
                return "Ноябрь";
            case Calendar.DECEMBER:
                return "Декабрь";
            default:
                return "No_Such_Month";
        }
    }

    public static String getWeekdayShortString(int weekday) {
        switch (weekday) {
            case 1:
                return "Пн";
            case 2:
                return "Вт";
            case 3:
                return "Ср";
            case 4:
                return "Чт";
            case 5:
                return "Пт";
            case 6:
                return "Сб";
            case 7:
                return "Вс";
            default:
                return "No_Such_Weekday";
        }
    }

    public static Calendar getCurrent() {
        return getDatePart(Calendar.getInstance().getTime());
    }

    public static int numberOfDaysInYear(Date date) {
        Calendar cal = DateUtils.getCurrent();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    public static final String W3C_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZZZ";

    public static String toW3CString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(W3C_DATE_FORMAT, Locale.US);
        return format.format(date);
    }
}
