package ru.utils.text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateCompareUtils {

    public static Date getTimeAtStartOfDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getTimeAtStartOfDay(date.getTime());
    }

    public static Date getTimeAtStartOfDay(long ms) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getTimeAtStartOfToday() {
        long now = Calendar.getInstance().getTimeInMillis();
        return getTimeAtStartOfDay(now);
    }

    public static Date getYesterday(Date date) {
        Calendar yesterday = Calendar.getInstance();
        yesterday.setTime(date);
        yesterday.add(Calendar.DATE, -1);
        return yesterday.getTime();
    }

    public static boolean dateIsTodayOrAfter(Date compareDate) {
        Date now = DateCompareUtils.getTimeAtStartOfDay(new Date());
        Date compare = DateCompareUtils.getTimeAtStartOfDay(compareDate);
        return !now.after(compare);
    }

    public static boolean dateIsToday(Date compareDate) {
        Date now = DateCompareUtils.getTimeAtStartOfDay(new Date());
        Date compare = DateCompareUtils.getTimeAtStartOfDay(compareDate);
        return isEqualsDays(now, compare);
    }

    public static boolean isEqualsDays(Date nextPaymentDate, Date now) {
        return nextPaymentDate.compareTo(now) == 0;
    }

    public static boolean isEquals(Date date, Date date2) {
        if (date == null || date2 == null) {
            return false;
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(date2);
        return cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    public static boolean isEqualsYearMonth(Date date, Date date2) {
        if (date == null || date2 == null) {
            return false;
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(date2);
        return isEqualsYearMonth(cal, cal2);
    }

    public static boolean isEqualsYearMonth(Calendar cal, Calendar cal2) {
        return cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
    }


    public static boolean isDateBefore(Date firstDate, Date secondDate) {
        if (secondDate == null) {
            return true;
        }

        Calendar currentCal = new GregorianCalendar();
        currentCal.setTime(firstDate);

        Calendar maxCal = new GregorianCalendar();
        maxCal.setTime(secondDate);

        return (currentCal.get(Calendar.YEAR) < maxCal.get(Calendar.YEAR)) ||
                (currentCal.get(Calendar.YEAR) == maxCal.get(Calendar.YEAR) &&
                        (currentCal.get(Calendar.MONTH) < maxCal.get(Calendar.MONTH)
                                || (currentCal.get(Calendar.MONTH) == maxCal.get(Calendar.MONTH) && currentCal.get(Calendar.DAY_OF_MONTH) <= maxCal.get(Calendar.DAY_OF_MONTH))));
    }

    public static boolean isDateAfter(Date firstDate, Date secondDate) {
        if (secondDate == null) {
            return true;
        }

        Calendar currentCal = new GregorianCalendar();
        currentCal.setTime(firstDate);

        Calendar minCal = new GregorianCalendar();
        minCal.setTime(secondDate);

        return (currentCal.get(Calendar.YEAR) > minCal.get(Calendar.YEAR))
                || (currentCal.get(Calendar.YEAR) == minCal.get(Calendar.YEAR) && (currentCal.get(Calendar.MONTH) > minCal.get(Calendar.MONTH))
                || (currentCal.get(Calendar.MONTH) == minCal.get(Calendar.MONTH) && currentCal.get(Calendar.DAY_OF_MONTH) >= minCal.get(Calendar.DAY_OF_MONTH)));
    }

    public static Calendar getDatePart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public static int daysBetween(Date startDate, Date endDate) {
        Calendar sDate = getDatePart(startDate);
        Calendar eDate = getDatePart(endDate);

        int daysBetween = 0;
        while (sDate.before(eDate)) {
            sDate.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }

    private static SimpleDateFormat timerFormat = new SimpleDateFormat("mm:ss");

    public static String formatDateAsTimer(Date date) {
        return timerFormat.format(date);
    }

    public static Calendar getCurrent() {
        return getDatePart(Calendar.getInstance().getTime());
    }

    public static int numberOfDaysInYear(Date date) {
        Calendar cal = DateCompareUtils.getCurrent();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
    }


}
