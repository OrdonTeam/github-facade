package github.repositories.details.api

data class GitHubRepositoryDetailsFromApi(
        val full_name: String,
        val description: String,
        val clone_url: String,
        val stargazers_count: Int,
        val created_at: String)