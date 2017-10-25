package com.zmy.springboot.kotlin_pro.util

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

/**
 * 格式化当前的时间
 * @param pattern 模式
 * @return string
 * @example formatCurrent("yyyy-MM-dd HH:mm:ss")/ yyyy-MM-dd
 */
fun formatCurrentTime(pattern: String): String {
    val formatter = DateTimeFormatter.ofPattern(pattern)
    val currentTime = LocalDateTime.now()
    return currentTime.format(formatter)
}

/**
 * 格式化为年月日时分秒
 * @param dateTime: 年月日时分秒 pattern：模式
 * @return string
 * @example formatDateTime(dateTime, "yyyy-MM-ss HH:mm:ss")
 */
fun formatDateTime(dateTime: LocalDateTime, pattern: String): String {
    return dateTime.format(DateTimeFormatter.ofPattern(pattern))
}

/**
 * 格式化年月日
 * @param date：时间 pattern：格式
 * @return string
 * @example formatDate(date, "yyyy/MM/dd")
 */
fun formatDate(date: LocalDate, pattern: String): String {
    return date.format(DateTimeFormatter.ofPattern(pattern))
}

/**
 * 根据当前时间的字符串格式为对象
 * @param dateTimeString 日期字符串 pattern 模式
 * @return LocalDateTime
 * @example parseDateTime("2000-10-10 11:11:11", "yyyy-MM-dd HH:mm:ss")
 */
fun parseDateTime(dateTimeString: String, pattern: String): LocalDateTime {
    return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern(pattern))
}

/**
 * 根据当前日期字符串格式化为对象
 * @param dateString 日期字符
 * @param pattern 模式
 * @return LocalDate
 * @example parseDate("2000-10-10", "yyyy-MM-dd")
 */
fun parseDate(dateString: String, pattern: String): LocalDate {
    return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(pattern))
}

/**
 * 获取两个日期之间的间隔
 * @param dateStart 开始日期字符串
 * @param dateEnd 结束时间字符串
 * @param pattern 模式
 * @return Period
 * @example getInterval("2000-10-10", "2000-10-11", "yyyy-MM-ss").days/months/years
 */
fun getInterval(dateStart: String, dateEnd: String, pattern: String): Period {
    return Period.between(parseDate(dateStart, pattern), parseDate(dateEnd, pattern))
}

/**
 * 获取中文表示的星期
 * @param date 当前日期
 * @return 星期几
 */
fun getWeekCH(date: LocalDate): String {
    return date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.SIMPLIFIED_CHINESE)
}








