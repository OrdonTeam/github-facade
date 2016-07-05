package github.repositories.details.converter

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Locale

class GitHubApiDateFormatConverterTest {

    val converter = GitHubApiDateFormatConverter()

    @Test
    fun shouldConvertFromGitHubFormat() {
        verifyConversion("2016-05-03T21:12:50Z", Locale.US, "Tuesday, May 3, 2016 9:12:50 PM CEST")
    }

    @Test
    fun shouldConvertToGermanyLocale() {
        verifyConversion("2016-05-03T21:12:50Z", Locale.GERMANY, "Dienstag, 3. Mai 2016 21:12 Uhr MESZ")
    }

    private fun verifyConversion(date: String, locale: Locale, expected: String) {
        assertEquals(expected, converter.changeDateFormat(date, locale))
    }
}