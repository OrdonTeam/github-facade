package github.repositories.details.controller

import github.repositories.details.GitHubRepositoryDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.util.*

@Controller
class GitHubRepositoryDetailsController @Autowired constructor(val service: GitHubRepositoryDetailsService) {

    @RequestMapping(value = "/repositories/{owner}/{repositoryName}", method = arrayOf(RequestMethod.GET))
    fun repositoryDetails(
            @PathVariable("owner") owner: String,
            @PathVariable("repositoryName") repositoryName: String): String {
        return service.getRepositoryDetails(owner, repositoryName, Locale.US).toString()
    }
}
