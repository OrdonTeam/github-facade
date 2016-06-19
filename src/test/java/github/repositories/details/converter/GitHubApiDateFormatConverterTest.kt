package github.repositories.details.converter

import org.junit.Assert.assertEquals
import org.junit.Test

class GitHubApiDateFormatConverterTest {

    val converter = GitHubApiDateFormatConverter()

    @Test
    fun shouldConvertFromGitHubFormat() {
        verifyConversion("2016-05-03T21:12:50Z", "yyyy-MM-dd", "2016-05-03")
    }

    private fun verifyConversion(date: String, outputFormat: String, expected: String) {
        assertEquals(expected, converter.changeDateFormat(date, outputFormat))
    }
}