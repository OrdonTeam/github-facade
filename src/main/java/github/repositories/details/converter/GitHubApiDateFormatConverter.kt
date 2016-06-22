package github.repositories.details.converter

import github.repositories.details.DateFormatConverter
import java.text.DateFormat.FULL
import java.text.DateFormat.getDateTimeInstance
import java.text.SimpleDateFormat
import java.util.*

class GitHubApiDateFormatConverter : DateFormatConverter {

    val gitHubDateFormater = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

    override fun changeDateFormat(date: String, locale: Locale): String {
        return getDateTimeInstance(FULL, FULL, locale).format(gitHubDateFormater.parse(date))
    }
}