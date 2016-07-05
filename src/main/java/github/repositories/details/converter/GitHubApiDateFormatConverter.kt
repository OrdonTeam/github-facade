package github.repositories.details.converter

import github.repositories.details.DateFormatConverter
import org.apache.commons.lang3.time.FastDateFormat
import java.text.DateFormat.FULL
import java.text.DateFormat.getDateTimeInstance
import java.util.*

class GitHubApiDateFormatConverter : DateFormatConverter {

    val gitHubDateFormater = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss'Z'")

    override fun changeDateFormat(date: String, locale: Locale): String {
        return getDateTimeInstance(FULL, FULL, locale).format(gitHubDateFormater.parse(date))
    }
}