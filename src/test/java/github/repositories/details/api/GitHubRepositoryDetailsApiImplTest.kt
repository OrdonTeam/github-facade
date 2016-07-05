package github.repositories.details.api

import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.urlMatching
import com.github.tomakehurst.wiremock.junit.WireMockRule
import github.repositories.details.newGitHubRepositoryDetails
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import java.io.File
import java.lang.Thread.currentThread

class GitHubRepositoryDetailsApiImplTest {

    @Rule @JvmField
    val rule = WireMockRule(39517)

    @Test
    fun shouldParseApiResponse() {
        rule.returnResponseFromFile("github-repository-details.json")
        val baseGitHubApiUrl = "http://127.0.0.1:39517"
        assertEquals(newGitHubRepositoryDetails(), GitHubRepositoryDetailsApiImpl(baseGitHubApiUrl).getRepositoryDetails("OrdonTeam", "ogame-api"))
    }

    @Test
    @Ignore("contract")
    fun testGitHubContract() {
        val baseGitHubApiUrl = "https://api.github.com"
        assertEquals(newGitHubRepositoryDetails(), GitHubRepositoryDetailsApiImpl(baseGitHubApiUrl).getRepositoryDetails("OrdonTeam", "ogame-api"))
    }

    fun WireMockRule.returnResponseFromFile(fileName: String) {
        val body = File(currentThread().contextClassLoader.getResource(fileName).toURI()).readBytes()
        stubFor(get(urlMatching(".*"))
                .willReturn(aResponse()
                        .withHeader("Content-type", "application/json")
                        .withBody(body)))
    }
}
