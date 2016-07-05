package github.repositories.details.controller

import com.google.gson.Gson
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import github.repositories.details.GitHubRepositoryDetailsService
import github.repositories.details.newGitHubRepositoryDetails
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.context.WebApplicationContext

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
        whenever(service.getRepositoryDetails(any(), any(), any())).thenReturn(newGitHubRepositoryDetails())
        mockMvc.perform(get("/repositories/owner/repositoryName"))
                .andExpect(content().json(Gson().toJson(newGitHubRepositoryDetails())))
    }

    @Test
    fun shouldReceivePathVariable() {
        mockMvc.perform(get("/repositories/owner/repositoryName"))
        verify(service).getRepositoryDetails(eq("owner"), eq("repositoryName"), any())
    }

    @Test
    fun shouldShow404Error() {
        whenever(service.getRepositoryDetails(any(), any(), any())).thenThrow(HttpClientErrorException(HttpStatus.NOT_FOUND))
        mockMvc.perform(get("/repositories/owner/repositoryName").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound)
    }

    @After
    fun tearDown() {
        Mockito.reset(service)
    }

    @EnableAutoConfiguration
    @ComponentScan
    @Configuration
    open class TestConfiguration {

        @Bean
        open fun gitHubRepositoryDetailsService() = mock<GitHubRepositoryDetailsService>()
    }
}