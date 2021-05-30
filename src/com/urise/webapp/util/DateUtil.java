package com.urise.webapp.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

public class DateUtil {
    public static YearMonth NOW = YearMonth.now();

    public static LocalDate of(int year, Month month) {
        return LocalDate.of(year, month, 1);
    }
}
