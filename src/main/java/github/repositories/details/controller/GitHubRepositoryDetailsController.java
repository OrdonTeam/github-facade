package github.repositories.details.controller;

import github.repositories.details.GitHubRepositoryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GitHubRepositoryDetailsController {

    @Autowired
    GitHubRepositoryDetailsService service;

    @RequestMapping(value = "/repositories", method = RequestMethod.GET)
    public String getRepositoryDetails() {
        return "Ok";
    }
}
