package github.repositories.details.api

import github.repositories.details.GitHubRepositoryDetails
import github.repositories.details.GitHubRepositoryDetailsApi
import org.springframework.web.client.RestTemplate

class GitHubRepositoryDetailsApiImpl : GitHubRepositoryDetailsApi {

    val restTemplate = RestTemplate()

    override fun getRepositoryDetails(owner: String, repositoryName: String): GitHubRepositoryDetails {
        return restTemplate.getForObject("https://api.github.com/repos/{owner}/{repo}", GitHubRepositoryDetailsFromApi::class.java, owner, repositoryName).toGitHubRepositoryDetails()
    }

    fun GitHubRepositoryDetailsFromApi.toGitHubRepositoryDetails(): GitHubRepositoryDetails {
        return GitHubRepositoryDetails(full_name, description, clone_url, stargazers_count, created_at)
    }
}
