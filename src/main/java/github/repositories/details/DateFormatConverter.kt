package github.repositories.details

import java.util.*

interface DateFormatConverter {
    fun changeDateFormat(date: String, locale: Locale): String
}