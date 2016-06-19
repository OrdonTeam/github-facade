package github.repositories.details;

import org.junit.Assert;
import org.junit.Test;

public class GitHubRepositoryDetailsServiceTest {

    @Test
    public void shouldReturnRepositoryDetails() {
        GitHubRepositoryDetails expected = new GitHubRepositoryDetails("Full name");

        GitHubRepositoryDetails repositoryDetails = new GitHubRepositoryDetailsService().getRepositoryDetails();

        Assert.assertEquals(expected, repositoryDetails);
    }
}