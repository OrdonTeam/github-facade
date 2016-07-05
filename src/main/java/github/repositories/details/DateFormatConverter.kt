package github.repositories.details

import java.util.Locale

interface DateFormatConverter {
    fun changeDateFormat(date: String, locale: Locale): String
}