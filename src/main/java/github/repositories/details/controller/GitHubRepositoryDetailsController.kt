package github.repositories.details.controller

import github.repositories.details.GitHubRepositoryDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class GitHubRepositoryDetailsController @Autowired constructor(val service: GitHubRepositoryDetailsService) {

    @RequestMapping(value = "/repositories", method = arrayOf(RequestMethod.GET))
    fun repositoryDetails() = "Ok"
}
