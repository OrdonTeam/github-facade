package github.repositories.details

import java.util.Locale

class GitHubRepositoryDetailsServiceImpl(val api: GitHubRepositoryDetailsApi, val converter: DateFormatConverter) : GitHubRepositoryDetailsService {

    override fun getRepositoryDetails(owner: String, repositoryName: String, locale: Locale): GitHubRepositoryDetails {
        val repositoryDetails = api.getRepositoryDetails(owner, repositoryName)
        val convertedTime = converter.changeDateFormat(repositoryDetails.createdAt, locale)
        return repositoryDetails.copy(createdAt = convertedTime)
    }
}
