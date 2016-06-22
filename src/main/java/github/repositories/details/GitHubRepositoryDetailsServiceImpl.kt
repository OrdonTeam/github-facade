package github.repositories.details

class GitHubRepositoryDetailsServiceImpl(val api: GitHubRepositoryDetailsApi, val converter: DateFormatConverter) : GitHubRepositoryDetailsService {

    override fun getRepositoryDetails(owner: String, repositoryName: String, dateFormat: String): GitHubRepositoryDetails {
        val repositoryDetails = api.getRepositoryDetails(owner, repositoryName)
        val convertedTime = converter.changeDateFormat(repositoryDetails.createdAt, dateFormat)
        return repositoryDetails.copy(createdAt = convertedTime)
    }
}
