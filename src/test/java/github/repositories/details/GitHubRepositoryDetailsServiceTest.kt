package github.repositories.details

import org.junit.Assert
import org.junit.Test

class GitHubRepositoryDetailsServiceTest {

    @Test
    fun shouldReturnRepositoryDetails() {
        val expected = GitHubRepositoryDetails("Full name")

        val repositoryDetails = GitHubRepositoryDetailsService().getRepositoryDetails()

        Assert.assertEquals(expected, repositoryDetails)
    }
}