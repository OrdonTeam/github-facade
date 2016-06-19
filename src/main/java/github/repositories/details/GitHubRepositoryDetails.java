package github.repositories.details;

public class GitHubRepositoryDetails {

    private String fullName;

    public GitHubRepositoryDetails(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GitHubRepositoryDetails that = (GitHubRepositoryDetails) o;

        return fullName != null ? fullName.equals(that.fullName) : that.fullName == null;

    }

    @Override
    public int hashCode() {
        return fullName != null ? fullName.hashCode() : 0;
    }
}
