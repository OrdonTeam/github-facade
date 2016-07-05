package github.repositories.details.api

data class GitHubRepositoryDetailsFromApi(
        val fullName: String,
        val description: String,
        val cloneUrl: String,
        val stargazersCount: Int,
        val createdAt: String)