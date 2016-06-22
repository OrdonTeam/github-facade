package github.repositories.details.controller

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import github.repositories.details.GitHubRepositoryDetailsService
import github.repositories.details.newGitHubRepositoryDetails
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

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
    fun shouldRunEndpoint() {
        whenever(service.getRepositoryDetails(any(), any(), any())).thenReturn(newGitHubRepositoryDetails())
        mockMvc.perform(get("/repositories/OrdonTeam/ogame-api")).andExpect(status().isOk)
        verify(service).getRepositoryDetails("OrdonTeam", "ogame-api", "")
    }

    @Configuration
    @ComponentScan
    open class TestConfiguration {

        @Bean
        open fun gitHubRepositoryDetailsService() = mock<GitHubRepositoryDetailsService>()
    }
}