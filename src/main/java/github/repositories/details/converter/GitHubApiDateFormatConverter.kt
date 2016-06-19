package github.repositories.details.converter

import github.repositories.details.DateFormatConverter
import java.text.SimpleDateFormat

class GitHubApiDateFormatConverter : DateFormatConverter {

    val gitHubDateFormater = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

    override fun changeDateFormat(date: String, outputFormat: String): String {
        return SimpleDateFormat(outputFormat).format(gitHubDateFormater.parse(date))
    }
}