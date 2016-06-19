package github.repositories.details

class GitHubRepositoryDetailsService(val api: GitHubRepositoryDetailsApi, val converter: DateFormatConverter) {

    fun getRepositoryDetails(owner: String, repositoryName: String, dateFormat: String): GitHubRepositoryDetails {
        val repositoryDetails = api.getRepositoryDetails(owner, repositoryName)
        val convertedTime = converter.changeDateFormat(repositoryDetails.createdAt, dateFormat)
        return repositoryDetails.copy(createdAt = convertedTime)
    }
}
