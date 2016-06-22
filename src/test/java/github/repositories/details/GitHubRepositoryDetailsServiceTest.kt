package github.repositories.details

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GitHubRepositoryDetailsServiceTest {

    val api = mock<GitHubRepositoryDetailsApi>()
    val converter = mock<DateFormatConverter>()
    val service = GitHubRepositoryDetailsServiceImpl(api, converter)
    val apiResponse = newGitHubRepositoryDetails()

    @Before
    fun setUp() {
        whenever(api.getRepositoryDetails(any(), any())).thenReturn(apiResponse)
        whenever(converter.changeDateFormat(any(), any())).thenReturn("2016-05-03")
    }

    @Test
    fun shouldUseOwnerAndRepositoryNameParametersInApiCall() {
        executeService()

        verify(api).getRepositoryDetails("OrdonTeam", "ogame-api")
    }

    @Test
    fun shouldConvertDate() {
        executeService()

        verify(converter).changeDateFormat("2016-05-03T21:12:50Z", "yyyy-MM-dd")
    }

    @Test
    fun shouldReturnRepositoryDetails() {
        Assert.assertEquals(newGitHubRepositoryDetails(createdAt = "2016-05-03"), executeService())
    }

    private fun executeService(): GitHubRepositoryDetails {
        return service.getRepositoryDetails("OrdonTeam", "ogame-api", "yyyy-MM-dd")
    }
}
