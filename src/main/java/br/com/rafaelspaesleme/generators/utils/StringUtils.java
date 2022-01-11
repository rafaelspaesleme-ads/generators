package br.com.rafaelspaesleme.generators.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils {
    public static String datetimeMillisecound() {
        final LocalDateTime now = LocalDateTime.now();
        return String.valueOf(now.getYear() + now.getMonthValue() + now.getDayOfMonth() + now.getHour() + now.getMinute() + now.getSecond() + now.getNano());
    }
}
