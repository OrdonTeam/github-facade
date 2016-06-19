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
    val expected = GitHubRepositoryDetails("OrdonTeam")

    @Before
    fun setUp() {
        whenever(api.getRepositoryDetails(any())).thenReturn(expected)
    }

    @Test
    fun shouldReturnRepositoryDetails() {
        Assert.assertEquals(expected, executeService())
    }

    @Test
    fun shouldUseOwnerParameterInApiCall() {
        executeService()

        verify(api).getRepositoryDetails("OrdonTeam")
    }

    private fun executeService(): GitHubRepositoryDetails {
        return service.getRepositoryDetails("OrdonTeam")
    }
}
