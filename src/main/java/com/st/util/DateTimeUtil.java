package com.st.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.Locale;

@Slf4j
public class DateTimeUtil {

    public static final String STANDARD_FORMAT = "EEE MMM dd HH:mm:ss Z yyyy";

    public static final DateTimeFormatter dtf = DateTimeFormat.forPattern(STANDARD_FORMAT).withLocale(Locale.ENGLISH);

    public static String dateToStr(Date date) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT, Locale.ENGLISH);
    }

    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static void main(String[] args) {
        String str = DateTimeUtil.dateToStr(new Date());
        log.info(str);
    }
}
