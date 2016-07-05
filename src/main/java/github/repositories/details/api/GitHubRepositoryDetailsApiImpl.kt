package github.repositories.details.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import github.repositories.details.GitHubRepositoryDetails
import github.repositories.details.GitHubRepositoryDetailsApi
import org.springframework.http.converter.json.GsonHttpMessageConverter
import org.springframework.web.client.RestTemplate

class GitHubRepositoryDetailsApiImpl(val baseGitHubApiUrl: String) : GitHubRepositoryDetailsApi {

    val repositoryDetailsUrl = "$baseGitHubApiUrl/repos/{owner}/{repo}"
    val restTemplate = createRestTemplate()

    override fun getRepositoryDetails(owner: String, repositoryName: String): GitHubRepositoryDetails {
        return restTemplate.getForObject(repositoryDetailsUrl, GitHubRepositoryDetailsFromApi::class.java, owner, repositoryName).toGitHubRepositoryDetails()
    }

    fun GitHubRepositoryDetailsFromApi.toGitHubRepositoryDetails(): GitHubRepositoryDetails {
        return GitHubRepositoryDetails(fullName, description, cloneUrl, stargazersCount, createdAt)
    }

    private fun createRestTemplate(): RestTemplate {
        return RestTemplate(listOf(GsonHttpMessageConverter().apply {
            gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        }))
    }
}
