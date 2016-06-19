package github.repositories.details

fun newGitHubRepositoryDetails(fullName: String = "OrdonTeam/ogame-api",
                               description: String = "",
                               cloneUrl: String = "https://github.com/OrdonTeam/ogame-api.git",
                               stars: Int = 0,
                               createdAt: String = "2016-05-03T21:12:50Z")
        = GitHubRepositoryDetails(fullName, description, cloneUrl, stars, createdAt)