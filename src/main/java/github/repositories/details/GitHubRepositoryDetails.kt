package github.repositories.details

data class GitHubRepositoryDetails(
        val fullName: String,
        val description: String,
        val cloneUrl: String,
        val stars: Int,
        val createdAt: String)