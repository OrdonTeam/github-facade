package github.repositories.details.api

import github.repositories.details.newGitHubRepositoryDetails
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

class GitHubRepositoryDetailsApiImplTest {

    val api = GitHubRepositoryDetailsApiImpl()

    @Test
    @Ignore("contract")
    fun testGitHubContract() {
        assertEquals(newGitHubRepositoryDetails(), api.getRepositoryDetails("OrdonTeam", "ogame-api"))
    }
}