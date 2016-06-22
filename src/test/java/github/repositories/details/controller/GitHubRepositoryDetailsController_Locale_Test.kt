package github.repositories.details.controller

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import github.repositories.details.GitHubRepositoryDetailsService
import org.junit.Test
import java.util.*

class GitHubRepositoryDetailsController_Locale_Test {

    val service = mock<GitHubRepositoryDetailsService>()

    @Test
    fun shouldPassReceivedLocale() {
        GitHubRepositoryDetailsController(service).repositoryDetails("any", "any", Locale.CHINESE)
        verify(service).getRepositoryDetails(any(), any(), eq(Locale.CHINESE))
    }
}