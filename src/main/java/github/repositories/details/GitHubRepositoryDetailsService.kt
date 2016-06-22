package github.repositories.details

interface GitHubRepositoryDetailsService {

    fun getRepositoryDetails(owner: String, repositoryName: String, dateFormat: String): GitHubRepositoryDetails
}