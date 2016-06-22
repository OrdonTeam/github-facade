package github

import github.repositories.details.DateFormatConverter
import github.repositories.details.GitHubRepositoryDetailsApi
import github.repositories.details.GitHubRepositoryDetailsService
import github.repositories.details.GitHubRepositoryDetailsServiceImpl
import github.repositories.details.api.GitHubRepositoryDetailsApiImpl
import github.repositories.details.converter.GitHubApiDateFormatConverter
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class Application {

    @Bean
    open fun gitHubRepositoryDetailsApi(): GitHubRepositoryDetailsApi {
        return GitHubRepositoryDetailsApiImpl("https://api.github.com")
    }

    @Bean
    open fun dateFormatConverter(): DateFormatConverter {
        return GitHubApiDateFormatConverter()
    }

    @Bean
    open fun gitHubRepositoryDetailsService(api: GitHubRepositoryDetailsApi, converter: DateFormatConverter): GitHubRepositoryDetailsService {
        return GitHubRepositoryDetailsServiceImpl(api, converter)
    }

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}
