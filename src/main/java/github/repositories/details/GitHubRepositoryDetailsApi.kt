package github.repositories.details

interface GitHubRepositoryDetailsApi {

    fun getRepositoryDetails(owner: String, repositoryName: String): GitHubRepositoryDetails
}