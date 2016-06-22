package github.repositories.details.controller

import com.google.gson.Gson
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import github.repositories.details.GitHubRepositoryDetailsService
import github.repositories.details.newGitHubRepositoryDetails
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import java.util.*

@RunWith(SpringJUnit4ClassRunner::class)
@WebAppConfiguration
@ContextConfiguration(classes = arrayOf(GitHubRepositoryDetailsControllerTest.TestConfiguration::class))
class GitHubRepositoryDetailsControllerTest {

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext
    @Autowired
    private lateinit var service: GitHubRepositoryDetailsService
    private lateinit var mockMvc: MockMvc

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }

    @Test
    fun shouldReturnJson() {
        whenever(service.getRepositoryDetails("OrdonTeam", "ogame-api", Locale.US)).thenReturn(newGitHubRepositoryDetails())
        mockMvc.perform(get("/repositories/OrdonTeam/ogame-api"))
                .andExpect(content().json(Gson().toJson(newGitHubRepositoryDetails())))
    }

    @EnableAutoConfiguration
    @ComponentScan
    @Configuration
    open class TestConfiguration {

        @Bean
        open fun gitHubRepositoryDetailsService() = mock<GitHubRepositoryDetailsService>()
    }
}