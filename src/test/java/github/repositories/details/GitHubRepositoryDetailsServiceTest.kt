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
    val service = GitHubRepositoryDetailsService(api)
    val apiResponse = newGitHubRepositoryDetails()

    @Before
    fun setUp() {
        whenever(api.getRepositoryDetails(any(), any())).thenReturn(apiResponse)
    }

    @Test
    fun shouldReturnRepositoryDetails() {
        Assert.assertEquals(apiResponse, executeService())
    }

    @Test
    fun shouldUseOwnerAndRepositoryNameParametersInApiCall() {
        executeService()

        verify(api).getRepositoryDetails("OrdonTeam", "ogame-api")
    }

    private fun executeService(): GitHubRepositoryDetails {
        return service.getRepositoryDetails("OrdonTeam", "ogame-api")
    }
}
