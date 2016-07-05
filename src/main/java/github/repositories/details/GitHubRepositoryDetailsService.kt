package github.repositories.details

import java.util.Locale

interface GitHubRepositoryDetailsService {

    fun getRepositoryDetails(owner: String, repositoryName: String, locale: Locale): GitHubRepositoryDetails
}