package github.repositories.details

class GitHubRepositoryDetailsService(val api: GitHubRepositoryDetailsApi) {

    fun getRepositoryDetails(owner: String): GitHubRepositoryDetails {
        return api.getRepositoryDetails(owner)
    }
}
