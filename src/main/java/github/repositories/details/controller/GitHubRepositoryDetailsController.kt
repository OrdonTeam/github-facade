package github.repositories.details.controller

import github.repositories.details.GitHubRepositoryDetails
import github.repositories.details.GitHubRepositoryDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException
import java.util.Locale
import javax.servlet.http.HttpServletResponse

@RestController
class GitHubRepositoryDetailsController @Autowired constructor(val service: GitHubRepositoryDetailsService) {

    @RequestMapping(value = "/repositories/{owner}/{repositoryName}", method = arrayOf(RequestMethod.GET))
    fun repositoryDetails(
            @PathVariable("owner") owner: String,
            @PathVariable("repositoryName") repositoryName: String,
            locale: Locale): GitHubRepositoryDetails {
        return service.getRepositoryDetails(owner, repositoryName, locale)
    }

    @ExceptionHandler
    fun handleIllegalArgumentException(e: HttpClientErrorException, response: HttpServletResponse) {
        response.sendError(e.statusCode.value());
    }
}
