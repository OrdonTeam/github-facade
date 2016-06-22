package github.repositories.details.controller

import com.nhaarman.mockito_kotlin.mock
import github.repositories.details.GitHubRepositoryDetailsService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
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
    private lateinit var mockMvc: MockMvc

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }

    @Test
    fun shouldRunEndpoint() {
        mockMvc.perform(get("/repositories")).andExpect(status().isOk)
    }

    @Configuration
    @ComponentScan
    open class TestConfiguration {

        @Bean
        open fun gitHubRepositoryDetailsService() = mock<GitHubRepositoryDetailsService>()
    }
}